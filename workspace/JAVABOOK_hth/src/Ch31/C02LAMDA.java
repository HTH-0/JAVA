package Ch31;

import java.util.Scanner;

interface Printer{
//	void print(String message);		// 추상 메서드
//	String print(String message);		// 추상 메서드
	String print();						// 추상 메서드
	
}

public class C02LAMDA {
	public static void main(String[] args) {
		
		//01
//		Printer printer = (message)->{System.out.println(message);};
//		printer.print("HELLOWORLD");
		
		//02
//		Printer printer = (message)->{return message;};
//		Printer printer	= message -> message;
//		String returnValue = printer.print("TEST");
//		System.out.println(returnValue);
		
		//03

		Printer printer = () -> {
			Scanner sc = new Scanner(System.in);
			String message = sc.nextLine();
			sc.close();
			return message;
			};
			
		String returnValue = printer.print();
		System.out.println(returnValue);
	}
}
