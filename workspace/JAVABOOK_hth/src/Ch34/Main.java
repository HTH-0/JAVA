package Ch34;

@CustomAnnotation(value = "HELLOWORLD", number = 5)
class Simple{
	String v1;
	int v2;
	Simple(){
		CustomAnnotation ref = this.getClass().getAnnotation(CustomAnnotation.class);
		System.out.println("value : " + ref.value());
		System.out.println("number : " + ref.number());
		System.out.println("isOpen : " + ref.isOpen());
		
		this.v1 = ref.value();
		this.v2 = ref.number();
	}
	public String toSting() {
		return "v1 : " + v1 + "v2 : " + v2;
	}
}


public class Main {
	public static void main(String[] args) {
		
		Simple obj = new Simple();
		System.out.println(obj);
		
	}
}
