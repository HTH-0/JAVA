package Ch31;


interface Calculator{
	int calculate(int num1, int num2);
}

public class C03LAMDA {
	public static void main(String[] args) {
		
		
		// 덧셈
		Calculator add = (int num1, int num2) -> {
			return num1 + num2;
		};
//		Calculator add = (a,b) -> a+b;
		
		// 뺄셈
		Calculator sub = (int num1, int num2) -> {
			return num1 - num2;
		};
		
		// 곱셈
		Calculator mul = (int num1, int num2) -> {
			return num1 * num2;
		};

		// 나눗셈
		Calculator div = (int num1, int num2) -> {
			return num1 / num2;
		};

		// 결과
		System.out.println(add.calculate(10,20));
		System.out.println(sub.calculate(10,20));
		System.out.println(mul.calculate(10,20));
		System.out.println(div.calculate(10,20));
		
		
	}
}
