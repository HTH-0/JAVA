package Test;

import org.junit.jupiter.api.Test;
import Domain.BookDTO;
import Service.BookServiceImpl;

public class ServiceTest {
	
	@Test
	void inserttest() throws Exception{
		BookServiceImpl bookService = BookServiceImpl.getInstance();
		bookService.bookJoin(new BookDTO("q2ww2201","C언어기본","코리아미디어","1010-1010","asdfas","1324qwearf"));
	}
	@Test
	void updatetest() throws Exception {
		BookServiceImpl bookService = BookServiceImpl.getInstance();
		bookService.bookUpdate(new BookDTO("q2ww2201","C언어기본","코리아미디어","1010-1010","asdfas","1324qwearf"));
	}
	
	@Test
	void deleteTest() {
		
	}
	@Test
	void selectTest() throws Exception {
		BookServiceImpl bookService = BookServiceImpl.getInstance();
		bookService.bookSelect("12341234");
	}
}
