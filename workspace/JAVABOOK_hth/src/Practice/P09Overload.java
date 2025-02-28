package Practice;

class MathUtil {

	int add(int a, int b) {
		return a + b;
	}

	double add(double a, double b) {
		return a + b;
	}

	double add(double a, double b, double c) {
		return a + b + c;
	}
}

public class P09Overload {
	public static void main(String[] args) {
		
		
		MathUtil m1 = new MathUtil();
		
		System.out.println(m1.add(3, 4));
		System.out.println(m1.add(3.3, 4.6));
		System.out.println(m1.add(3.2, 4.4, 5.6));
		
		
		
	}
}
