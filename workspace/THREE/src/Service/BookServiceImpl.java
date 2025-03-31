package Service;

import java.util.List;

import Domain.BookDAO;
import Domain.BookDAOImpl;
import Domain.BookDTO;

public class BookServiceImpl {
	
	private BookDAO bookDAO;
	private static BookServiceImpl instance;

	private BookServiceImpl() throws ClassNotFoundException {
		bookDAO = BookDAOImpl.getInstance();
		System.out.println("[Service] BookServiceImpl init.." );
	}

	public static BookServiceImpl getInstance() throws ClassNotFoundException {
		if (instance == null) {
			try {
				instance = new BookServiceImpl();
			} catch (Exception e) {
				System.err.println("[BookServiceImpl] 인스턴스 생성 실패: " + e.getMessage());
				e.printStackTrace();
				throw e; // 예외 반드시 다시 던지기
			}
		}
		return instance;
	}

	// JOIN (Insert)
	public boolean bookJoin(BookDTO bookDTO) throws Exception {
		int result = bookDAO.insert(bookDTO);
		return result > 0;
	}

	// UPDATE
	public boolean bookUpdate(BookDTO bookDTO) throws Exception {
		int result = bookDAO.update(bookDTO);
		return result > 0;
	}

	// SELECT
	public BookDTO bookSelect(String bookCode) throws Exception {
		BookDTO param = new BookDTO();
		param.setBOOK_CODE(bookCode);
		return bookDAO.select(param);
	}

	// SELECT ALL
	public List<BookDTO> bookSelectAll() {
		return bookDAO.selectAll();
	}

	// DELETE
	public boolean bookDelete(String bookCode) throws Exception {
		int result = bookDAO.delete(bookCode);
		return result > 0;
	}

}
