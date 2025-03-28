package Ch38.Domain.Service;

import java.sql.SQLException;

import Ch38.Domain.Dao.BookDao;
import Ch38.Domain.Dao.BookDaoImpl;
import Ch38.Domain.Dto.BookDto;

public class BookServiceImpl {
	private BookDao bookDao;
	
	
	// SingleTon
	private static BookServiceImpl instance;
	private BookServiceImpl() throws ClassNotFoundException, SQLException {
		bookDao = BookDaoImpl.getInstance();
		System.out.println("[SERVICE] BookService Impl init..");
	}
	
	public static BookServiceImpl getInstance() throws ClassNotFoundException, SQLException {
		if(instance == null) {
			instance = new BookServiceImpl();
		}
		return instance;
	}
	
	public boolean bookJoin(BookDto bookDto) throws Exception {
		return bookDao.insert(bookDto) > 0;
	}
	
}
