package Ch38.Controller;

import java.util.Map;

public class UserController implements SubController{
	
	
	// C(1) R(2) U(3) D(4) + Login(5) Logout(6)
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		// sub 컨트롤러에서 user 컨트롤러의 execute 메서드가 호출
		System.out.println("[Sub] UserController execute invoke");
		
		// 01 파라미터 받기
		
		// 02 유효성 검증(Data Validation)
		
		// 03 관련 서비스 실행
		
		// 04 뷰로 이동(or 내용 전달)
		
		return null;
	}
	
}
