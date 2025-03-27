package Ch38.Domain.Dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dto.UserDto;


public class UserDaoImpl {
	
	// DB attr
	private Connection conn;
	private PreparedStatement  pstmt;
	private ResultSet rs;
	
	private String id= "root";
	private String pw= "1234";
	private String url= "jdbc:mysql://localhost:3306/bookDB";
	// 싱글톤 패턴 처리
	private static UserDaoImpl instance;	// UserDaoImpl 이 싱글톤
	
	// 예외 처리는 직접 하지 않고 컨트롤러로 넘긴다.
	
	private UserDaoImpl() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("UserDaoImpl DB Connection Success");
	};
	public static UserDaoImpl getInstance() throws ClassNotFoundException, SQLException {
		if(instance == null) {
			instance = new UserDaoImpl();	// 최초로 한번만
		}
		return instance;
	}
	
	// CRUD
	public int insert(UserDto userDto) throws SQLException {
		String insertSQL = "INSERT INTO tbl_user VALUES(?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(insertSQL);
			
			pstmt.setString(1, userDto.getUserid());
			pstmt.setString(2, userDto.getUsername());
			pstmt.setString(3, userDto.getPassword());
			pstmt.setString(4, "ROLE_USER");
			
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("'UserDao' INSERT SQLEXCEPTION");

		}finally {
			try {pstmt.close();}catch(Exception e) {}
		}
	}

	public int update(UserDto userDto) {
		return -1;
	} 
	
	public int delete(UserDto userDto) {
		return -1;
	} 
	// 단건 조회
	public UserDto select(UserDto userDto) {
		return null;
	} 
	// 다건 조회
	public List<UserDto> selectAll() {
		return null;
	} 
}
