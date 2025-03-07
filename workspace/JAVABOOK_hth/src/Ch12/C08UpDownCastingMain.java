package Ch12;

class C08Super{
	
	void func1(){
		System.out.println("C08.Super.func1() call");
	}
	
	void func2() {
		
	}
}
class C08Sub extends C08Super{
	
	void func2() {
		System.out.println("C08.C08Sub.func2() call");
	}
}


public class C08UpDownCastingMain {
	public static void main(String[] args) {
		
		// No casting
		C08Super ob1 = new C08Super();
		ob1.func1();
		
		// No casting
		C08Sub ob2 = new C08Sub();
		ob2.func1();
		ob2.func2();
		
		// Upcasting
		C08Super ob3 = new C08Sub();
		ob3.func1();
		ob3.func2();
		
		// Upcasting 상태에서
		// 확장된(멤버 추가) 멤버 변수 접근 불가능 >> Downcasting
		// 확장된(멤버 추가) 멤버 변수 접근 불가능 >> Downcasting
		// 재정의된 메서드 접근 가능
		
	}
}
