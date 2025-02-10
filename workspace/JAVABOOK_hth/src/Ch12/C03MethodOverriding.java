package Ch12;

//함수재정의(Method Overriding)
//상속관계를 전제로 상위클래스의 메서드를 하위클래스가 재정의(고쳐사용)하는것을 허용한 문법
//메서드의 헤더부분은 동일하게 두고 본체({})의 로직을 수정하게끔 허용함으로 다양한 형태의 객체가
//형성될수 있도록 유도(다형성)
//상위클래스로 부터 동일한 메서드를 물려받더라도 각 하위클래스마다 다른기능구현의 결과물을 만들어
//낼수 있다

// 오버로딩 vs 오버라이딩
// 오버로딩 
// 상속전제 : x
// 함수헤더 변경(반환자료형-고정,함수명-고정,파라미터-변동)
// 개발자의 편의성에 중점(함수 이름 단일화)

// 오버라이딩
// 상속전제 : o
// 함수로직 변경(헤더 고정)
// 다형성을 목적으로 한 문법요소


class Animal{
	void sound() {System.out.println("소리낸다");}
}
class Dog extends Animal{
	void sound() {System.out.println("멍멍");}
}
class Cat extends Animal{

	@Override
	void sound() {
		System.out.println("야옹");
	}
	
}
public class C03MethodOverriding {

	public static void main(String[] args) {
		Animal  ani = new Animal();
		ani.sound();
		Dog dog1 = new Dog();
		dog1.sound();
		Cat cat1 = new Cat();
		cat1.sound();
		
		System.out.println("--------------");
		ani = dog1;	//상위클래스 참조변수로 하위객체 Dog 연결
		ani.sound();
		ani = cat1; //상위클래스 참조변수로 하위객체 Cat 연결
		ani.sound();

	}

}
