package Ch38.Tests.Dao;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Ch38.Domain.Dao.BookDao;
import Ch38.Domain.Dao.BookDaoImpl;
import Ch38.Domain.Dao.UserDao;
import Ch38.Domain.Dao.UserDaoImpl;
import Ch38.Domain.Dto.BookDto;
import Ch38.Domain.Dto.UserDto;

class DaoTests {

	@Test
	@Disabled
	void test1() throws Exception {
		
		UserDao userDaoImpl = UserDaoImpl.getInstance();
	}
	
	@Test
	void test2() throws Exception {
		UserDao userDaoImpl = UserDaoImpl.getInstance();
		userDaoImpl.insert(new UserDto("aabbccc","홍길동12","12341212",""));
	}
	
	@Test
	@Disabled
	void test3() throws Exception {
		BookDao bookDaoImpl = BookDaoImpl.getInstance();
		bookDaoImpl.insert(new BookDto("1111","리눅스다","한빛미디어","111-111"));
	}
	
	
	@Test
	@Disabled
	void test4() throws Exception {
		
	}
	
}
