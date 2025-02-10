package Ch08;

import java.util.Scanner;

class MethodTest {

	// 속성
	Scanner sc = new Scanner(System.in);

	public int sum1(int n1, int n2) {
		return n1 + n2;
	}

	public int sum2() {
		return sc.nextInt() + sc.nextInt();
	}

	public void sum3(int n1, int n2) {
		System.out.println(n1 + n2);
	}

	public void sum4() {
		System.out.println(sc.nextInt() + sc.nextInt());
	
	}
}

public class C04MethodMain {
	public static void main(String[] args) {

		MethodTest m1 = new MethodTest();
		
		System.out.println(m1.sum1(10, 20));
		System.out.println(m1.sum2());
		m1.sum3(10,20);
		m1.sum4();
		
	}
}
