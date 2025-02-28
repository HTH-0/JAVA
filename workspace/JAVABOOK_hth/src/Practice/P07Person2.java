package Practice;

class Person2 {
	String name;
	int age;

	Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Student extends Person2 {

	Student(String name, int age) {
		super(name, age);
	}

	void grade(char grade) {
		System.out.println(name + "님의 나이는 " + age + "살 이고 성적은 " + grade + "입니다");
	}
}

public class P07Person2 {
	public static void main(String[] args) {

		Student s1 = new Student("홍길동", 22);

		s1.grade('A');
		
		
	}
}
