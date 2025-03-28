package Ch38.Tests.Dao;

import org.junit.jupiter.api.Test;

import Ch38.Domain.Dao.BookDao;
import Ch38.Domain.Dao.BookDaoImpl;
import Ch38.Domain.Dao.UserDao;
import Ch38.Domain.Dao.UserDaoImpl;
import Ch38.Domain.Dto.BookDto;
import Ch38.Domain.Dto.UserDto;

public class DaoTests {
	
	@Test
	void test1() throws Exception {
		UserDao userDaoImpl = UserDaoImpl.getInstance();
	}
	
	@Test
	void test2() throws Exception {
		UserDao userDaoImpl = UserDaoImpl.getInstance();
		userDaoImpl.insert(new UserDto("aaddd1", "홍길동", "1234", "아무거나"));
	}

	@Test
	void test3() throws Exception {
		BookDao bookDaoImpl = BookDaoImpl.getInstance();
		bookDaoImpl.insert(new BookDto("책코드","책이름", "출판사", "isbn"));
	}
	
}
