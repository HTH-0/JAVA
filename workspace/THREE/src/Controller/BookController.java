package Controller;

import java.util.HashMap;
import java.util.List;
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
		// 00
		response = new HashMap<>();
		Integer serviceNo = (Integer) params.get("serviceNo");

		if (serviceNo == null) {
			response.put("status", false);
			response.put("message", "유효하지 않은 서비스 번호 입니다.");
		}
		try {
			switch (serviceNo) {

			case 1: {// 지역변수용 중괄호
				System.out.println("[C] 도서 등록 요청 확인");

				// 파라미터 받기
				String book_code = (params.get("BOOK_CODE") != null) ? (String) params.get("BOOK_CODE") : null;
				String classification_id = (params.get("CLASSIFICATION_ID") != null)? (String) params.get("CLASSIFICATION_ID"): null;
				String book_author = (params.get("BOOK_AUTHOR") != null) ? (String) params.get("BOOK_AUTHOR") : null;
				String book_name = (params.get("BOOK_NAME") != null) ? (String) params.get("BOOK_NAME") : null;
				String publisher = (params.get("PUBLISHER") != null) ? (String) params.get("PUBLISHER") : null;
				String isreserve = (params.get("ISRESERVE") != null) ? (String) params.get("ISRESERVE") : null;
				BookDTO bookDTO = new BookDTO(book_code, classification_id, book_author, book_name, publisher,
						isreserve);

				// 유효성 검증
				boolean isOk = isValid(bookDTO);

				if (!isOk) {
					response.put("status", false);
					response.put("message", "유효성 검증 실패 - 입력값 확인 필요");
					return response;
				}

				// 관련 서비스 실행
				boolean isSuccess = bookService.bookJoin(bookDTO);
				if (isSuccess) {
					response.put("status", isSuccess);
					response.put("message", "Insert 성공");
				}
			}
				break;

			case 2:
			{
				System.out.println("[C] 도서 정보 수정 요청 확인");
				String book_code = (String) params.get("BOOK_CODE");
				String classification_id = (String) params.get("CLASSIFICATION_ID");
				String book_author = (String) params.get("BOOK_AUTHOR");
				String book_name = (String) params.get("BOOK_NAME");
				String publisher = (String) params.get("PUBLISHER");
				String isreserve = (String) params.get("ISRESERVE");

				BookDTO updateDTO = new BookDTO(book_code, classification_id, book_author, book_name, publisher,
						isreserve);
				boolean valid = isValid(updateDTO);
			    if (!valid) {
			        response.put("status", false);
			        return response;
			    }

			    boolean updateSuccess = bookService.bookUpdate(updateDTO);

			    if (updateSuccess) {
			        response.put("status", true);
			        response.put("message", "도서 수정 성공");
			    } else {
			        response.put("status", false);
			        response.put("message", "도서 수정 실패");
			    }
				break;
			}
			case 3:
			{
				System.out.println("[C] 도서 정보 조회 요청 확인");
			    String book_code = (String) params.get("BOOK_CODE");

			    BookDTO selectDTO = new BookDTO();
			    selectDTO.setBOOK_CODE(book_code);

			    boolean valid = isValid(selectDTO);
			    if (!valid) {
			        response.put("status", false);
			        return response;
			    }

			    // bookService가 BookDTO를 리턴하게 수정
			    BookDTO resultDTO = bookService.bookSelect(book_code);

			    if (resultDTO != null) {
			        response.put("status", true);
			        response.put("book", resultDTO); // Viewer에서 출력할 수 있도록
			    } else {
			        response.put("status", false);
			        response.put("message", "해당 도서를 찾을 수 없습니다.");
			    }

			    break;
			}
			case 4:
			{
			    System.out.println("[C] 도서 전체 조회 요청 확인");

			    List<BookDTO> book_code = bookService.bookSelectAll();

			    if (book_code != null && !book_code.isEmpty()) {
			        response.put("status", true);
			        response.put("book_code", book_code); // Viewer에서 사용
			    } else {
			        response.put("status", false);
			        response.put("message", "등록된 도서가 없습니다.");
			    }

			    break;
			}

			case 5:
				System.out.println("[C] 도서 삭제 요청 확인");
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
	// 유효성 검사를 위한 메서드
	private boolean isValid(BookDTO bookDTO) {

	    // BOOK_CODE: null 체크 + 길이 + 숫자 여부
	    if (bookDTO.getBOOK_CODE() == null || bookDTO.getBOOK_CODE().length() < 4) {
	        response.put("ERROR", "BOOK_CODE는 4자 이상으로 입력해야 합니다.");
	        return false;
	    }
	    try {
	        Integer.parseInt(bookDTO.getBOOK_CODE()); // 숫자인지 확인
	    } catch (NumberFormatException e) {
	        response.put("ERROR", "BOOK_CODE는 숫자 형식이어야 합니다.");
	        return false;
	    }

	    // CLASSIFICATION_ID: null 또는 숫자 형식인지 확인
	    if (bookDTO.getCLASSIFICATION_ID() == null) {
	        response.put("ERROR", "CLASSIFICATION_ID가 필요합니다.");
	        return false;
	    }
	    try {
	        Integer.parseInt(bookDTO.getCLASSIFICATION_ID());
	    } catch (NumberFormatException e) {
	        response.put("ERROR", "CLASSIFICATION_ID는 숫자 형식이어야 합니다.");
	        return false;
	    }

	    // ISRESERVE: 0 또는 1이어야 하고 숫자 형식이어야 함
	    if (bookDTO.getISRESERVE() == null) {
	        response.put("ERROR", "ISRESERVE 값이 필요합니다.");
	        return false;
	    }
	    try {
	        int isreserve = Integer.parseInt(bookDTO.getISRESERVE());
	        if (isreserve != 0 && isreserve != 1) {
	            response.put("ERROR", "ISRESERVE는 0 또는 1이어야 합니다.");
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        response.put("ERROR", "ISRESERVE는 숫자 형식이어야 합니다.");
	        return false;
	    }

	    // BOOK_NAME, BOOK_AUTHOR, PUBLISHER 등 기본 값 체크 (옵션)
	    if (bookDTO.getBOOK_NAME() == null || bookDTO.getBOOK_NAME().trim().isEmpty()) {
	        response.put("ERROR", "BOOK_NAME은 필수 입력입니다.");
	        return false;
	    }
	    if (bookDTO.getBOOK_AUTHOR() == null || bookDTO.getBOOK_AUTHOR().trim().isEmpty()) {
	        response.put("ERROR", "BOOK_AUTHOR는 필수 입력입니다.");
	        return false;
	    }
	    if (bookDTO.getPUBLISHER() == null || bookDTO.getPUBLISHER().trim().isEmpty()) {
	        response.put("ERROR", "PUBLISHER는 필수 입력입니다.");
	        return false;
	    }

	    return true;
	}


	// 예외 처리를 위한 메서드
	public Map<String, Object> exceptionHandler(Exception e) {
		if (response == null) {
			response = new HashMap<>();
		}
		response.put("status", false);
		response.put("message", e.getMessage());
		response.put("exception", e);

		return response;
	}
}
