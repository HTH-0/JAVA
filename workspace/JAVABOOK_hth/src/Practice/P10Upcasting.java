package Practice;

class Appliance{
	void powerOn() {
		System.out.println("전원 on");
	}
	void powerOff() {
		System.out.println("전원 off");
	}
}
class Tv extends Appliance{
	
	@Override
	void powerOn() {
		System.out.println("Tv를 켭니다.");
	}
	@Override
	void powerOff() {
		System.out.println("Tv를 끕니다.");
	}
	
	void Channelchange(){
		System.out.println("채널을 바꿉니다.");
	}
}

public class P10Upcasting {
	public static void main(String[] args) {
		
		Appliance t1 = new Tv();
		t1.powerOn();
		t1.powerOff();
		
		
		
		
		
		
	}

}
