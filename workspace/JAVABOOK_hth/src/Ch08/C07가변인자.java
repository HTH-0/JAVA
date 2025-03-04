package Ch08;


class C07Simple{
	
	int sum(int ...arg) {
		System.out.println(arg);
		int s = 0;
		for(int item : arg) {
			System.out.println(item);
			s += item;
		}
		return s;
	}
	
	
	
}



public class C07가변인자 {
	public static void main(String[] args) {
		
		C07Simple ob = new C07Simple();
		ob.sum(10,20,30,40,50);
		System.out.println();
		ob.sum(10,20,30,40,50,60,70,80,90,100,110);
		
	}
}
