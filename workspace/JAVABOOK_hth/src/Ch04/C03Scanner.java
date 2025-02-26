package Ch04;

import java.util.Scanner;

public class C03Scanner {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("입력된 정수 값 : " + num1);
		
		sc.nextLine();		// 넣는 이유 
		
		System.out.println("문자열 입력(띄어쓰기 포함) : ");
		String str2 = sc.nextLine();				// 띄어쓰기도 포함한다, 엔터키를 기준으로
		System.out.println("문자열 : " + str2);
		
		// 이렇게 섞어서 배치하면 버퍼공간에 남아 있는 엔터키 때문에
		
//		System.out.println("실수 입력 : ");
//		double num2 = sc.nextDouble();
//		System.out.println("입력된 실수 값 : " + num2);
//		
//		System.out.println("문자열 입력 : ");
//		String str1 = sc.next();				// 문자열 입력받기 가능 함수, 띄어쓰기는 포함하지 않는다.
//		System.out.println("입력된 문자열 : " + str1);
//		
//		System.out.println("입력 : ");
//		String s1 = sc.next();
//		String s2 = sc.next();
//		String s3 = sc.next();
//		System.out.printf("문자열 : %s %s %s \n", s1, s2, s3);
		sc.close();
	}
}
