package Ch18;

import javax.swing.JFrame;

public class C01SwingMain {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("첫번째 프레임");
		
		frame.setBounds(100,100,500,500);
		
		// x버튼을 눌렀을 때 프로세스가 종료되게 한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
}
