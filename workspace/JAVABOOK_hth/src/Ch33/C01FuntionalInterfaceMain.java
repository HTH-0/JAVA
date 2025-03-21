package Ch33;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface // 함수형 인터페이스 선언(Compiler 에게 전달) >> 메서드 무조건 한개만!!
interface Func1 {

	void say(String message);
}

@FunctionalInterface
interface Func2 {

	int sum(int ...args);
}

@FunctionalInterface
interface Func3 {
	List<Integer> createdListDesc(int ... args);
}

public class C01FuntionalInterfaceMain {
	public static void main(String[] args) {

		Func1 f1 = message -> System.out.println(message);
		f1.say("HELLO WORLD");

		Func1 f2 = System.out::println;
		f2.say("HELLO WORLD2");

		Func2 func2 = (arg) -> {
			int sum = 0;
			for(int el : arg) {
				sum += el;
			};
			return sum;
		};
		// {} 에 모든 items 더한 값을 리턴 (반복문으로 items의 item을 누적해서 리턴
		System.out.println(func2.sum(10, 20, 30, 40, 556, 6, 7, 8, 9));

		
		
		Func2 func2_2 = (arg) -> {
			// {} 에 모든 items를 더한 값을 리턴 (reduce)
			
			return Arrays.stream(arg)
					.reduce(0,(sum, el) -> {return sum + el;});
		};
		System.out.println(func2_2.sum(10, 20, 30, 40, 556, 6, 7, 8, 9));
	
		
		// 원시 타입 int[] 받기 >> 내림차순 >> int 형을 Integer 로 boxing >> List<Integer> 변환
		Func3 func3 = (items) -> {
			return Arrays.stream(items)
			.boxed()
			.sorted((a,b) -> {return b-a;})
			.collect(Collectors.toList());
			};
		
		List<Integer> li = func3.createdListDesc(10, 100, 24, 1612, 42, 123, 15, 4 ,1);
		
		System.out.println(li);
	}

}
