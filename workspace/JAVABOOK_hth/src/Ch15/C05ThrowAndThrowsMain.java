package Ch15;

class A{
	public void Ex1() throws NullPointerException{
		
		System.out.println("Ex1 process 1");
		throw new NullPointerException("Ex1 NULL Exception");
	
	}
}
class B{
	public void Ex2() throws NullPointerException{
		
		System.out.println("Ex2 process 1");
		throw new NullPointerException("Ex2 NULL Exception");
	}
}

public class C05ThrowAndThrowsMain {
	public static void main(String[] args) {
	
		System.out.println("실행코드 1");
		System.out.println("실행코드 2");
		
		A a = new A();
		B b = new B();
		
		try {			
		a.Ex1();
		b.Ex2();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("실행코드 3");
		
		
	}
}
