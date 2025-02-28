package Practice;


class Animal3{
	String name;
	
	void Sound() {
		System.out.println(name + "이/가 소리를 냅니다.");
	}
}
class Duck extends Animal3{
	
	@Override
	void Sound() {
		System.out.println(name + "이/가 꽥꽥 거립니다.");
	}
}


public class P06Overriding {
	public static void main(String[] args) {
		
		Duck d1 = new Duck();
		d1.name = "오리";
		d1.Sound();
		
		
		
	}
}
