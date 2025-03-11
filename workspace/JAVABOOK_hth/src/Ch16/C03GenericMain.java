package Ch16;

class Person {
	String name;
	int age;
	String addr;

	public Person(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
}

class Man extends Person{
	
	public Man(String name, int age, String addr){
		super(name, age, addr);
	}
	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}

class Woman extends Person{
	public Woman(String name, int age, String addr){
		super(name, age, addr);
	}
	@Override
	public String toString() {
		return "Woman [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}

class Couple<X extends Person, Y extends Person> {
	private X member1;
	private Y member2;

	// 생성자
	public Couple(X member1, Y member2) {
		this.member1 = member1;
		this.member2 = member2;

	}

	// toString
	@Override
	public String toString() {
		return "멤버 1 : " + member1 + ", 멤버 2 : " + member2;
	}

}

public class C03GenericMain {
	public static void main(String[] args) {
		
		Couple<Man,Woman> couple1 = new Couple<Man, Woman>(new Man("홍길동", 50, "대구"), new Woman("영희", 40, "울산"));
		System.out.println("couple1 : " + couple1);
		
//		Couple<Integer,Integer> couple2 = new Couple<Integer,Integer>(100,200);
//		System.out.println("couple2 : " + couple2);
		
		
	}
}
