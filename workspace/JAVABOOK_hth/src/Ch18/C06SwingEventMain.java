package Ch18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C06GUI extends JFrame implements ActionListener{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton input;
	C06GUI(String title){
		//frame
		super(title);
		setBounds(100,100,410,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		//Component 참조변수명
		JTextArea area1 = new JTextArea(); //textarea = area1
		area1.setBounds(10,10,260,280);
		//textarea's scroll = scroll1
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10,10,250,280);
		
		btn1 = new JButton("파일로저장");//파일로저장 : btn1
		btn1.setBounds(270,10,110,30);
		
		btn2 = new JButton("1:1요청");//1:1요청 : btn2
		btn2.setBounds(270,50,110,30);
		
		btn3 = new JButton("대화기록보기");//대화기록보기 : btn3
		btn3.setBounds(270,90,110,30);
		
		input = new JButton("입력"); //입력 : input
		input.setBounds(270,300,110,30);
		
		
		JTextField txt1 = new JTextField(); //textfield : txt1
		txt1.setBounds(10,300,250,30);
		
		//event listener add
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		input.addActionListener(this);
		
		//panel(component)
//		panel.add(area1);
		panel.add(scroll1);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(input);
		panel.add(txt1);
		
		//frame(panel)
		add(panel);

		//frame
		setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

//		System.out.println("클릭!");
		if(e.getSource()==btn1) {
			System.out.println("파일로 저장 클릭");
		}else if(e.getSource()==btn2) {
			System.out.println("1:1요청 클릭");
		}else if(e.getSource()==btn3) {
			System.out.println("대화기록보기");
		}else if(e.getSource()==input) {
			System.out.println("입력");
		}
	
		
	}
	
	
}

public class C06SwingEventMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		new C06GUI("Chatting UI");
		

		
	}

}
