package Ch05;

import java.util.Scanner;


public class C02Ex {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		//1.문제(삼항연산자)
		// 키보드로 국어/영어/수학 점수를 입력받아 각각의부분점수가 40점이상이고
		// 총점수 평균이 70점이상이면 '합격'
		// 미만이면 '불합격'을 출력합니다
		
		
//		int kor = sc.nextInt();
//		int eng = sc.nextInt();
//		int math = sc.nextInt();
//			
//		String score = (kor >= 40 && eng >= 40 && math >= 40) && ((kor + eng + math)/3 >= 70) ? "합격"  : "불합격";
//		
//		System.out.println(score);
		
		//2.미니문제(%연산자)
		//키보드로 부터 정수값 두개 를 입력받아
		//두수의 합이 짝수이면 "짝수입니다"
		//홀수이면 "홀수입니다" 를 출력하세요~
		
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		
//		if((a + b)%2 == 0) {
//			System.out.println("짝수입니다.");
//		}
//		else {
//			System.out.println("홀수입니다.");
//		}
		
		//3.문제
		//국어 / 영어 / 수학 점수를 입력받아서
		//국어 점수가 40점이상
		//영어 점수가 40점이상
		//수학 점수가 40점이상이면서 전체평균이 60점이상이면 합격을 출력
		//아니면 불합격을 출력하세요
		//삼항연산자와 논리연산자를 이용합니다.
		
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		
		double avg = (double)(kor + eng + math)/3;
		
		String score = (kor >= 40 && eng >= 40 && math >= 40) && (avg >= 60) ? "합격" : "불합격";
		System.out.println(score);
		
//		if(kor >= 40 && eng>= 40 && math>= 40) {
//			if(avg >= 60) {
//				System.out.println("합격");
//			}
//			else {
//				System.out.println("불합격");
//			}
//		}else {			
//		System.out.println("불합격");
//		}
//		
		
		
		
		sc.close();
	}

}
