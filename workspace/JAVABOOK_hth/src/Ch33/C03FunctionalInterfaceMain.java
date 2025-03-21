package Ch33;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//제공되는 함수형 인터페이스들
//Function<T, R>:
//apply 메서드를 가지고 있어서 하나의 인자(T)를 받아서 결과(R)를 반환하는 함수형 인터페이스 입니다.

//Supplier<T>:
//get 메서드를 가지고 있어서 어떠한 인자도 받지 않고 결과만을 제공하는 함수형 인터페이스 입니다.
//
//Consumer<T>:
//accept 메서드를 가지고 있어서 어떠한 인자를 받아서 결과를 반환하지 않는 함수형 인터페이스 입니다.
//
//Predicate<T>:
//test 메서드를 가지고 있어서 어떠한 인자를 받아서 불리언 결과를 반환하는 함수형 인터페이스 입니다.
//
//UnaryOperator<T>:
//apply 메서드를 가지고 있어서 하나의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.
//
//BinaryOperator<T>:
//apply 메서드를 가지고 있어서 두 개의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.

public class C03FunctionalInterfaceMain {

	public static Function<Integer, Integer> func1 = x -> x * x;
	public static Function<Integer, Integer> func2 = x -> x + x;
	public static Function<List<Integer>, Integer> func3 = x -> {return x.stream().reduce(0, Integer::sum);};
	public static Function<List<Object>, Integer> func4 =(li) -> {
		// Integer 형만 필터링 (Instanceof)
		// 누적 합(reduce)
		return li.stream()	// li >> Object 타입.
				.filter(obj -> obj instanceof Integer)	// obj를 Integer 로 필터링 >> 확인만 한 상태 >> 아직은 Object 타입.
				.map(obj -> (Integer)obj)				// Integer으로 재구성		>> Object 타입을 Integer 타입으로 바꾸어야 하기 때문
				.reduce(0, Integer::sum);				// 누적 합		// reduce를 사용하려면 Integer타입으로.
		};
	public static Function<List <Object>, List<Integer>> func5 =(li) -> {
		// Integer 형만 필터링 (Instanceof)
		// 재구성(map)
		// 리스트로 변환(collect)
		return li.stream()
				.filter(item -> item instanceof Integer)
				.map(obj -> (Integer)obj)	// >> 타입 변환
				.collect(Collectors.toList());	// >> Integer >> 리스트 형태로
	};	
		
	public static Function<Integer, Integer> func6 = func1.andThen(func2);		//먼저 이 함수 실행하고, 그다음 저 함수 실행
	public static Function<Integer, Integer> func7 = func2.andThen(func1);		
	public static Function<List<Integer>, Integer> subFunc = x -> {return x.stream().reduce(0, (sum,x1)-> sum + x1);};
	public static Function<List<Object>, Integer> func8 = func5.andThen(subFunc);	// Integer만 뽑아 리스트로 만들고 >> 합 계산
//	public static Function<Integer, Function<Integer, Integer>> func9 = x -> {return x1 -> {return x1 + x1;};};
	public static Function<Integer, Function<Integer, Integer>> func9 = x -> x1 -> x1 + x1;
	public static Function<Integer, Function<Integer, Integer>> func10 = x -> y -> x + y;
	public static Function<Integer, Function<Integer, Function<Integer, Integer>>> func11 = x -> y -> z -> x + y + z ;
	
	
	public static void main(String[] args) {
		
		// 01
		System.out.println(func1.apply(10));
		// 02
		System.out.println(func2.apply(10));
		// 03
		System.out.println(func3.apply(Arrays.asList(10,20,30,40)));
		// 04
		System.out.println(func4.apply(Arrays.asList("ㄱ",10,20,"ㄴㄴ",30,40)));
		// 05
		System.out.println(func5.apply(Arrays.asList("ㄱ",10,20,"ㄴㄴ",30,40)));
		
		System.out.println(func6.apply(5));		// >> 5*5 + 5*5
		System.out.println(func7.apply(5));		// >> 5+5 * 5+5
		
		System.out.println(func8.apply(Arrays.asList("ㄱ", 10, 20, "ㄴㄴ", 30, 40,"ee", 70)));
		System.out.println(func9.apply(5).apply(10));
		System.out.println(func10.apply(5).apply(10));
		System.out.println(func11.apply(5).apply(10).apply(15));	
	}
}
