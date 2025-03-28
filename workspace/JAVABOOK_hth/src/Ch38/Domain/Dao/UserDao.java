package Ch38.Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dto.UserDto;

public interface UserDao {

	// CRUD
	int insert(UserDto userDto) throws Exception;

	int update(UserDto userDto);

	int delete(UserDto userDto);

	// 단건 조회
	UserDto select(UserDto userDto);

	// 다건 조회
	List<UserDto> selectAll();

}