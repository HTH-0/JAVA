package Ch38.Tests.Controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Ch38.Controller.FrontController;

class ControllerTests {

	FrontController fc = FrontController.getInstance();
	
	@Test
	void test() {
		//View에서 요청정보 담기
		Map<String,Object> params = new HashMap();
		params.put("endPoint", "/book");//endPoint
		params.put("serviceNo", 1);	//ServiceNo
		//회원가입-인자전달
//		params.put("userid","ccccc");
//		params.put("username","홍길동");
//		params.put("password","1234");
		
		//도서등록-인자전달
		params.put("bookCode","21111112");
		params.put("bookName","이것이리눅스다");
		params.put("publisher","한빛미디어");
		params.put("isbn","1111-1111");
		//요청하기
		Map<String,Object> response =  fc.execute(params);
		
		//응답확인
		for(String key : response.keySet()) {
			System.out.println(key + " : " + response.get(key));
		}
		
		
	}

	
	@Test
	@Disabled
	void test_99() {
		
	}

}
