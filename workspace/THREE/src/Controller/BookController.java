package Controller;

import java.util.HashMap;
import java.util.Map;

import Domain.BookDTO;
import Service.BookServiceImpl;

public class BookController implements Controller {

	private BookServiceImpl bookService;

	public BookController() {
		try {
			bookService = BookServiceImpl.getInstance();
		} catch (Exception e) {
			exceptionHandler(e);
		}
	}

	Map<String, Object> response;

	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		System.out.println("[SC] BookController execute invoke..!");
		// 00
		response = new HashMap<>();
		Integer serviceNo = (Integer) params.get("serviceNo");

		if (serviceNo == null) {
			response.put("status", false);
			response.put("message", "유효하지 않은 서비스 번호 입니다.");
		}
		try {
			switch (serviceNo) {
			
			case 1:
				System.out.println("[SUB] 도서 등록 요청 확인");

				// 파라미터 받기
				String book_code = (params.get("BOOK_CODE") != null) ? (String) params.get("BOOK_CODE") : null;
				String classification_id = (params.get("CLASSIFICATION_ID") != null)
						? (String) params.get("CLASSIFICATION_ID")
						: null;
				String book_author = (params.get("BOOK_AUTHOR") != null) ? (String) params.get("BOOK_AUTHOR") : null;
				String book_name = (params.get("BOOK_NAME") != null) ? (String) params.get("BOOK_NAME") : null;
				String publisher = (params.get("PUBLISHER") != null) ? (String) params.get("PUBLISHER") : null;
				String isreserve = (params.get("ISRESERVE") != null) ? (String) params.get("ISRESERVE") : null;
				BookDTO bookDTO = new BookDTO(book_code, classification_id, book_author, book_name, publisher,isreserve);
				
				// 유효성 검증
				boolean isOk = isValid(bookDTO);
				System.out.println("[No-1 회원가입] : 유효성 검증 확인 : " + isOk);
						
				if (!isOk) {
					response.put("status", false);
					return response;
				}
				
				// 관련 서비스 실행
				boolean isSuccess = bookService.bookJoin(bookDTO);
				if (isSuccess) {
					response.put("status", isSuccess);
					response.put("message", "회원가입 성공");
				}

				break;
				
			case 2:
				System.out.println();
				break;
			
			case 3:
				System.out.println();
				break;
				
			case 4:
				System.out.println();
				break;
				
			case 5:
				System.out.println("[SUB] 도서 삭제 요청 확인");
				// 삭제할 도서 코드 받기
				String deleteBookCode = (params.get("BOOK_CODE") != null) ? (String) params.get("BOOK_CODE") : null;

				if (deleteBookCode == null || deleteBookCode.trim().isEmpty()) {
					response.put("status", false);
					response.put("message", "삭제할 도서 코드가 필요합니다.");
					return response;
				}

				// 삭제 서비스 호출
				boolean deleteSuccess = bookService.bookDelete(deleteBookCode);

				if (deleteSuccess) {
					response.put("status", true);
					response.put("message", "도서 삭제 성공");
				} else {
					response.put("status", false);
					response.put("message", "도서 삭제 실패");
				}
				break;
				
			default:
				System.out.println("[SC] 잘못된 번호입니다.");
				response.put("status", false);
				response.put("message", "잘못된 번호입니다.");
			}
			
		} catch (Exception e) {
			exceptionHandler(e);
		}
		return response;
	}
	
	
	// 유효성 검사를 위한 메서드
	private boolean isValid(BookDTO bookDTO) {
		
		if(bookDTO.getBOOK_CODE() == null || bookDTO.getBOOK_CODE().length() <= 5 ) {
			response.put("ERROR", "북 코드는 5자 이상으로 만들어야합니다");
			return false;
		}
		return true;
	}
	
	
	// 예외 처리를 위한 메서드
	public Map<String, Object> exceptionHandler(Exception e){
		if(response == null) {
			response = new HashMap<>();
		}
		response.put("status", false);
		response.put("message", e.getMessage());
		response.put("exception", e);
	
		
		return response;
	}
}
