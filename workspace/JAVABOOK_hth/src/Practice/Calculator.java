package Practice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator extends JFrame {

    private JTextArea area1; // 🔥 인스턴스 변수로 선언
    private String num1 = "", num2 = "", operator = "";
    private boolean isOperatorClicked = false;

    public Calculator(String title) {
        super(title);
        setBounds(100, 100, 440, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 패널
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        // 계산기 화면 (🔥 지역 변수 X → 인스턴스 변수로 변경)
        area1 = new JTextArea();
        area1.setMargin(new Insets(5, 10, 5, 10));
        area1.setForeground(Color.BLACK);
        area1.setEditable(false);
        area1.setFont(new Font("Arial", Font.BOLD, 24));
        area1.setBounds(20, 20, 380, 100);
        panel.add(area1);

        // 버튼 배열 생성
        JButton[] btn = new JButton[17];
        String[] labels = { "C", "/", "*", "-",
        					"7", "8", "9", "+", 
        					"4", "5", "6",
        					"1", "2", "3", "=",
        					"0", "." };

        Color[] colors = {
                new Color(255, 59, 59), 
                new Color(169, 169, 169), new Color(169, 169, 169), new Color(169, 169, 169), 
                new Color(240, 240, 240), new Color(240, 240, 240), new Color(240, 240, 240), new Color(169, 169, 169),
                new Color(240, 240, 240), new Color(240, 240, 240), new Color(240, 240, 240), 
                new Color(240, 240, 240), new Color(240, 240, 240), new Color(240, 240, 240), new Color(76, 175, 80),
                new Color(240, 240, 240), new Color(240, 240, 240) 
        };

        // 버튼 배치
        int[][] positions = {
                { 20, 140 }, { 120, 140 }, { 220, 140 }, { 320, 140 }, 
                { 20, 220 }, { 120, 220 }, { 220, 220 }, { 320, 220 }, 
                { 20, 300 }, { 120, 300 }, { 220, 300 }, 
                { 20, 380 }, { 120, 380 }, { 220, 380 }, { 320, 380 }, 
                { 20, 460 }, { 220, 460 } 
        };

        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton(labels[i]);

            // 버튼 크기 조정
            int width = 80, height = 60;
            if (labels[i].equals("0")) width = 180; // 0 버튼만 가로 180px
            if (labels[i].equals("+") || labels[i].equals("=")) height = 140; // +, = 버튼만 세로 140px

            btn[i].setBounds(positions[i][0], positions[i][1], width, height);
            btn[i].setBackground(colors[i]);
            btn[i].setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(btn[i]);
            
            // ✅ 버튼에 이벤트 리스너 등록
            btn[i].addActionListener(new CalculatorListener());
        }

        add(panel);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    // ✅ 이벤트 리스너 클래스 (사칙연산 기능)
    private class CalculatorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            // C 버튼: 초기화
            if (command.equals("C")) {
                num1 = "";
                num2 = "";
                operator = "";
                isOperatorClicked = false;
                area1.setText(""); // 🔥 JTextArea 업데이트
                return;
            }

            // = 버튼: 연산 실행
            if (command.equals("=")) {
                if (!num1.isEmpty() && !num2.isEmpty() && !operator.isEmpty()) {
                    double result = calculate(Double.parseDouble(num1), Double.parseDouble(num2), operator);
                    area1.setText(String.valueOf(result)); // 🔥 JTextArea 업데이트
                    num1 = String.valueOf(result);
                    num2 = "";
                    operator = "";
                    isOperatorClicked = false;
                }
                return;
            }

            // 연산자 버튼 클릭
            if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                if (!num1.isEmpty()) {
                    operator = command;
                    isOperatorClicked = true;
                }
                return;
            }

            // 숫자 및 소수점 버튼 클릭
            if (command.matches("[0-9.]")) {
                if (!isOperatorClicked) {
                    num1 += command;
                    area1.setText(num1); // 🔥 JTextArea 업데이트
                } else {
                    num2 += command;
                    area1.setText(num2); // 🔥 JTextArea 업데이트
                }
            }
        }
    }

    private double calculate(double n1, double n2, String op) {
        switch (op) {
            case "+": return n1 + n2;
            case "-": return n1 - n2;
            case "*": return n1 * n2;
            case "/": return (n2 != 0) ? n1 / n2 : 0; // 0으로 나누기 방지
            default: return 0;
        }
    }

    public static void main(String[] args) {
        new Calculator("계산기");
    }
}
