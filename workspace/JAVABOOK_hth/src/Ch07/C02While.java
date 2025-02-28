package Ch07;

import java.util.Scanner;

public class C02While {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 2단

//		int i = 1;
//		int dan = 2;
//		while(i<= 9) {
//			System.out.printf("%d x %d = %d \n",dan, i, i * dan );
//			i++;
//		}

		// 2단 - 9단 출력

//		int dan = 2;
//		while (dan <= 9) {
//			int i = 1;
//			while (i <= 9) {
//				System.out.printf("%d x %d = %d \n", dan, i, i * dan);
//				i++;
//			}
//			dan++;
//		}

		// 9단 - 2단
//		int dan = 9;
//		while(dan>=2) {
//			int i = 1;
//			while(i<=9) {
//				System.out.printf("%d x %d = %d\n", dan, i, dan * i);
//				i++;
//			}
//			dan--;
//		}
//		

		// 2단 - n단

//		int dan = sc.nextInt();
//		while(dan<=9) {
//			int i = 1;
//			while(i<=9) {
//				System.out.printf("%d x %d = %d \n", dan, i, dan * i);
//				i++;
//			}
//			dan++;
//		}

		// n단에서 m단

//		int dan = sc.nextInt();
//		int mdan = sc.nextInt();
//		
//		while(dan<= mdan) {
//			int i = 1;
//			while(i<=9) {
//				System.out.printf("%d x %d = %d \n", dan, i, dan * i);
//				i++;
//			}
//			dan++;
//		}

		// 별찍기(기본높이:4)

		// *****
		// *****
		// *****
		// *****

		// >> 5개 별을 찍는 코드를 4줄에걸쳐서 반복
//		int height = 4;
//		int width = 5;
//		// 값에 sc.nextInt(); 를 넣으면 입력받은 만큼 진행한다.
//		
//		int h1 = 1;
//		while(h1<= height) {
//			int w1 = 1;
//			while(w1 <= width) {
//				System.out.print('*');
//				w1++;
//			}
//			System.out.println();
//			h1++;
//		}

		// *
		// **
		// ***
		// ****

		// height n일때 width n

//		int height = sc.nextInt();
//		// 최종 높이
//		
//		int h1 = 1;
//		
//		while(h1 <= height) {// 높이 반복문
//			int w1 = 1;
//			while(w1 <= h1) {
//			System.out.print('*');	
//				w1++;
//			}
//			System.out.println();
//			h1++;
//		}

		// ****
		// ***
		// **
		// *

//		int height = sc.nextInt();
//		
//		int h1 = 1;
//		
//		while(h1<=height) {
//			int w1 = height-h1+1;
//			while(w1 >= 1) {				// 1층일 때 최종높이 만큼 찍어야한다, 최종높이일때는 1이 찍혀야 한다.
//				System.out.print('*');
//				w1--;
//			}
//			System.out.println();
//			h1++;
//		}

		//    *
		//   ***
		//  *****
		// *******

		// 최종층 m 층 기준, 현재 층 n층 기준
		// 별 : n층일 때 2n-1 개, 공백 : m-n개

//		int height = sc.nextInt();	//최종층
//		
//		int h1 = 1;	// 현재층을 표시
//		while(h1 <= height) {
//			int i = 1;
//			int j = 1;
//			int blank = height - h1;
//			int star = (2 * h1)-1;
//			// h1 층일 때 별과 공백의 반복횟수
//			
//			while(i <= blank) {
//				System.out.print(" ");
//				i++;
//			}
//			while(j <= star) {				
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			h1++;
//		}

		// *******
		//  *****
		//   ***
		//    *

		// 최대층 height, 현재 층 h1
		// h1일 때, 별 : 2height - 2h1 + 1, 공백 : h1-1

//		int height = sc.nextInt();	//최종층
//		
//		int h1 = 1;	// 현재층을 표시
//		while(h1 <= height) {
//			int i = 1;
//			int j = 1;
//			int blank = h1-1;
//			int star = (2 * height)-2 * h1 + 1;
//			// h1 층일 때 별과 공백의 반복횟수
//			
//			while(i <= blank) {
//				System.out.print(" ");
//				i++;
//			}
//			while(j <= star) {				
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			h1++;
//		}

		//   *
		//  ***
		// *****		
		//*******
		// *****
		//  ***
		//   *

		// 삼각형 반복 이후 역삼각형 반복으로.

		// 삼각형
		// 최종층 height 층 기준, 현재 층 h1층 기준
		// 별 : h1층일 때, 2h1-1 개, 공백 : height-h1개

		// 역삼각형
		// h1일 때, 별 : 2height - 2h1 - 1, 공백 : h1-1 >> 중간에 겹치는 부분 생각해야함
		
		
//		case 1 >> 삼각형 실행 이후 다시 역삼각형 실행

//		int height = sc.nextInt(); // 최종층
//
//		int h1 = 1; // 현재층을 표시
//		while (h1 <= height) {
//			int i = 1;
//			int j = 1;
//			int blank1 = height - h1;
//			int star1 = (2 * h1) - 1;
//			// h1 층일 때 별과 공백의 반복횟수
//
//			while (i <= blank1) {
//				System.out.print(" ");
//				i++;
//			}
//			while (j <= star1) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			h1++;
//		}
//		h1 = 1; // 현재층 다시 초기화
//		int height2 = height - 1;
//		while (h1 <= height2) {
//			int i = 1;
//			int j = 1;
//			int blank2 = h1 ;
//			int star2 = (2 * height2) - 2 * h1 + 1;
//			// h1 층일 때 별과 공백의 반복횟수
//
//			while (i <= blank2) {
//				System.out.print(" ");
//				i++;
//			}
//			while (j <= star2) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			h1++;
//		}
		
		
		
		//*******
		// *****
		//  ***
		//   *		
		//   *
		//  ***
		// *****		
		//*******
		
		
//		case 1 >> 역삼각형 실행 + 삼각형 실행
		
//		int height = sc.nextInt();	//최종층
//		
//		int h1 = 1;	// 현재층을 표시
//		while(h1 <= height) {
//			int i = 1;
//			int j = 1;
//			int blank = h1-1;
//			int star = (2 * height)-2 * h1 + 1;
//			// h1 층일 때 별과 공백의 반복횟수
//			
//			while(i <= blank) {
//				System.out.print(" ");
//				i++;
//			}
//			while(j <= star) {				
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			h1++;
//		}	// 최종층일때 역삼각형 완성
//		// 다시 삼각형
//		h1 = 1;	// 현재층 초기화
//		while(h1 <= height) {
//			int i = 1;
//			int j = 1;
//			int blank2 = height - h1;
//			int star2 = (2 * h1)-1;
//			// h1 층일 때 별과 공백의 반복횟수
//			
//			while(i <= blank2) {
//				System.out.print(" ");
//				i++;
//			}
//			while(j <= star2) {				
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			h1++;
//		}

		
		
	}
}
