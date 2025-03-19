package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C08Tx {
	
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";
	
	
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success..");
			
			conn = DriverManager.getConnection(url, id, pw);
			
			System.out.println("DB CONNECTED..");
			
			
			System.out.println("INSERT 시작..");
			
			conn.setAutoCommit(false);
				
			pstmt = conn.prepareStatement("INSERT INTO tbl_std VALUES('a', 1, 'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("INSERT INTO tbl_std VALUES('b', 1, 'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("INSERT INTO tbl_std VALUES('c', 1, 'a')");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("INSERT INTO tbl_std VALUES('d', 1, 'a')");
			pstmt.executeUpdate();
			conn.commit();
			
			System.out.println("INSERT 종료");
			
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			try {pstmt.close();}catch(Exception e2) {};
		}
	}
}
