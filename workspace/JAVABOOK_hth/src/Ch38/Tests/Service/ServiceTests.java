package Ch38.Tests.Service;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import Ch38.Domain.Dto.UserDto;
import Ch38.Domain.Service.UserServiceImpl;

public class ServiceTests {

	@Test
	void test() throws ClassNotFoundException, SQLException {
		UserServiceImpl userService = UserServiceImpl.getInstance();
		userService.userJoin(new UserDto("bbb", "남길동", "1234", "ROLE_USER"));
	}
}
