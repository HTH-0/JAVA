


package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

	private String id = "system";
	private String pw = "1234";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	private static BookDAOImpl instance;

	private BookDAOImpl() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("[DB] BookDAOImpl DB Driver 로딩 완료.");
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
	    Connection conn = getConnection();
	    conn.setAutoCommit(true);
	    String sql = "INSERT INTO book_tbl VALUES (?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, Integer.parseInt(bookDTO.getBOOK_CODE()));
	        pstmt.setInt(2, Integer.parseInt(bookDTO.getCLASSIFICATION_ID()));
	        pstmt.setString(3, bookDTO.getBOOK_AUTHOR());
	        pstmt.setString(4, bookDTO.getBOOK_NAME());
	        pstmt.setString(5, bookDTO.getPUBLISHER());
	        pstmt.setInt(6, Integer.parseInt(bookDTO.getISRESERVE()));
	        return pstmt.executeUpdate();

	    } catch (SQLIntegrityConstraintViolationException e) {
	        // 외래키, 유일성 제약 조건 오류 처리
	        System.err.println("❌ 제약 조건 위반 - 분류 ID 존재 여부를 확인하세요.");
	        throw new SQLIntegrityConstraintViolationException("분류 ID가 존재하지 않아 등록 실패");  // 서비스단에서 메시지로 구분 가능

	    } catch (SQLException e) {
	        // 그 외 일반 SQL 예외
	        e.printStackTrace();
	        throw new SQLException("BookDAO의 일반 SQL 오류 발생: " + e.getMessage());
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

	        int result = pstmt.executeUpdate();

	        if (result == 0) {
	            // 수정된 행이 없다는 건 -> BOOK_CODE가 존재하지 않음
	            System.err.println("❌ 수정 실패: 존재하지 않는 BOOK_CODE입니다.");
	        }

	        return result;

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
	        int result = pstmt.executeUpdate();

	        if (result == 0) {
	            // 💥 삭제된 행이 없음 → 해당 BOOK_CODE가 없음
	            System.err.println("❌ 삭제 실패: 존재하지 않는 BOOK_CODE입니다.");
	        }

	        return result;

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
					return new BookDTO(rs.getString("BOOK_CODE"), rs.getString("CLASSIFICATION_ID"),
							rs.getString("BOOK_AUTHOR"), rs.getString("BOOK_NAME"), rs.getString("PUBLISHER"),
							rs.getString("ISRESERVE"));
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
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				BookDTO dto = new BookDTO(rs.getString("BOOK_CODE"), rs.getString("CLASSIFICATION_ID"),
						rs.getString("BOOK_AUTHOR"), rs.getString("BOOK_NAME"), rs.getString("PUBLISHER"),
						rs.getString("ISRESERVE"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
