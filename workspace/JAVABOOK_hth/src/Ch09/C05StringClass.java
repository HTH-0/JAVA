package Ch09;

public class C05StringClass {
	public static void main(String[] args) {
	
		String str1 = "Java Powerful";
//		String str2 = new String("Java Powerful");
//		String str3 = str1 + str2;
//		String str4 = str1.concat(str2);
		
//		System.out.printf("%X\n", System.identityHashCode(str1));
//		System.out.printf("%X\n", System.identityHashCode(str2));
//		System.out.printf("%X\n", System.identityHashCode(str3));
//		System.out.printf("%X\n", System.identityHashCode(str4));
		
		
		// 문자열 덧붙이기 (메모리 누구 방지 클래스 : StringBuilder, StringBuffer)
		
//		int i = 0;
//		String str = "";
//		StringBuilder str = new StringBuilder("");
		
//		while(i<10) {
//			str += i;
//			str.append(i);
//			System.out.printf("위치 : %x\n",System.identityHashCode(str));
//			System.out.println("str : " + str +"\n");
//			i++;
//		}
		
		System.out.println(str1.length());
		System.out.println(str1.charAt(2));

		System.out.println(str1.indexOf('a'));
		System.out.println(str1.lastIndexOf('a'));

		System.out.println(str1.contains("va"));
		System.out.println(str1.contains("abs"));

		System.out.println(str1.substring(2,6));
		
		String str6 = "등산,탁구,축구,골프,독서,영화감상";
		String [] result = str6.split(",");
		
		for(String hobby : result) {
			System.out.println(hobby);
		}
	
	}
}
