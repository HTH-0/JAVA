package Ch38.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch38.Domain.Dto.BookDto;
import Ch38.Domain.Service.BookServiceImpl;

public class BookController implements SubController {
	
	private BookServiceImpl bookService;
	
	
	public BookController() {
		try {
			bookService = BookServiceImpl.getInstance();
		}catch(Exception e) {
			exceptionHandler(e);
		}
	}
	
	
	Map<String, Object> response;
	//C(1)R(2)U(3)D(4) 
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		System.out.println("[SC] BookController execute invoke..!");
		//00 
		response = new HashMap();
		Integer serviceNo =(Integer)params.get("serviceNo");
		if(serviceNo==null) {
			response.put("status", false);
			response.put("message", "유효하지 않은 서비스 요청입니다.");
			return response;
		}
		switch(serviceNo) {
			case 1:			//C - 도서등록(ROLE-사서,관리자)
				System.out.println("[SC] 도서등록 요청 확인");
				//01 파라미터받기
				String bookCode = (params.get("bookCode")!=null)?(String) params.get("bookCode"):null;
				String bookName=(params.get("bookName")!=null)?(String) params.get("bookName"):null;
				String publisher=(params.get("publisher")!=null)?(String) params.get("publisher"):null;
				String isbn=(params.get("isbn")!=null)?(String) params.get("isbn"):null;
				
				BookDto bookDto = new BookDto(bookCode,bookName,publisher,isbn);
				if(!isValid(bookDto)){
					response.put("status", false);
					return response;
				}
				
				//02 유효성검증(Data Validation)
				//03 관련 서비스 실행
				//04 뷰로 이동(or 내용전달)
				break;
			case 2:			//R - 도서조회(ROLE-회원,사서,관리자)
				System.out.println("[SC] 도서조회 요청 확인");
				//01 파라미터받기
				//02 유효성검증(Data Validation)
				//03 관련 서비스 실행
				//04 뷰로 이동(or 내용전달)
				break;
			case 3:			//U - 도서수정(ROLE-사서,관리자)
				System.out.println("[SC] 도서수정 수정 요청 확인");
				//01 파라미터받기
				//02 유효성검증(Data Validation)
				//03 관련 서비스 실행
				//04 뷰로 이동(or 내용전달)
				break;
			case 4:			//D - 도서삭제(ROLE_사서,관리자)
				System.out.println("[SC] 도서삭제 요청 확인");
				//01 파라미터받기
				//02 유효성검증(Data Validation)
				//03 관련 서비스 실행
				//04 뷰로 이동(or 내용전달)
				break;
			default :
				System.out.println("[SC] 잘못된 서비스번호 요청 확인");
				response.put("status", false);
				response.put("message", "잘못된 서비스번호 요청입니다.");
		}

		
		return response;
	}
	//
	private boolean isValid(BookDto bookDto) {
//		유효성 체크(isValid) 함수 완성합니다
//		ServiceNo  : 1
//		bookCode 는 기본 8글자만 허용
//		bookName 의 길이는 255자를 넘기면 안됩니다
//
//		필요하면 정규표현식(String.matchs("REG STRING"))
//		이용해서 필터링 해보세요 - !

		if(bookDto.getBookCode()==null || bookDto.getBookCode().length()!=8){ 
			response.put("error","bookCode의 길이는 8자 이어야 합니다");
			return false;
		}
		
		return true;
	}
	
	// 예외처리함수
	public Map<String, Object> exceptionHandler(Exception e) {

		if (response == null)
			response = new HashMap();

		response.put("status", false);
		response.put("message", e.getMessage());
		response.put("exception", e);

		return response;
	}
	

}
