package Ch17;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
	String name;
	int age;

	// 생성자
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// toString
	
	@Override
	public String toString() {
		return "Person의 이름 : " + name + " 나이 : " + age;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		return age == other.age && Objects.equals(name, other.name);
//	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person down = (Person)obj;
			return this.name.equals(down.name) && this.age == down.age;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.age, this.name);
	}
}

public class C05SetMain {
	public static void main(String[] args) {

		Set<Person> set = new HashSet<>();

		Person ob1 = new Person("홍길동", 55);
		Person ob2 = new Person("남길동", 35);
		Person ob3 = new Person("홍길동", 55);

		System.out.println(ob1.equals(ob2));
		System.out.println(ob1.equals(ob3));

		set.add(ob1);
		set.add(ob2);
		set.add(ob3);

		System.out.println("SIZE : " + set.size());

	}
}
