package Ch04;

import java.util.Scanner;

public class C04Scanner {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("이름을 입력해주세요 : ");
		String name = sc.nextLine();

		System.out.printf(" %s 나이를 입력해주세요 : \n",name);
		int age = sc.nextInt();
		
		sc.nextLine();

		System.out.printf("%s님의 주소를 입력해주세요 : \n", name);
		String address = sc.nextLine();
		
		
		System.out.printf("%s 님의 나이는 %d 이고 주소는 %s 입니다.", name, age, address);
		
		
		sc.close();
	}
}
