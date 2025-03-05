package Ch10;


class C04Person{
	String name;
	int age;
	
	// 디폴트 생성자
	C04Person(){
	
	}
	
	// 모든 인자 생성자
	C04Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	// toString 재정의
	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}
	
	
}

public class C04ClassArrayMain {
	public static void main(String[] args) {
		
		
		
		
	}
}
