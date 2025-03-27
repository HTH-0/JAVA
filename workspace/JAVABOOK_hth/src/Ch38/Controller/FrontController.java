package Ch38.Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {
	// 서브 컨트롤러
	private Map<String, SubController> map = new HashMap<>();
	
	// 싱글톤
	private static FrontController instance;
	private FrontController() {
		System.out.println("[Front] FrontController Init");
		init();
	}
	public static FrontController getrInstacne() {
		if(instance == null) {
			instance = new FrontController();
		}
		return instance;
	}
	
	
	// 초기화
	private void init() {
		// 인증 요청 API (EndPoint : 서브 컨트롤러 객체 저장)
		map.put("/user", new UserController());
	}
	
	// View 로부터 전달하는 요청 처리
	public Map<String, Object> execute (Map<String, Object> params){
		
		System.out.println("[Front] excute Invoke");
		String endPoint = (String)params.get("endPoint");
		SubController controller = map.get(endPoint);
		return controller.execute(params);
	}
}
