package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Domain.ConnectionPool.ConnectionItem;
import Domain.ConnectionPool.ConnectionPool;

public class BookDAOImpl implements BookDAO {

	// DB ATTR
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String id = "system";
	private String pw = "1234";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	// 싱글톤
	private static BookDAOImpl instance;

	private BookDAOImpl() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("BookDAOImpl DB Connection Success");

	}

	public static BookDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new BookDAOImpl();
		}
		return instance;
	}

	@Override
	public int insert(BookDTO bookDTO) throws Exception {
		PreparedStatement pstmt = null;
		Connection conn = null;

		try {
			// 여기 중요!!!
			ConnectionItem connItem = ConnectionPool.getInstance().getConnection();
			conn = connItem.getConn();

			pstmt = conn.prepareStatement("INSERT INTO book_tbl VALUES (?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, bookDTO.getBOOK_CODE());
			pstmt.setString(2, bookDTO.getCLASSIFICATION_ID());
			pstmt.setString(3, bookDTO.getBOOK_AUTHOR());
			pstmt.setString(4, bookDTO.getBOOK_NAME());
			pstmt.setString(5, bookDTO.getPUBLISHER());
			pstmt.setString(6, bookDTO.getISRESERVE());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("BookDAO's INSERT SQL EXCEPTION !!");
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception ignore) {
				}
		}
	}

	@Override
	public int update(BookDTO bookDTO) throws SQLException {

		return 0;
	}

	@Override
	public int delete(String bookCode, Connection conn) throws SQLException {
		try {

			pstmt = conn.prepareStatement("DELETE FROM book_tbl WHERE BOOK_CODE = ?");
			pstmt.setString(1, bookCode);

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("BookDAO's DELETE SQL EXCEPTION !!");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public BookDTO select(BookDTO bookDTO) {
		return null;
	}

	@Override
	public List<BookDTO> selectAll() {
		return null;
	}

}
