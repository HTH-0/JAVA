package Ch08;
import java.util.Scanner;

class Grade{
	int subject1;
	int subject2;
	int subject3;
	
	Grade(int subject1,int subject2,int subject3){
		this.subject1=subject1;
		this.subject2=subject2;
		this.subject3=subject3;
	}
	
	public double average(){
		return (double)(subject1 + subject2 + subject3)/3;
	}
}

public class Ex4_2Grade {
	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
		   
		   System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
		   int math = sc.nextInt();
		   int science = sc.nextInt();
		   int english = sc.nextInt();
		   Grade me = new Grade(math, science, english);
		   System.out.println("평균은 "+me.average()); // average()는 평균을 계산하여 리턴
		   
		   sc.close();
		}
}
