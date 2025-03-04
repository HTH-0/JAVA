package Ch07;

import java.util.Scanner;

public class C04For {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
//		int i = 0;
//		while(i<10) {
//			System.out.println("HELLOWORLD");
//			i++;
//		}
//		
//		for(int j = 0; j<10; j++) {
//			System.out.println("HELLOWORLD");
//		}
		
		
		
		
		// 2단
		// N단
		// 2-9
		// 2-N
		// N-M
		// 별찍기
		
		// 1 - 10 까지 합
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int tmp = n;
//		if(n > m) {
//			n = m;
//			m = tmp;
//		}
//		int sum = 0;
//		for(int i = n; i<=m; i++) {
//			sum += i;
//		}
//		System.out.println(sum);
		
		
		// 정삼각형 별찍기
		
		//    *
		//   ***
		//  *****
		// *******
			// 공백 : height - h, 별 : 2*h - 1
			// 역삼각형 일 때 공백 : h 별 : 2*height - 2*h -1
		int height = sc.nextInt();// 최대높이
		
		for(int h = 1; h<=height; h++) {
			int blank = height - h;
			int star = 2 * h - 1;
			
			for(int i = 1; i <= blank; i++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= star; j++) {
				System.out.print("*");
			}
			System.out.println();
			
			
		}
		for(int h = 1; h<=height; h++) {
			int blank2 = h;
			int star2 = 2 * height - 2 * h - 1;
			
			for(int k = 1; k <= blank2; k ++) {
				System.out.print(" ");
			}
			for(int l = 1; l <= star2; l++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
