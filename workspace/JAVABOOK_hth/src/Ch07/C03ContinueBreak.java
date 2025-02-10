package Ch07;

import java.util.Scanner;

public class C03ContinueBreak {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		// 1. break
//		// -1 을 입력하기 전 까지 정수값을 누적하여 합을 구하고 출력
//		
//		int n;
//		int sum = 0;
//		
//		while(true) {
//			
//			n = sc.nextInt();
//			if(n == -1) {
//				break;
//			}
//			else {
//				sum += n;
//			}
//		}
//		System.out.println("SUM : " + sum);
		
		// 모든 반복문 탈출 : flag
		// 7 * 7 = 49 출력 이후 모든 반복문 탈출

//		boolean flag = false;
//		int dan = 2;
//		while(dan<10) {
//			int i = 1;
//			while(i<10) {
//				if( flag == true) {
//					break;
//				}
//				if( dan == 7 && i == 7) {
//					flag = true;
//				}
//				System.out.printf("%d x %d = %d\n", dan, i, dan*i);
//				i++;
//				
//			}
//			System.out.println();
//			dan++;
//		}
		
		
		// EXIT
		
		
//		int dan = 2;
//		
//		Exit: 
//		while(dan<10) {
//			int i = 1;
//			while(i<10) {
//				System.out.printf("%d x %d = %d\n", dan, i, dan*i);
//				if( dan == 7 && i == 7) {
//					break Exit;
//				}
//				
//				i++;
//				
//			}
//			System.out.println();
//			dan++;
//		}
		
		
		// continue
		// 1부터 10까지의 수 중에 3의 배수를 제외한 합 출력
		
		
//		int i = 1;
//		int sum = 0;
//		while (i <= 10) {
//			if( i % 3 != 0) {
//			sum += i;
//			}
//			i ++;
//		}
//		System.out.println("SUM : " + sum);
		
//		int i = 1;
//		int sum = 0;
//		while (i <= 10) {
//			if( i % 3 == 0) {
//				i++;
//				continue;
//			}
//			sum += i;
//			i ++;
//		}
//		System.out.println("SUM : " + sum);	
		
		
		sc.close();
		
	}
}
