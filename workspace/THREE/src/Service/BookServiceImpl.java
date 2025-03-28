package Service;

import java.sql.Connection;
import java.sql.SQLException;

import Domain.BookDAO;
import Domain.BookDAOImpl;
import Domain.BookDTO;
import Domain.ConnectionPool.ConnectionItem;
import Domain.ConnectionPool.ConnectionPool;

public class BookServiceImpl {
	
	private BookDAO bookDAO;
	private ConnectionPool connectionPool;
	
	
	private static BookServiceImpl instance;
	private BookServiceImpl() throws ClassNotFoundException, SQLException {
		bookDAO = BookDAOImpl.getInstance();
		connectionPool = ConnectionPool.getInstance();
		System.out.println("[Service] BookServiceImpl init..");
	}
	public static BookServiceImpl getInstance() throws ClassNotFoundException, SQLException {
		if(instance == null) {
			instance = new BookServiceImpl();
		}
		return instance;
	}
	
	// 회원가입 (tx)
	public boolean bookJoin(BookDTO bookDTO) throws Exception {
		boolean isJoin = false;
		try {
	        connectionPool.beginTransaction();

	        int result = bookDAO.insert(bookDTO);
	        if (result <= 0) {
	            throw new Exception("도서 등록 실패 (insert 결과 0)");
	        }

	        isJoin = true;
	        connectionPool.commitTransaction();

	    } catch (Exception e) {
	        System.err.println("[bookJoin] 예외 발생 → 롤백 수행");
	        connectionPool.rollbackTransaction();
	        e.printStackTrace();
	        throw e; // 상위로 예외 전달
	    }
		
		
		return  isJoin;

	}
	public boolean bookDelete(String bookCode) throws Exception {
	    ConnectionItem connItem = null;
	    try {
	        connItem = connectionPool.getConnection(); // 커넥션 꺼내오기
	        Connection conn = connItem.getConn(); // 이 커넥션은 기본적으로 autoCommit = true일 가능성 높음

	        int result = bookDAO.delete(bookCode, conn);
	        return result > 0;
	    } finally {
	        if (connItem != null) {
	            connItem.getConn().close(); // 연결 닫기
	            connectionPool.releaseConnection(connItem); // 풀에 반환
	        }
	    }
	}
//	public boolean bookRegistration(BookDTO bookDTO) throws Exception {
//		return bookDAO.insert(bookDTO) > 0;
//	}
}
