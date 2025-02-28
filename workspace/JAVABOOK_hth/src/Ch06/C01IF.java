package Ch06;

import java.util.Scanner;

public class C01IF {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 단순 if

//		System.out.println("나이 : ");
//		int age = sc.nextInt();
//		if(age >= 8) {
//			System.out.println("학교에 다닙니다.");
//		}
//		System.out.println("첫번째 if 코드 블록 종료");
//		if(age <8) {
//			System.out.println("학교에 다니지 않습니다");
//		}
//		System.out.println("두번째 if 코드 블럭 종료");
//		
//		System.out.println("프로그램을 종료합니다");
//		sc.close();

		// IF ELSE 문

//		System.out.println("나이 : ");
//		int age = sc.nextInt();
//		
//		if(age >= 8) {
//			System.out.println("학교에 다닙니다.");
//		}
//		else {		
//			System.out.println("학교에 다니지 않습니다");
//		}
//		
//		System.out.println("프로그램을 종료합니다");
//		sc.close();
//		
		// 문제
		// 정수 한개 값을 입력받아 3의배수면 출력
		// 3의 배수이면서 5의 배수라면 출력
//		System.out.println("3의 배수이거나 3의 배수이면서 5의 배수인 수를 입력하세요");
//		int num = sc.nextInt();
//
//		if (num % 3 == 0) {
//			System.out.println("3의 배수입니다.");
//			if (num % 5 == 0) {
//				System.out.println(num + "15의 배수입니다.");
//			}
//		} else {
//			System.out.println("아닙니다.");
//		}

		// 문제1
		// 두개의 정수를 입력받아 큰 수 출력
//		System.out.println("a 입력 :");
//		int a = sc.nextInt();
//
//		System.out.println("b 입력 :");
//		int b = sc.nextInt();
//
//		if (a > b) {
//			System.out.println(a);
//		} else {
//			if (a == b) {
//				System.out.println("두 수가 동일합니다.");
//			}
//			System.out.println(b);
//		}

		// 문제2
		// 세개의 정수를 입력받아 큰 수 출력

//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		int c = sc.nextInt();
//		
//		if( a > b && a > c) {
//			System.out.println(a);
//		}else if(b > a && b > c){
//			System.out.println(b);
//		}else if(c > a && c > b ) {
//			System.out.println(c);
//		}

		// 문제 2 >> 두번째 방법

//		int max = a;
//		if (b > a) {
//			max = b;
//		}
//		if (c > b) {
//			max = c;
//		}
//		System.out.println(max);

		// 문제 3
		// 입력한 수가 짝수, 3의 배수면 출력
		// 입력한 수가 홀수, 5의 배수라면 출력

//		int num = sc.nextInt();
//		if (num % 2 == 0) {
//			if (num % 3 == 0) {
//				System.out.println(num);
//			} else {
//				System.out.println("짝수이지만 3의 배수가 아닙니다.");
//			}
//		} else if (num % 2 == 1) {
//			if (num % 5 == 0) {
//				System.out.println(num);
//			} else {
//				System.out.println("홀수이지만 5의 배수가 아닙니다.");
//			}
//		}

		
		// IF - ELSE IF - ELSE
		
		// 과목 1,2,3,4 중 하나라도 40미만 불합격
		// 평균 60 미만이면 불합격
		
		
//		int sub1 = sc.nextInt();
//		int sub2 = sc.nextInt();
//		int sub3 = sc.nextInt();
//		int sub4 = sc.nextInt();
//		
//		double avg = (double)(sub1 + sub2 + sub3 +sub4) / 4 ;

//		if(sub1 >= 40 && sub2 >= 40 && sub3 >= 40 && sub4 >= 40) {
//			if(avg > 60){
//				System.out.println("합격입니다.");
//			}else {				
//			System.out.println("불합격입니다.");
//			}
//		}else {			
//		System.out.println("불합격입니다.");
//		}
		
//		if(sub1 < 40) {
//			System.out.println("불합격입니다.");
//		}
//		else if(sub2 < 40) {
//			System.out.println("불합격입니다.");
//		}
//		else if(sub3 < 40) {
//			System.out.println("불합격입니다.");
//		}
//		else if(sub4 < 40) {
//			System.out.println("불합격입니다.");
//		}
//		else if(avg < 60) {
//			System.out.println("불합격입니다.");
//		}
//		else {
//			System.out.println("합격입니다.");
//		}
		
		
		
		
		// 문제
		// 시험 점수를 입력받아
		// 90~100 A
		//
		// 60 ~69 D
		// 나머지 F
		
		
		int score = sc.nextInt();
		
		if(score >=90) {
			System.out.println("A");
		}
		else if(score >= 80){
			System.out.println("B");
		}
		else if(score >= 70){
			System.out.println("C");
		}
		else if(score >= 60){
			System.out.println("D");
		}
		else {
			System.out.println("F");
		}
		
		
		
		
		// 문제
		// 나이별로 요금을 부과하는 else if문
		
		// 8세 미만 : 1000원
		// 14세 미만 : 2000원
		// 20 : 2500
		// 20 이상 : 3000
		
		int age = sc.nextInt();
		
		if(age <8) {
			System.out.println("요금 : 1000원");
		}
		else if(age < 14) {
			System.out.println("요금 : 2000원");
		}
		else if(age < 20) {
			System.out.println("요금 : 2500원");
		}
		else {
			System.out.println("요금 : 3000원");
		}
		
		
		
	}

}
