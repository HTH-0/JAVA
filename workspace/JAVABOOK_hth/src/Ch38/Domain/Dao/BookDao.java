package Ch38.Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Ch38.Domain.Dto.BookDto;

public interface BookDao {

	int insert(BookDto bookDto) throws SQLException, Exception;

	int update(BookDto bookDto);

	int delete(BookDto bookDto);

	// 단건 조회
	BookDto select(BookDto bookDto);

	// 다건 조회
	List<BookDto> selectAll();

}