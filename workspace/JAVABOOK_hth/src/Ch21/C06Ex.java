package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class ChargeStation {
	private int no;
	private String section;
	private String station;
	private String name;
	private int zipcode;
	private String address;

	// Getter and Setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// toString
	@Override
	public String toString() {
		return "ChargeStation [no=" + no + ", section=" + section + ", station=" + station + ", name=" + name
				+ ", zipcode=" + zipcode + ", address=" + address + "]";
	}

	public ChargeStation(int no, String section, String station, String name, int zipcode, String address) {
		super();
		this.no = no;
		this.section = section;
		this.station = station;
		this.name = name;
		this.zipcode = zipcode;
		this.address = address;
	}

	// 모든 인자 생성자

}

public class C06Ex {
	// DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";

	// JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static void connect() throws Exception {
		// DB 연결코드
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 로딩 성공.");

		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB 연결 성공.");
	}

	public static void Select() throws Exception {
		// 전체 조회
		pstmt = conn.prepareStatement("SELECT * FROM charge_station");
		rs = pstmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				System.out.print(rs.getInt("순번") + " ");
				System.out.print(rs.getString("행정구역") + " ");
				System.out.print(rs.getString("지사") + " ");
				System.out.print(rs.getString("시설명") + " ");
				System.out.print(rs.getInt("우편번호") + " ");
				System.out.print(rs.getString("주소") + " ");
				System.out.println();
			}
		}
	}

	public static void Insert(ChargeStation obj) throws Exception {
		// ChargeStation 객체를 받아 내용 insert

		pstmt = conn.prepareStatement("INSERT INTO charge_station VALUES(?,?,?,?,?,?)");
		pstmt.setInt(1, obj.getNo());
		pstmt.setString(2, obj.getSection());
		pstmt.setString(3, obj.getStation());
		pstmt.setString(4, obj.getName());
		pstmt.setInt(5, obj.getZipcode());
		pstmt.setString(6, obj.getAddress());

		int result = pstmt.executeUpdate();

		if (result > 0)
			System.out.println("INSERT 성공");
		else
			System.out.println("INSERT 실패");

		freeConnection(pstmt);
	}

	// station을 수정하기
	// Update(1,2) station 1을 station 2로 바꾸게.
	public static void Update(String st1, String st2) throws Exception {
		// 수정 (station)
		pstmt = conn.prepareStatement("UPDATE charge_station SET station = ? WHERE 지사 = ?");
		pstmt.setString(1, st2);
		pstmt.setString(2, st1);

		int result = pstmt.executeUpdate();

		if (result > 0) {
			System.out.println("UPDATE 성공");
		} else {
			System.out.println("UPDATE 실패");
		}
		freeConnection(pstmt);

	}

	public static void Delete(String st1) throws Exception {
		// 삭제 (station)
		pstmt = conn.prepareStatement("DELETE FROM charge_station WHERE 지사 = ?");
		pstmt.setString(1, st1);

		int result = pstmt.executeUpdate();

		if (result > 0) {
			System.out.println("DELETE 성공");
		} else {
			System.out.println("DELETE 실패");
		}
		freeConnection(pstmt);
	}

	// 자원제거용 함수 오버로딩
	public static void freeConnection(Connection conn) throws Exception {
		if (conn != null)
			conn.close();
	}

	public static void freeConnection(PreparedStatement pstmt) throws Exception {
		if (pstmt != null)
			pstmt.close();
	}

	public static void freeConnection(PreparedStatement pstmt, ResultSet rs) throws Exception {

		if (pstmt != null)
			pstmt.close();
		if (rs != null)
			rs.close();
	}

	public static void main(String[] args) {
		try {
			connect();
			Insert(new ChargeStation(201, "대구광역시", "대구지사", "대구가스", 10101, "대구"));
//			Update("대구지사", "부산지사");
//			Delete("부산지사");
			Select();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
