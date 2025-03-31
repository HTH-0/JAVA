package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

	private String id = "system";
	private String pw = "1234";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	private static BookDAOImpl instance;

	private BookDAOImpl() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("BookDAOImpl DB Driver Loaded");
	}

	public static BookDAO getInstance() throws ClassNotFoundException {
		if (instance == null) {
			instance = new BookDAOImpl();
		}
		return instance;
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, id, pw);
	}

	@Override
	public int insert(BookDTO bookDTO) throws Exception {
		String sql = "INSERT INTO book_tbl VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
		}
	}

	@Override
	public int update(BookDTO bookDTO) throws Exception {
		String sql = "UPDATE book_tbl SET CLASSIFICATION_ID = ?, BOOK_AUTHOR = ?, BOOK_NAME = ?, PUBLISHER = ?, ISRESERVE = ? WHERE BOOK_CODE = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, bookDTO.getCLASSIFICATION_ID());
			pstmt.setString(2, bookDTO.getBOOK_AUTHOR());
			pstmt.setString(3, bookDTO.getBOOK_NAME());
			pstmt.setString(4, bookDTO.getPUBLISHER());
			pstmt.setString(5, bookDTO.getISRESERVE());
			pstmt.setString(6, bookDTO.getBOOK_CODE());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("BookDAO's UPDATE SQL EXCEPTION !!");
		}
	}

	@Override
	public int delete(String book_code) throws SQLException {
		String sql = "DELETE FROM book_tbl WHERE BOOK_CODE = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, book_code);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("BookDAO DELETE 실패");
		}
	}

	@Override
	public BookDTO select(BookDTO bookDTO) {
		String sql = "SELECT * FROM book_tbl WHERE BOOK_CODE = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, bookDTO.getBOOK_CODE());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new BookDTO(
						rs.getString("BOOK_CODE"),
						rs.getString("CLASSIFICATION_ID"),
						rs.getString("BOOK_AUTHOR"),
						rs.getString("BOOK_NAME"),
						rs.getString("PUBLISHER"),
						rs.getString("ISRESERVE")
					);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookDTO> selectAll() {
		List<BookDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM book_tbl ORDER BY BOOK_CODE";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				BookDTO dto = new BookDTO(
					rs.getString("BOOK_CODE"),
					rs.getString("CLASSIFICATION_ID"),
					rs.getString("BOOK_AUTHOR"),
					rs.getString("BOOK_NAME"),
					rs.getString("PUBLISHER"),
					rs.getString("ISRESERVE")
				);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
