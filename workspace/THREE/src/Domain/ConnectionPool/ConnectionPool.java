package Domain.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.XAConnection;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import oracle.jdbc.xa.client.OracleXADataSource;

public class ConnectionPool {
    private List<ConnectionItem> connectionPool;
    private final int size = 1;
//    private final int size = 10;

    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String id = "system";
    private String pw = "1234";

    private ConnectionPool() throws SQLException {
        this.connectionPool = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            OracleXADataSource xaDataSource = new OracleXADataSource();
            xaDataSource.setURL(url);
            xaDataSource.setUser(id);
            xaDataSource.setPassword(pw);

            XAConnection xaConnection = xaDataSource.getXAConnection();
            Connection conn = xaConnection.getConnection();
            XAResource xaResource = xaConnection.getXAResource();

            connectionPool.add(new ConnectionItem(conn, xaResource));
        }

        System.out.println("[CP] Connection size : " + connectionPool.size());
    }

    private static ConnectionPool instance;

    public static ConnectionPool getInstance() throws SQLException {
        if (instance == null)
            instance = new ConnectionPool();
        return instance;
    }

    public synchronized ConnectionItem getConnection() throws Exception {
        for (ConnectionItem connItem : connectionPool) {
            if (connItem.isUse()) {
                connItem.setUse(false);
                return connItem;
            }
        }
        throw new Exception("모든 Connection이 사용중인 상태입니다.");
    }

    public synchronized void releaseConnection(ConnectionItem connItem) {
        connItem.setUse(true);
    }

    // --------------------------
    // 분산 트랜잭션 처리
    // --------------------------
    public void beginTransaction() throws Exception {
        for (int i = 0; i < connectionPool.size(); i++) {
            ConnectionItem connItem = connectionPool.get(i);

            if (connItem.getInTransaction()) continue;

            Xid xid = createXid(100, i);
            connItem.setXid(xid);

            connItem.getXaResource().start(xid, XAResource.TMNOFLAGS);
            connItem.setInTransaction(true);
        }
    }

    public void commitTransaction() throws Exception {
        List<Xid> xidList = new ArrayList<>();

        try {
            // end 단계
            for (ConnectionItem connItem : connectionPool) {
                if (!connItem.getInTransaction()) continue;

                XAResource xaResource = connItem.getXaResource();
                Xid xid = connItem.getXid();
                xidList.add(xid);

                xaResource.end(xid, XAResource.TMSUCCESS);
            }

            // prepare 단계
            for (ConnectionItem connItem : connectionPool) {
                if (!connItem.getInTransaction()) continue;

                XAResource xaResource = connItem.getXaResource();
                Xid xid = connItem.getXid();

                int prepare = xaResource.prepare(xid);
                if (prepare != XAResource.XA_OK) {
                    throw new Exception("Prepare failed for one or more resources.");
                }
            }

            // commit 단계
            for (ConnectionItem connItem : connectionPool) {
                if (!connItem.getInTransaction()) continue;

                XAResource xaResource = connItem.getXaResource();
                Xid xid = connItem.getXid();

                xaResource.commit(xid, false);
                connItem.setInTransaction(false);
            }

            System.out.println("Distributed transaction committed successfully.");
        } catch (Exception e) {
            rollbackTransaction();
            throw e;
        }
    }

    public void rollbackTransaction() throws Exception {
        for (ConnectionItem connItem : connectionPool) {
            if (!connItem.getInTransaction()) continue;

            XAResource xaResource = connItem.getXaResource();
            Xid xid = connItem.getXid();

            if (xid == null) {
                System.err.println("Rollback skipped: XID is null for one connection.");
                connItem.setInTransaction(false);
                continue;
            }

            try {
                xaResource.rollback(xid);
                System.out.println("Rollback success for one connection.");
            } catch (Exception e) {
                System.err.println("Rollback failed for one connection: " +
                        e.getClass().getSimpleName() + " - " + e.getMessage());
                e.printStackTrace();
            } finally {
                connItem.setInTransaction(false);
            }
        }

        System.out.println("Distributed transaction rolled back.");
    }

    private static Xid createXid(int bid, int tid) {
        return new Xid() {
            private int formatId = 1;
            private byte[] branchQualifier = new byte[]{(byte) tid};
            private byte[] globalTransactionId = new byte[]{(byte) bid};

            @Override
            public int getFormatId() {
                return formatId;
            }

            @Override
            public byte[] getBranchQualifier() {
                return branchQualifier;
            }

            @Override
            public byte[] getGlobalTransactionId() {
                return globalTransactionId;
            }
        };
    }
}
