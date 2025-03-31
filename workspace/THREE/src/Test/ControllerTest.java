package Test;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import Controller.FrontController;

public class ControllerTest {

	FrontController fc = FrontController.getInstance();

	@Test
	void inserttest() {
		// View에서 요청정보 담기
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/book");// endPoint
		params.put("serviceNo", 1); // ServiceNo
		// 도서등록-인자전달
		params.put("BOOK_CODE", "21111112");
		params.put("CLASSIFICATION_ID", "이것이리눅스다");
		params.put("BOOK_AUTHOR", "한빛미디어");
		params.put("BOOK_NAME", "1111-1111");
		params.put("PUBLISHER", "ddddd");
		params.put("ISRESERVE", "1111-1111");
		// 요청하기
		Map<String, Object> response = fc.execute(params);

		// 응답확인
		for (String key : response.keySet()) {
			System.out.println(key + " : " + response.get(key));
		}

	}

	@Test
	void deleteTest() {
		// View에서 요청 정보 담기
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/book"); // endPoint
		params.put("serviceNo", 5); // 삭제 기능에 해당하는 service 번호

		// 삭제할 도서의 BOOK_CODE만 전달
		params.put("BOOK_CODE", "12341234");

		// 요청 처리
		Map<String, Object> response = fc.execute(params);

		// 응답 확인
		for (String key : response.keySet()) {
			System.out.println(key + " : " + response.get(key));
		}
	}

	@Test
	void UpdateTest() {
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/book");// endPoint
		params.put("serviceNo", 2); // ServiceNo
		// 인자전달
		params.put("BOOK_CODE", "12341234");
		params.put("CLASSIFICATION_ID", "이것이리눅스다");
		params.put("BOOK_AUTHOR", "한빛미디어");
		params.put("BOOK_NAME", "1111-1111");
		params.put("PUBLISHER", "ddddd");
		params.put("ISRESERVE", "1111-1111");
		// 요청하기
		Map<String, Object> response = fc.execute(params);

		// 응답확인
		for (String key : response.keySet()) {
			System.out.println(key + " : " + response.get(key));
		}
	}

	@Test
	void SelectTest() {
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/book");// endPoint
		params.put("serviceNo", 3); // ServiceNo

		params.put("BOOK_CODE", "12341234");
		// 요청하기
		Map<String, Object> response = fc.execute(params);

		// 응답확인
		for (String key : response.keySet()) {
			System.out.println(key + " : " + response.get(key));
		}
	}
	@Test
	void SelectAllTest() {
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/book");// endPoint
		params.put("serviceNo", 4); // ServiceNo
		
		Map<String, Object> response = fc.execute(params);

		// 응답확인
		for (String key : response.keySet()) {
			System.out.println(key + " : " + response.get(key));
		}
	}
}
