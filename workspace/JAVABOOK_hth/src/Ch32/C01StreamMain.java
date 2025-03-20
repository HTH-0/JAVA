package Ch32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person {
	private String name;
	private int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + ", 나이 : " + age;
	}
}
class Employee extends Person{
	String company;
	String department;
	String role;
	
	public Employee(Person person){
		super(person.getName(), person.getAge());
	}
	
	public String getCompany(){
		return company;
	}
	public void setCompany(String company){
		this.company = company;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
    public String toString() {
        return "Employee [이름=" + getName() + ", 나이=" + getAge() + 
               ", 회사=" + company + ", 부서=" + department + ", 직책=" + role + "]";
    }
}
public class C01StreamMain {
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println(list);
		
		// filter
		List<Integer> list2 = list.stream()
				.filter((item)->{return item % 2 == 0;})
				.collect(Collectors.toList());
		
		System.out.println("짝수 필터링 :" + list2);
		
		
		// map
		List<Integer> list3 = list.stream()
				.filter((item)->{return item % 2 == 0;})
				.map((item)->{return item * item;})
				.collect(Collectors.toList());
		
		System.out.println("Map 적용 :" + list3);

		
		//
		List<Person> list4 = Arrays.asList(
			new Person("홍길동", 55),
			new Person("남길동동", 45),
			new Person("서길길동동", 35),
			new Person("동덩길길동동", 25)
		);
		
		List<Integer> list5 = list4.stream()
//				.map((person)->{return person.getAge();})
//				.map(person -> person.getAge())
				.map(Person::getAge)
				.sorted((a,b) -> {return b-a;})
				.collect(Collectors.toList());
		
		System.out.println(list5);
		
		List<Integer> list6 = list4.stream()
				.map(Person::getName)
				.map(String::length)
				.sorted((a,b) -> a-b)
				.collect(Collectors.toList());
		
		System.out.println(list6);
		
		
		List<Person> list7 = list4.stream()
//				.map(person -> new Employee(person.getName(), person.getAge()))
				.map(Employee::new)
				.collect(Collectors.toList());
		
		list7.forEach(System.out::println);		
	}
}
