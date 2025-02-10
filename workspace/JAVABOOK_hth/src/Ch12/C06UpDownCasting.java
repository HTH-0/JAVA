package Ch12;

class Super{
	int n1;
}
class Sub extends Super{
	int n2;
}

public class C06UpDownCasting {
	public static void main(String[] args) {
		
		
		Super ob1 = new Super();
		ob1.n1 = 10;
		
		Sub ob2 = new Sub();
		ob2.n1 = 10;
		ob2.n2 = 20;
		
		// Upcasting (상위 클래스 참조 변수 = 하위 클래스형 객체)
		// 상속 관계로 연결된 모든 하위 객체들을 연결할 수 있다.
		Super ob3 = new Sub();
		ob3.n1 = 100;
//		ob3.n2 = 200; 	// ob3에서 n2에는 접근이 불가능하다
		
		Super ob4 = ob2;
		ob4.n1 = 100;
//		ob4.n2 = 200;	// 접근 불가
		
		// Downcasting ( 하위 클래스 참조 변수 = 상위 클래스형 객체) ( 강제형변환 )
		// Upcasting된 상태에서 확장된 멤버에 접근하기 위한 용도
//		Sub ob5 = (Sub)ob1;
		Sub ob6 = (Sub)ob3;
		
		
		
	}
}
