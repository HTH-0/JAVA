package Ch18;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GUI extends JFrame{
	GUI(String title){
		super(title);
		setBounds(100, 100, 500, 470);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//			panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
//			Component
		
		// 텍스트 에어리어
		JTextArea area1 = new JTextArea();
		// 스크롤
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(20, 20, 320, 320);
		
		// 텍스트필드
		JTextField txt1 = new JTextField();
		txt1.setBounds(20, 370, 320, 40);
		
		// 버튼
		JButton btn1 = new JButton("파일로 저장");
		btn1.setBounds(360, 20, 110, 40);
		JButton btn2 = new JButton("1 : 1 요청");
		btn2.setBounds(360, 120, 110, 40);
		JButton btn3 = new JButton("대화기록보기");
		btn3.setBounds(360, 220, 110, 40);
		
		// 인풋
		JButton input = new JButton("입력");
		input.setBounds(360, 370, 110, 40);
		
//			panel 에 component 붙이기
		panel.add(scroll1);
		panel.add(txt1);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(input);
		
		
//			프레임에 패널 붙이기
		add(panel);
		
//		 	Frame
		setVisible(true);
	}
}




public class C05Ex {

	public static void main(String[] args) {
		
		//Component 참조변수명
		//textarea = area1
		//textarea's scroll = scroll1
		//파일로저장 : btn1
		//1:1요청 : btn2
		//대화기록보기 : btn3
		//입력 : input
		//textfield : txt1
		
		JFrame f1 = new JFrame();
		
		new GUI("Chatting Server");
	}

}
