package Practice;
public class P11Downcasting {
	public static void main(String[] args) {
		
		Appliance a1 = new Tv();		// 업캐스팅일 때
		a1.powerOn();
		
		Tv t1 = (Tv) a1;
		t1.Channelchange();// 업캐스팅 했던 a1을 다시 t1으로 다운캐스팅 해야 사용가능.
		
	}
}
