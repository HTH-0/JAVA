package Ch15;

public class C04ExceptionMain {
	public static void main(String[] args) {
		
		try {			
		String str = null;
		str.toString();
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		try {			
		int arr[] = {10,20,30};
		arr[5] = 100;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try {			
		Integer.parseInt("a1234");
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		
		try {			
		Animal animal = new Dog();
		Cat yummi = (Cat)animal;
		}catch(ClassCastException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("HELLOWORLD");
		
	}
}
