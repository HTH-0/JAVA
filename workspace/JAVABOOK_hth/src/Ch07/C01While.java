package Ch07;

import java.util.Scanner;

public class C01While {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 10번 반복 "HELLOWORLD"
		// 탈출용변수 : i = 0
		// 탈출용 조건식 : i < 10
		// 탈출용 연산식 : i++

//		while(조건식) {
//			조건식이 true일 때, 실행되는 종속 문장
//		}

//		int i = 0;
//		while(i<10) {
//			System.out.println("HELLOWORLD");
//			i++;
//		}
//
//		int i = 1; // 탈출용 변수
//		int sum = 0; // 누적 합을 저장할 변수
//		while (i <= 10) {
//			System.out.println("i : " + i);
//			sum += i;
//			i++;
//		}
//		System.out.println("sum : " + sum);
//
//		// 04 1 부터 n 까지
//
//		int j = 1;
//		int a = sc.nextInt();
//		int sum2 = 0;
//
//		while (j >= a) {
//			sum2 += j;
//			j++;
//		}

		// 05 n부터 m 까지

//		int b = sc.nextInt();
//		int c = sc.nextInt();
//		int sum3 = 0;
//
//		if (b >= c) {
//			while (c <= b) {
//				sum3 += c;
//				c++;
//			}
//		}
//		else {
//			while (b <= c) {
//				sum3 += b;
//				b++;
//			}
//		}
//		System.out.println(sum3);

//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int sum3 = 0;
//		
//		
//		if(n>=m) {
//			int tmp = n;
//			n = m;
//			m = tmp;
//		}
//		
//		while (n <= m) {
//			sum3 += n;
//			n++;
//		}
//		System.out.println(sum3);

//		06 n ~ m 까지 수 중 (n<m) 짝수의 합, 홀수의 합 각각 구해서 출력

//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		
//		int odd = 0;
//		int even = 0;
//		
//		while(n<=m) {		// 반복문
//			if(n%2 == 0) {	// n이 짝수라면?
//				even += n;
//			}
//			else if(n % 2 == 1) {	// 홀수라면?
//				odd += n;
//			}
//			n++;
//		}
//		System.out.println("짝수합 : " + even);
//		System.out.println("홀수합 : " + odd);

//		07 1~n 까지의 수 중 4의 배수를 출력하고 4의 배수가 아닌 나머지의 합을 구하세요
//		int n = sc.nextInt();
//		int i = 1;
//		int sumnot4 = 0;
//		
//		while(i<=n) {
//			if(i % 4 == 0) {
//				System.out.println(i);
//			}
//			else {
//				sumnot4 += i;
//			}
//			i++;
//		}
//		System.out.println(sumnot4);

//		08 구구단 n단을 출력 
		
		System.out.println("몇단을 출력할까요?");
		int dan = sc.nextInt();
		System.out.println("시작 숫자는 몇인가요?");
		int n = sc.nextInt();

		while (dan <= 9) {
			while (n <= 9) {
				System.out.printf("%d x %d = %d\n", dan, n, dan * n);
				n++;
			}
			dan++;
		}

		sc.close();
	}
}
