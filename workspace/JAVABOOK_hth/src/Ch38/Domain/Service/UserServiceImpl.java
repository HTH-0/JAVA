package Ch38.Domain.Service;

import java.sql.SQLException;

import Ch38.Domain.Dao.UserDaoImpl;
import Ch38.Domain.Dto.UserDto;

public class UserServiceImpl {
	
	private UserDaoImpl userDao;
	
	// SingleTon
	
	private static UserServiceImpl instance;

	private UserServiceImpl() throws ClassNotFoundException, SQLException {
		userDao = UserDaoImpl.getInstance();
		System.out.println("[SERVICE] UserServiceImpl init ..");
	};

	public static UserServiceImpl getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	// 회원가입 (TX처리 필요)
	public boolean userJoin(UserDto userDto) throws SQLException{
		return userDao.insert(userDto) > 0;
	}
	
	// 회원조회
	
	// 회원 정보수정

	// 회원탈퇴
	
	// 로그인
	
	// 로그아웃
	
	
}
