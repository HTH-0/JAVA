package Practice;


class person {
	
	String name;
	int age;
	
	
	person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	void introduce() {
		System.out.println("이름 : " + name + " 나이 : " + age);
	}
	
}

public class P02Person {
	public static void main(String[] args) {
		
		person p1 = new person("홍길동", 22);
		
		p1.introduce();
	}
}
