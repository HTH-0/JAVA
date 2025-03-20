package Ch33;

@FunctionalInterface // 함수형 인터페이스 선언(Compiler 에게 전달) >> 메서드 무조건 한개만!!
interface Func1 {

	void say(String message);
}

public class C01FuntionalInterfaceMain {
	public static void main(String[] args) {

		Func1 f1 = message -> System.out.println(message);
		f1.say("HELLO WORLD");

		Func1 f2 = System.out::println;
		f2.say("HELLO WORLD2");

		Func1 f3 = str -> {System.out.println(str + "...");};
		f3.say("hi");
		
	};

}
