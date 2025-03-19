package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class 문제2 {
	private static String id = "root";
	private static String pw = "1234";
	private static String url = "jdbc:mysql://localhost:3306/tmpdb";

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public static void conn() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success...");

		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB CONNECTED...");
	}

	// SelectAll
	public static List<BookDto> selectAll() throws SQLException {

		List<BookDto> booklist = new ArrayList<>();
		pstmt = conn.prepareStatement("SELECT * FROM tbl_book");
		rs = pstmt.executeQuery();

		while (rs.next()) {
			booklist.add(new BookDto(
					rs.getLong("bookCode"), 
					rs.getString("bookName"), 
					rs.getString("publisher"),
					rs.getString("isbn")));
		}
		return booklist;

	}

	// select one
	public static BookDto select(Long bookCode) throws SQLException {

		pstmt = conn.prepareStatement("SELECT * FROM tbl_book WHERE `bookCode` = ?");
		pstmt.setLong(1, bookCode);

		rs = pstmt.executeQuery();

		while (rs.next()) {
			return new BookDto(
					rs.getLong("bookCode"), 
					rs.getString("bookName"), 
					rs.getString("publisher"),
					rs.getString("isbn"));
		}

		return null;
	}

	public static int insertBook(BookDto bookdto) throws SQLException {

		pstmt = conn.prepareStatement("INSERT INTO tbl_book VALUES (?, ?, ?, ?)");
		pstmt.setLong(1, bookdto.getBookCode());
		pstmt.setString(2, bookdto.getBookName());
		pstmt.setString(3, bookdto.getPublisher());
		pstmt.setString(4, bookdto.getIsbn());
		int result = pstmt.executeUpdate();
		return result;
	}

	public static int updateBook(BookDto bookdto) throws SQLException {
		pstmt = conn.prepareStatement(
				"UPDATE tbl_book SET `bookName` = ?, `publisher` = ?, `isbn` = ? WHERE `bookCode` = ? ");
		pstmt.setString(1, bookdto.getBookName());
		pstmt.setString(2, bookdto.getPublisher());
		pstmt.setString(3, bookdto.getIsbn());
		pstmt.setLong(4, bookdto.getBookCode());

		int result = pstmt.executeUpdate();

		return result;
	}

	public static int deleteBook(Long bookCode) throws SQLException {
		pstmt = conn.prepareStatement("DELETE FROM tbl_book WHERE `bookCode` = ?");
		pstmt.setLong(1, bookCode);

		int result = pstmt.executeUpdate();
		return result;
	}

	public static void main(String[] args) throws SQLException {
		try {

			// DB Conn
			conn();

			// Tx start
			conn.setAutoCommit(false);

			// Insert
			insertBook(new BookDto(1L, "도서명1", "출판사명1", "isbn-1"));
			insertBook(new BookDto(2L, "도서명2", "출판사명2", "isbn-2"));
			insertBook(new BookDto(3L, "도서명3", "출판사명3", "isbn-3"));

			// SelcetAll
			List<BookDto> allBook = selectAll();
			System.out.println("selectAll : ");
			allBook.forEach(el -> System.out.println(el));

			// Select
			BookDto dto = select(1L);
			System.out.println("select : " + dto);

			// Update
			dto.setBookName("수정도서명-2");
			dto.setPublisher("수정출판사명-2");
			int r1 = updateBook(dto);
			if (r1 > 0) {
				System.out.println("수정완료 : " + r1);
			}

			// Delete
			int r2 = deleteBook(2L);
			if (r2 > 0) {
				System.out.println("삭제완료 : " + r2);
			}

			// Tx end
			conn.commit();

		} catch (Exception e) {
			// Tx RollbackAll
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
