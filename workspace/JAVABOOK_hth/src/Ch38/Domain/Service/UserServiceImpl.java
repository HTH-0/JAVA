package Ch38.Domain.Service;

import java.sql.SQLException;

import Ch38.Domain.Dao.UserDao;
import Ch38.Domain.Dao.UserDaoImpl;
import Ch38.Domain.Dao.ConnectionPool.ConnectionPool;
import Ch38.Domain.Dto.UserDto;

public class UserServiceImpl {

	private UserDao userDao;

	private ConnectionPool connectionPool;

	// SingleTon

	private static UserServiceImpl instance;

	private UserServiceImpl() throws Exception {
		userDao = UserDaoImpl.getInstance();
		connectionPool = ConnectionPool.getInstance();
		System.out.println("[SERVICE] UserServiceImpl init ..");
	};

	public static UserServiceImpl getInstance() throws Exception {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}

	// 회원가입 (TX처리 필요)
	public boolean userJoin(UserDto userDto) throws Exception {

		try {
			
			connectionPool.beginTransaction();
			
//			userDao.insert(userDto);
			userDao.insert(new UserDto("aaaaa", "", "", ""));
			userDao.insert(new UserDto("afffa", "", "", ""));
			userDao.insert(new UserDto("aaaaa", "", "", ""));
			
			
			connectionPool.commitTransaction();
		} catch (SQLException e) {
			// rollback
			connectionPool.rollbackTransaction();
		}
		return true;
	}

	// 회원조회

	// 회원 정보수정

	// 회원탈퇴

	// 로그인

	// 로그아웃

}
