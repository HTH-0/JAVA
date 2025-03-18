package Ch23;

public class C03Worker2 implements Runnable{

C03GUI gui;
	
	C03Worker2(C03GUI gui) {
		this.gui = gui;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				gui.area2.append("WORKER02... \n");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("WORKER02 INTERRUPTED...");
	}

}
