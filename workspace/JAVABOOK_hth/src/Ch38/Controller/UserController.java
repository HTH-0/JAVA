package Ch38.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch38.Domain.Dto.UserDto;
import Ch38.Domain.Service.UserServiceImpl;

public class UserController implements SubController {

	// UserService
	private UserServiceImpl userService;

	Map<String, Object> response;

	public UserController() {
		try {
			userService = UserServiceImpl.getInstance();
		} catch (Exception e) {
			ExceptionHandler(e);
		}
	}

	// C(1) R(2) U(3) D(4) + Login(5) Logout(6)
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		// sub 컨트롤러에서 user 컨트롤러의 execute 메서드가 호출
		System.out.println("[SUB] UserController execute invoke");

		// 00
		response = new HashMap<>();
		Integer serviceNo = (Integer) params.get("serviceNo");

		if (serviceNo == null) {
			response.put("status", false);
			response.put("message", "유효하지 않은 서비스 요청입니다");
			return response;
		}
		try {
			
		switch (serviceNo) {
		case 1: // C. 회원가입
			System.out.println("[SUB] 회원가입 요청 확인");
			// 01 파라미터 받기
			String userid = (params.get("userid") != null) ? (String) params.get("userid") : null;
			String username = (params.get("username") != null) ? (String) params.get("username") : null;
			String password = (params.get("password") != null) ? (String) params.get("password") : null;
			String role = "ROLE_USER";
			UserDto userDto = new UserDto(userid, username, password, role);

			// 02 유효성 검증(Data Validation)
			boolean isOk = isValid(userDto);
			System.out.println("[No-1 회원가입] : 유효성 검증 확인 : " + isOk);
			if (!isOk) {
				response.put("status", false);
				response.put("message", "유효성 체크 오류 발생");
				return response;
			}
			// 03 관련 서비스 실행
			boolean isSuccess = userService.userJoin(userDto);
			// 04 뷰로 이동(or 내용 전달)
			if(isSuccess) {				
			response.put("status", isSuccess);			
			response.put("message", "회원가입 성공!");			
			}
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
			System.out.println("잘못된 서비스 번호 입니다.");
			response.put("status", false);
			response.put("message", "유효하지 않은 서비스 요청입니다");
		}
		}catch(Exception e) {
			ExceptionHandler(e);
		}

		return response;
	}

	private boolean isValid(UserDto userDto) {

		// NULL 체크 / 데이터(자료) 수준에서의 의미 있는 데이터가 포함되어져 있는지 여부
		if (userDto.getUserid() == null || userDto.getUserid().length() < 5) {
			response.put("Error", "userid의 길이는 최소 5자 이상 입니다.");
			System.out.println("[INVALID] userid의 길이는 최소 5자 이상 이어야 합니다.");
			return false;
		}
		// userid 는 첫 문자가 숫자인지 여부
		if (userDto.getUserid().matches("^[0-9].*")) {
			response.put("Error", "userid의 첫 문자는 숫자가 될 수 없습니다.");
			System.out.println("[INVALID] userid의 첫 문자는 숫자가 될 수 없습니다.");
			return false;
		}
		// username 은 첫 문자가 숫자인지 여부
		// password 복잡도 Business Layer 체크 (Policy 에 의한 처리)

		return true;
	}

	// 예외처리 함수
	public Map<String, Object> ExceptionHandler(Exception e) {
		if(response == null) {
			response = new HashMap<>();
		}
		response.put("status", false);
		response.put("message", e.getMessage());
		response.put("exception", e);

		return response;
	}

}
