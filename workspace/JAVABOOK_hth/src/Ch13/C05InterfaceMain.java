package Ch13;



interface A{
	void ab();
}
interface B{
	void ab();
}

class C{
	
}
class D{

}
class E extends C implements A,B{
	@Override
	public void ab() {
		System.out.println("AABB");
	}
}


public class C05InterfaceMain {

	public static void main(String[] args) {
//		C c  =  new C();
//		c.a();
//		
//		A a = c;
//		a.a();
	}
}
