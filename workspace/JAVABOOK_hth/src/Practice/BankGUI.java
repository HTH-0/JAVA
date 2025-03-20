package Practice;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BankGUI extends JFrame{
	
	// 은행 별 계좌/보유금액, 사용자가 저장되는 파일
	String filePath = "C:\\Users\\Administrator\\Downloads\\Bank_log.txt";
	
	BankGUI(String title){
		super(title);
		
		setBounds(0, 0, 600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		// panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
        mainPanel.setBounds(100, 100, 600, 800); // 프레임 크기와 동일
        mainPanel.setBackground(Color.WHITE);
        
		JPanel showData = new JPanel();
		showData.setBounds(100, 200, 400, 450); 
        showData.setBackground(Color.LIGHT_GRAY); 
		
		// component
        JButton AddBank = new JButton("은행 추가");
        JButton AddOwner = new JButton("사용자 추가");
        JButton Register = new JButton("계좌번호 등록");
		JButton Deposit = new JButton("입금");
		JButton Withdraw = new JButton("출금");
		JButton Save = new JButton("진행 저장");
        
        
		// 컴포넌트 add
		mainPanel.add(Save);
		mainPanel.add(AddOwner);
		mainPanel.add(AddBank);
		mainPanel.add(Register);
		
		showData.add(Deposit);
		showData.add(Withdraw);
		
		// 패널 추가
        mainPanel.add(showData);
        add(mainPanel);
		
		
		// 보이게
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		JFrame f1 = new JFrame();
		
		new BankGUI("은행 입출금");
	}
	
}
