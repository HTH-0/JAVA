package Ch38.Tests.Service;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import Ch38.Domain.Dto.BookDto;
import Ch38.Domain.Dto.UserDto;
import Ch38.Domain.Service.BookServiceImpl;
import Ch38.Domain.Service.UserServiceImpl;

public class ServiceTests {

	@Test
	void test1() throws ClassNotFoundException, SQLException {
		UserServiceImpl userService = UserServiceImpl.getInstance();
		userService.userJoin(new UserDto("bbb", "남길동", "1234", "ROLE_USER"));
	}
	
	@Test
	void test2() throws SQLException, ClassNotFoundException {
		BookServiceImpl bookService = BookServiceImpl.getInstance();
		bookService.bookJoin(new BookDto("책코드2", "책 이름2", "출판사2", "isbn2"));
	}
}
