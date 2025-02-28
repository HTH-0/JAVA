package Practice;

class Animal2{// 04번에서 이미 animal 클래스를 사용했다.
	String name;
	
	
	void eat() {
		System.out.println(name + "이/가 음식을 먹습니다.");
	}
}
class Cat extends Animal2{
	
	void eat() {
		super.eat();
		System.out.println(name + "이/가 고양이 사료를 먹습니다.");
	}
}



public class P05Inhe {
	public static void main(String[] args) {
		
		
		Cat d1 = new Cat();
		d1.name = "야옹";
		d1.eat();
		
		
		
		
	}
}
