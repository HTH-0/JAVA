package Ch38.Tests.Controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Ch38.Controller.FrontController;

public class ControllerTests {
	FrontController fc = FrontController.getInstance();
	
	@Test
	void test1() {
		// View 에서 요청 정보 담기
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/user");
		params.put("serviceNo", 1);
		// 회원가입 인자 전달
		params.put("userid", "1c3cc");
		params.put("username", "홍길동");
		params.put("password", "1234");
		// 요청하기
		Map<String, Object> response = fc.execute(params);
	
		// 응답 확인
		for(String key : response.keySet()) {
			System.out.println(key + " : " + response.get(key));
		}
		
		
	}
	
	@Test
	@Disabled
	void test2() {
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/book");
		params.put("serviceNo", 1);
		
		params.put("bookCode", "책코드입니다ㅇㅇ");
		params.put("bookName", "책 이름");
		params.put("publisher","출판사");
		params.put("isbn", "12341234");
		// 요청
		Map<String, Object> response = fc.execute(params);
		
		for(String key : response.keySet()) {
			System.out.println(key + " : " + response.get(key));
		}
	}
	
}
