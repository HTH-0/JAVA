package Ch08;

public class C01Main {
	public static void main(String[] args) {
		
		C01Person hong = new C01Person();
		
		hong.name = "홍길동";
		hong.age = 15;
		hong.height = 177.5F;
		hong.weight = 70.5;
		
		System.out.printf("%s %d %f %f\n", hong.name,hong.age, hong.height, hong.weight);
		
	}
}
