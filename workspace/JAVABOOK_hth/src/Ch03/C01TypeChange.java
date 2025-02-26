package Ch03;

public class C01TypeChange {
	public static void main(String[] args) {
		
		
		// (자료)형변환
		// 연산 시 일치하지 않는 자료형을 일치시키는 작업
		
		
		// 자동 형변환(임시적 형변환) : 컴파일러에 의해 자동 형변환
		// 강제 형변환(명시적 형변환) : 프로그래머에 의해 강제 형변환
		
		
		// 자동 형변환(=)
		// '변수 연산 처리' 시 범위가 넓은 공간에 작은 값이 대입되는 경우
		
		
		// byte > short, char > int > long > float > double
		
		
//		byte bytevalue = 10;
//		int intvalue = bytevalue;
//		System.out.println("intvalue : " + intvalue);
//		
//		char charvalue = '가';
//		intvalue = charvalue;
//		System.out.println("가의 유니코드 : " + intvalue);
//		
//		int value = 50;
//		long longvalue = intvalue;
//		System.out.println("longvalue : " + longvalue);
//		
//		longvalue = 100;
//		float floatvalue = longvalue;
//		System.out.println("floatvlaue : " + floatvalue);
//		
//		floatvalue = 100.5F;
//		double doublevalue = floatvalue;
//		System.out.println("doublevalue : " + doublevalue);
		
		// 강제 형변환
		// 좁은 범위 공간에 큰 값을 넣으려고 하는 경우
		// 기본적으로 불가능하기 때문에 강제로 자료형을 바꾸어 전달한다
		// 데이터 손실의 염려가 있다.
		
		int intvalue = 44032;
		char charvalue = (char)intvalue;
		System.out.println((int)charvalue);
		
		long longvalue = 500;
		intvalue = (int)longvalue;
		System.out.println(intvalue);
		
		// 데이터 손실
		double doublevalue = 3.14;
		intvalue = (int)doublevalue;
		System.out.println(intvalue);
		
	}
}
