package Ch08;

public class C00INFO {
	public static void main(String[] args) {
		
		
		
		// 1. 객체 - object
		// 존재하는 사물 (object)
		
		// 2. 객체
		// 속성 : 객체마다 구별되는 데이터(저장)
		// 기능 : 객체마다 수행할 수 있는 공통 Action
		
		// 3. 객체 지향
		// 현실 세계의 여러 객체의 정보 (속성/기능) 중에 필요한 일부만 추출(추상화) 하여
		// 문제 해결을 하기 위한 요소 단위로 적재(저장)하기 위해 고안된 문법
		
		// 4. 클래스
		// 동일한 종류의 객체에 필요한 메모리 공간을 제공하기 위해 선언된 자료형
		// 클래스로 객체를 생성하기 전에는 기본적으로 메모리 공간을 차지하지 않는다.
		
		// (document화)
		// 클래스 자료형에 의해 객체가 정의되는 순간 클래스에서 선언한 속성과 기능대로
		// 공간 형성이 이루어진다.
		
		
		// 5. 자바의 메모리 영역
		
		// 1) 스택 영역				: {} 내에서 생성되고 소멸되는 영역 (int, double..)
		// 2) 클래스( == 메서드) 영역		: 공유 메모리 영역(생성자, 일반 메서드, static 메서드, static 변수)
		// 3) 힙 영역					: 객체 저장 영역(new 예약어 사용 시 할당)
		
		
		// 6. 코드 해석
		// Scanner sc = new Scanner(System.in);
		
		// new			: 힙(heap) 영역에 객체 저장
		// Scanner()	: 객체에 필요한 초기값을 부여하기 위한 생성자 메서드
		// Scanner sc 	: Scanner 라는 클래스 자료형으로 정의된 참조변수 sc
		
		// 힙메모리 영역에 Scanner에 필요한 초기값이 담긴 객체를 생성하고,
		// 현 위치(main stack)에 Scanner 자료형으로 만든 sc 참조변수에 생성된 Scanner 객체의
		// "시작위치" 주소를 저장
	}
}
