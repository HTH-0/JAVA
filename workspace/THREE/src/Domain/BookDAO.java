package Domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
	
	int insert(BookDTO bookDTO) throws Exception;
	int update(BookDTO bookDTO) throws SQLException;
	int delete(String bookCode, Connection conn) throws SQLException;

	BookDTO select(BookDTO bookDTO);
	
	List<BookDTO> selectAll();
	
}
