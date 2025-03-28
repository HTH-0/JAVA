package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {
	private Map<String, Controller> map = new HashMap<>();
	
	private static FrontController instance;
	private FrontController() {
		System.out.println("[FC] FrontController init...");
		init();
	}
	
	public static FrontController getInstance() {
		if(instance == null) {
			instance = new FrontController();
		}
		return instance;
	}
	
	// 초기화
	private void init() {
		map.put("/book", new BookController());
	}
	
	// View 로부터 전달 하는 요청 처리
	public Map<String, Object> execute (Map<String, Object> params){
		
		System.out.println("[FC] execute invoke..");
		String endPoint = (String)params.get("endPoint");
		Controller controller = map.get(endPoint);
		
		return controller.execute(params);
	
	}
	
	
	
}
