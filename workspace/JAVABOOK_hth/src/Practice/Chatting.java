package Practice;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class GUI extends JFrame {

	String filePath = "C:\\Users\\Administrator\\Downloads\\Chatting_log.txt";

	GUI(String title) {
		super(title);
		setBounds(100, 100, 500, 470);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//			panel
		JPanel panel = new JPanel();
		panel.setLayout(null);

//			Component

		// 텍스트 에어리어
		JTextArea area1 = new JTextArea();
		area1.setMargin(new Insets(5, 10, 5, 10));
		area1.setEditable(false);
		// 스크롤
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(20, 20, 320, 320);

		// 텍스트필드
		JTextField txt1 = new JTextField();
		txt1.setBounds(20, 370, 320, 40);
		txt1.setMargin(new Insets(5, 10, 5, 10));

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

//			이벤트

		// input 버튼 이벤트
		input.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = txt1.getText(); // 텍스트를 가져온다
				if (!text.trim().isEmpty()) { // 빈 내용이 아니라면
					area1.append(text + "\n"); // area에 붙이고
					txt1.setText(""); // 입력창 초기화
				}
			}

		});

		// 엔터키 이벤트
		txt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				input.doClick();
			}
		});

		// 파일 저장 이벤트
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
					bw.write(area1.getText());
					bw.close();
					JOptionPane.showMessageDialog(null, "파일 저장 완료", "파일 저장", JOptionPane.INFORMATION_MESSAGE);

				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "파일 저장 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(filePath));
					area1.setText("");
					String line;
					while ((line = br.readLine()) != null) {
						area1.append(line + "\n");
					}
					br.close();
					JOptionPane.showMessageDialog(null, "성공적으로 불러왔습니다.", "파일 로드", JOptionPane.INFORMATION_MESSAGE);

				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "파일을 불러오는 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

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

public class Chatting {

	public static void main(String[] args) {

		JFrame f1 = new JFrame();

		new GUI("Chatting Server");
	}

}
