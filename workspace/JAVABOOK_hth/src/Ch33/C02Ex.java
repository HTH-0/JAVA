package Ch33;

import java.util.Arrays;
import java.util.stream.Collectors;

@FunctionalInterface
interface Functional{
	Integer execute(int ...args);
}

class Calc{
	Functional sum;
	Functional sub;
	Functional mul;
	Functional div;
	
	Calc(){
		
		// 람다식 완성
		// 모든 인자를 받을 수 있는 가변 인자 처리로 구현
		// 뺄셈, 나눗셈은 큰 수에서 작은 수로 정렬 >> 누적 감산 처리(reduce)
		sum = (arg) -> {
			int hap = 0;
			for(int el : arg) {
				hap += el;
			}
			return hap ;
		};
		sub = (arg)->{
			return Arrays.stream(arg)
					.boxed()
					.sorted((a,b) -> {return b-a;})
					.reduce((a,b)->{return a - b;})
					.orElse(null);
		};
		
		mul = (arg)->{
			int gop = 1;
			for(int el : arg) {
				gop *= el;
			}
			return gop;
		};
		div = (arg)->{
			return Arrays.stream(arg)
					.boxed()
					.sorted((a,b) -> {return b-a;})
					.reduce((a,b)->{return a / b;})
					.orElse(0);
		};
	}
}


public class C02Ex {
	public static void main(String[] args) {
		
		Calc calc = new Calc();
		System.out.println("합 : " + calc.sum.execute(10,20,30,40,50,60));
		System.out.println("차 : " + calc.sub.execute(1, 4, 2, 16)); // 1, 2, 4, 16
		System.out.println("곱 : " + calc.mul.execute(10,20,30,40,50,60));
	
		System.out.println("나눗셈 : " + calc.div.execute(1, 4, 2, 16));
	}
}
