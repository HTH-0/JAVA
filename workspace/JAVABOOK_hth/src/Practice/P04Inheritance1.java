package Practice;

class Animal{
	String name;
	
	void bark(){
		System.out.println(name + "이/가 짖습니다.");
	}
	void eat() {
		System.out.println(name + "이/가 밥을 먹습니다.");
	}
}
class Dog extends Animal{
	
}

public class P04Inheritance1 {
	public static void main(String[] args) {
		Dog d1 = new Dog();
		
		d1.name = "멍멍	";
		d1.bark();
		d1.eat();
		
		
		
	}
}
