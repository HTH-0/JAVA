package Ch13;

interface Remocon {

	int MAX_VOL = 100;		// public static final
	int MIN_VOL = 0;		// public static final
	
	void powerOn();			// abstract function

	void powerOff();		// abstract function
	
	// 최대 최소 볼륨 조절, 100이상 최대로 고정 + 메세지, 0이하 최소로 고정 + 메세지
	void SetVolumn(int vol);
}

interface Browser{
	void SearchURL(String url);
}

class Tv implements Remocon {
	@Override
	public void powerOn() {
		System.out.println("TV를 켭니다. ");
	}
	
	@Override
	public void powerOff() {
		System.out.println("TV를 끕니다. ");
	}
	
	@Override
	public void SetVolumn(int vol){
		int Tvol = vol;
		if(MAX_VOL < Tvol) {
			System.out.println("최대 볼륨을 넘어갈 수 없습니다");
			Tvol = MAX_VOL;
		}
		else if(MIN_VOL > Tvol) {
			System.out.println("최소 볼륨을 넘어갈 수 없습니다");
			Tvol = MIN_VOL;
		}
		System.out.println("TV 볼륨 : " + Tvol);
	}
	
}

class SmartTv extends Tv implements Browser{
	
	@Override
	public void SearchURL(String url){ 
		System.out.println(url + "로 이동합니다");
	}
}
class Radio implements Remocon {
	@Override
	public void powerOn() {
		System.out.println("Radio를 켭니다. ");
	}
	
	@Override
	public void powerOff() {
		System.out.println("Radio를 끕니다. ");
	}
	
	@Override
	public void SetVolumn(int vol){
		int Rvol = vol;
		if(MAX_VOL < Rvol) {
			System.out.println("최대 볼륨을 넘어갈 수 없습니다");
			Rvol = MAX_VOL;
		}
		else if(MIN_VOL > Rvol) {
			System.out.println("최소 볼륨을 넘어갈 수 없습니다");
			Rvol = MIN_VOL;
		}
		System.out.println("Radio 볼륨 : " + Rvol);
	}
	
	
}

public class C03InterfaceMain {

	public static void TurnOn(Remocon controller) {
		controller.powerOn();
	}
	public static void TurnOff(Remocon controller) {
		controller.powerOff();
	}
	public static void SetVolumn(Remocon controller, int vol) {
		controller.SetVolumn(vol);
	}
	public static void Internet(Browser browser, String url) {
		browser.SearchURL(url);
	}
	
	public static void main(String[] args) {

		
		Tv tv = new Tv();
		SmartTv smarttv = new SmartTv();
		Radio radio = new Radio();
		
		tv.SetVolumn(30);
		SetVolumn(tv, 110);
		
		SetVolumn(smarttv, 40);
		Internet(smarttv, "www.naver.com");
		
		TurnOn(tv);
		TurnOff(tv);
		
		TurnOn(radio);
		TurnOff(radio);
		
		
		
	}
}
