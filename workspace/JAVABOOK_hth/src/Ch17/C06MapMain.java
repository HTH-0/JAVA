package Ch17;

import java.util.HashMap;
import java.util.Map;
public class C06MapMain {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();

		// 추가
		map.put("aaa", 11);
		map.put("bbb", 22);
		map.put("ccc", 33);
		map.put("ddd", 44);
		map.put("ddd", 34); // 중복 key
		map.put("eee", 55);

		// 삭제
		map.remove("aaa");
		
		
		// 조회
		System.out.println("Size : " + map.size());
		System.out.println("단건 : " + map.get("bbb"));
		System.out.println("복수건 : " + map);
		
		// for
		for(String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		
	}
}
