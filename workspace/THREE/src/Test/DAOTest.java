package Test;

import org.junit.jupiter.api.Test;

import Domain.BookDAO;
import Domain.BookDAOImpl;
import Domain.BookDTO;


public class DAOTest {
	
	@Test
	void test1() throws Exception{
		BookDAO bookDAOImpl = BookDAOImpl.getInstance();
	}
	
	
	@Test
	void test2() throws Exception {
		BookDAO bookDAOImpl = BookDAOImpl.getInstance();
		bookDAOImpl.insert(new BookDTO("aabbccc","홍길동12","12341212","11234","qwerq","asdf"));
	}
}
