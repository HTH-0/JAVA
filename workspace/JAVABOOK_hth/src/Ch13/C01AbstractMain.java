package Ch13;

// 일반 클래스 상속 관계
class Super1 {
	void func() {

	}
}

class Sub1 extends Super1 {
	void func() {
		System.out.println("[Override] Sub1.func() is called.");
	}
}

// 추상 클래스 상속 관계
abstract class Super2 { // 함수에 abstract 가 붙었기 때문에 똑같이 붙여준다.
	abstract void func(); // 미완성된 함수지만 의도함을 나타내기 위해 abstract 를 붙인다.
}

class Sub2 extends Super2 { // 부모 클래스의 abstract 함수를 완성시켜야 한다.
	void func() {
		System.out.println("[Override] Sub2.func() is called.");
	}
}

public class C01AbstractMain {
	public static void main(String[] args) {
		
		// 01
		
//		// no casting
//		Super1 s1 = new Super1();
//		Sub1 s2 = new Sub1();
//
//		// upcasting
//		Super1 s3 = new Sub1();
//		s3.func(); // 재정의된 함수 접근 가능

		
		// 02 추상 클래스 상속 관계
		
		// no casting
//		Super2 s1 = new Super2();		// 완성된 함수가 아니라서 사용 불가능
		Sub2 s2 = new Sub2();			// 미완성 함수를 완성 시켰을 때 가능

		// upcasting 
		Super2 s3 = new Sub2();
		s3.func(); // 재정의된 함수 접근 가능
	}
}
