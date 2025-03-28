package Ch38.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dao.ConnectionPool.ConnectionItem;
import Ch38.Domain.Dao.ConnectionPool.ConnectionPool;
import Ch38.Domain.Dto.BookDto;

public class BookDaoImpl implements BookDao {

	// DB
//	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

//	private String id = "root";
//	private String pw = "1234";
//	private String url = "jdbc:mysql://localhost:3306/bookDB";

	// CONNECTION POOL
	private ConnectionPool connectionPool;
	private ConnectionItem connectionItem;

	private static BookDao instance;

	private BookDaoImpl() throws ClassNotFoundException, SQLException {
		System.out.println("[Dao] BookDaoImpl init..");
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection(url, id, pw);
//		System.out.println("BookDaoImpl DB Connection Success");
		connectionPool = ConnectionPool.getInstance();

	}

	public static BookDao getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new BookDaoImpl();
		}
		return instance;
	}

	// CRUD

	@Override
	public int insert(BookDto bookDto) throws Exception {
		String insertSQL = "INSERT INTO tbl_book VALUES(?, ?, ?, ?)";
		try {
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			pstmt = conn.prepareStatement(insertSQL);

			pstmt.setString(1, bookDto.getBookCode());
			pstmt.setString(2, bookDto.getBookName());
			pstmt.setString(3, bookDto.getPublisher());
			pstmt.setString(4, bookDto.getIsbn());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("'BookDao' INSERT SQLEXCEPTION");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public int update(BookDto bookDto) {
		return -1;
	}

	@Override
	public int delete(BookDto bookDto) {
		return -1;
	}

	// 단건 조회
	@Override
	public BookDto select(BookDto bookDto) {
		return null;
	}

	// 다건 조회
	@Override
	public List<BookDto> selectAll() {
		return null;
	}

}
