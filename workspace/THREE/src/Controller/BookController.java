

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
		response = new HashMap<>();
		Integer serviceNo = (Integer) params.get("serviceNo");

		if (serviceNo == null) {
			response.put("status", false);
			response.put("message", "유효하지 않은 서비스 번호입니다.");
			return response;
		}

		try {
			switch (serviceNo) {

			case 1: { // Insert
				System.out.println("[C] 도서 등록 요청 확인");
				String book_code = (String) params.get("BOOK_CODE");
				String classification_id = (String) params.get("CLASSIFICATION_ID");
				String book_author = (String) params.get("BOOK_AUTHOR");
				String book_name = (String) params.get("BOOK_NAME");
				String publisher = (String) params.get("PUBLISHER");
				String isreserve = (String) params.get("ISRESERVE");

				BookDTO bookDTO = new BookDTO(book_code, classification_id, book_author, book_name, publisher, isreserve);

				if (!isValid(bookDTO, serviceNo)) {
					response.put("status", false);
					response.put("message", "유효성 검증 실패 - 입력값 확인 필요");
					return response;
				}

				boolean isSuccess = bookService.bookJoin(bookDTO);
				if (isSuccess) {
					response.put("status", true);
					response.put("message", "Insert 성공");
				} else {
					response.put("status", false);
					response.put("message", "Insert 실패");
				}
				break;
			}

			case 2: { // Update
				System.out.println("[C] 도서 정보 수정 요청 확인");
				String book_code = (String) params.get("BOOK_CODE");
				String classification_id = (String) params.get("CLASSIFICATION_ID");
				String book_author = (String) params.get("BOOK_AUTHOR");
				String book_name = (String) params.get("BOOK_NAME");
				String publisher = (String) params.get("PUBLISHER");
				String isreserve = (String) params.get("ISRESERVE");

				BookDTO updateDTO = new BookDTO(book_code, classification_id, book_author, book_name, publisher, isreserve);

				if (!isValid(updateDTO, serviceNo)) {
					response.put("status", false);
					return response;
				}

				boolean updateSuccess = bookService.bookUpdate(updateDTO);
				response.put("status", updateSuccess);
				response.put("message", updateSuccess ? "도서 수정 성공" : "도서 수정 실패");
				break;
			}

			case 3: { // Select
				System.out.println("[C] 도서 정보 조회 요청 확인");
				String book_code = (String) params.get("BOOK_CODE");

				BookDTO selectDTO = new BookDTO();
				selectDTO.setBOOK_CODE(book_code);

				if (!isValid(selectDTO, serviceNo)) {
					response.put("status", false);
					return response;
				}

				BookDTO resultDTO = bookService.bookSelect(book_code);
				if (resultDTO != null) {
					response.put("status", true);
					response.put("book", resultDTO);
				} else {
					response.put("status", false);
					response.put("message", "해당 도서를 찾을 수 없습니다.");
				}
				break;
			}

			case 4: { // Select All
				System.out.println("[C] 도서 전체 조회 요청 확인");
				List<BookDTO> bookList = bookService.bookSelectAll();
				if (bookList != null && !bookList.isEmpty()) {
					response.put("status", true);
					response.put("book_code", bookList);
				} else {
					response.put("status", false);
					response.put("message", "등록된 도서가 없습니다.");
				}
				break;
			}

			case 5: { // Delete
				System.out.println("[C] 도서 삭제 요청 확인");
				String deleteBookCode = (String) params.get("BOOK_CODE");

				if (deleteBookCode == null || deleteBookCode.trim().isEmpty()) {
					response.put("status", false);
					response.put("message", "삭제할 도서 코드가 필요합니다.");
					return response;
				}

				boolean deleteSuccess = bookService.bookDelete(deleteBookCode);
				response.put("status", deleteSuccess);
				response.put("message", deleteSuccess ? "도서 삭제 성공" : "도서 삭제 실패");
				break;
			}

			default:
				response.put("status", false);
				response.put("message", "잘못된 서비스 번호입니다.");
			}

		} catch (Exception e) {
			exceptionHandler(e);
		}
		return response;
	}

	// 유효성 검사 메서드 (서비스 번호로 구분)
	private boolean isValid(BookDTO bookDTO, int serviceNo) {

		// 공통 - BOOK_CODE
		if (bookDTO.getBOOK_CODE() == null || bookDTO.getBOOK_CODE().length() < 5) {
			response.put("ERROR", "BOOK_CODE는 5자 이상으로 입력해야 합니다.");
			return false;
		}
		try {
			Integer.parseInt(bookDTO.getBOOK_CODE());
		} catch (NumberFormatException e) {
			response.put("ERROR", "BOOK_CODE는 숫자 형식이어야 합니다.");
			return false;
		}

		// Insert & Update 시 추가 유효성 검사
		if (serviceNo == 1 || serviceNo == 2) {
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
		}

		return true;
	}

	// ✅ 예외 처리
	public Map<String, Object> exceptionHandler(Exception e) {
		if (response == null) {
			response = new HashMap<>();
		}
		response.put("status", false);
		response.put("message", "도서 처리 중 오류 발생: " + e.getMessage());
		response.put("exception", e);
		return response;
	}
}
