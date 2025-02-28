package Practice;


class Animals{
	String name;
	
	void makeSound() {
		System.out.println(name + "이/가 소리칩니다.");
	}
}

class puppy extends Animals{
	
	
	@Override
	void makeSound() {
		System.out.println(name + " 멍멍!!");
	}
}

class kitty extends Animals{
	
	@Override
	void makeSound() {
		System.out.println(name + " 야옹~");
	}
}


public class P08Animals {
	public static void main(String[] args) {
		
		
		puppy a1 = new puppy();
		kitty a2 = new kitty();
		a1.name = "고양";
		a2.name = "강쥐";
		
		a1.makeSound();
		a2.makeSound();
		
	}
}
