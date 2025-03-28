package Ch38.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch38.Domain.Dto.BookDto;

public class BookController implements SubController {
	Map<String, Object> response;
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {

		System.out.println("[SUB] BookController excute Invoke ..!");

		response = new HashMap<>();
		Integer serviceNo = (Integer) params.get("serviceNo");

		if (serviceNo == null) {
			response.put("status", false);
			response.put("message", "유효하지 않은 요청입니다.");
			return response;
		}
		try {
			
		switch (serviceNo) {
		case 1:
			System.out.println("[SUB] 회원가입 요청 확인");
			// 01 파라미터 받기
			String bookCode = (params.get("bookCode") != null) ? (String)params.get("bookCode") : null;
			String bookName = (params.get("bookName") != null) ? (String)params.get("bookName") : null;
			String publisher = (params.get("publisher") != null) ? (String)params.get("publisher") : null;
			String isbn = (params.get("isbn") != null) ? (String)params.get("isbn") : null;
			
			BookDto bookDto = new BookDto(bookCode, bookName, publisher, isbn);
			// 02 유효성 검증(Data Validation)
			// isValid에서 true 받았나?? >> 유효성 통과했나??
			boolean isOk = isValid(bookDto);
			System.out.println("[회원가입] 유효성 : " + isOk);

			if(isOk == false) {
				response.put("status", false);
				response.put("message", "유효성 체크 오류 발생");
				return response;
			}
			// 03 관련 서비스 실행

			// 04 뷰로 이동(or 내용 전달)
			break;
		case 2: // R. 회원 정보 조회
			System.out.println("[SUB] 회원 정보 조회 요청 확인");
			// 01 파라미터 받기

			// 02 유효성 검증(Data Validation)

			// 03 관련 서비스 실행

			// 04 뷰로 이동(or 내용 전달)
			break;

		case 3: // U. 회원 정보 수정
			System.out.println("[SUB] 회원 정보 수정 요청 확인");
			// 01 파라미터 받기

			// 02 유효성 검증(Data Validation)

			// 03 관련 서비스 실행

			// 04 뷰로 이동(or 내용 전달)
			break;

		case 4: // D. 회원 탈퇴
			System.out.println("[SUB] 회원 탈퇴 요청 확인");
			// 01 파라미터 받기

			// 02 유효성 검증(Data Validation)

			// 03 관련 서비스 실행

			// 04 뷰로 이동(or 내용 전달)
			break;

		case 5: // Login
			System.out.println("[SUB] Login 요청 확인");
			// 01 파라미터 받기

			// 02 유효성 검증(Data Validation)

			// 03 관련 서비스 실행

			// 04 뷰로 이동(or 내용 전달)
			break;

		case 6: // Logout
			System.out.println("[SUB] Logout 요청 확인");
			// 01 파라미터 받기

			// 02 유효성 검증(Data Validation)

			// 03 관련 서비스 실행

			// 04 뷰로 이동(or 내용 전달)
			break;
		default:
			System.out.println("잘못된 번호입니다.");
			response.put("stauts",false);
			response.put("message","유효하지 않은 요청입니다.");
		}
		}catch(Exception e) {
			ExceptionHandler(e);
		}

		return response;
	}
	
	private boolean isValid(BookDto bookDto) {
		
		// bookCode는 8글자만
		if(bookDto.getBookCode().length() != 8) {
			response.put("error","에러메세지");
			System.out.println("[Error] BookCode 의 길이는 8글자로 해야합니다.");
			return false;
		}
		// bookName은 255자 이하
		if(bookDto.getBookName().length() > 255) {
			response.put("error","에러메세지");
			System.out.println("[Error] BookName 의 길이는 255 이하여야 합니다.");
			return false;
		}
		
		return true;
	}
	
//	예외처리 함수
	public Map<String, Object> ExceptionHandler (Exception e){
		if(response == null) {
			response = new HashMap<>();
		}
		response.put("status", false);
		response.put("message", e.getMessage());
		response.put("exception", e);
		
		return response;
	}
}
