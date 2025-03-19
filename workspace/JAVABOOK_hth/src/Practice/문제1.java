package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 문제1 {
	private static Scanner sc = new Scanner(System.in);
	private static List<String> wordlist = new ArrayList<String>();
	
	
	public static void sort (boolean isAsend) {
		// 오름차순 >> true
		// 내림차순 >> false
		if(isAsend == true) {
			Collections.sort(wordlist);	// 리스트를 오름차순
		}else{
			Collections.sort(wordlist);
			Collections.reverse(wordlist);	// 오름차순 시킨 뒤에 역배치한다.
		}
	}
	
	public static void add(String word) {
		wordlist.add(word);
	}
	public static void show() {
		if(wordlist.isEmpty()) {
			System.out.println("저장된 단어가 없습니다. 새로운 단어를 추가해주세요");
			return;
		}
		// 향상된 for 문을 이용하여 배열을 처음부터 끝까지 실행한다.
		for(String el : wordlist) {
			System.out.println(el);
		}
	}
	
	public static void main(String[] args) {
		
		int n = 0;
		while(true) {
			System.out.println("-----------MENU-----------");
			System.out.println("1 추가");
			System.out.println("2 정렬");
			System.out.println("3 확인");
			System.out.println("4 종료");
			System.out.println("-----------MENU-----------");
			System.out.print("번호 : ");
			n = sc.nextInt();
			
			switch (n) {
			
			case 1 :
				System.out.print("단어 입력 : ");
				String word = sc.next();
				add(word);
				break;
				
			case 2 :
				System.out.print("오름차순 여부 (1: 오름차순, 0: 내림차순)");
				int no = sc.nextInt();
				if(no == 1) {
					sort(true);
				}else {
					sort(false);
				}
				break;
				
			case 3 :
				show();
				break;
				
			case 4 :
				System.out.println("종료합니다");
				sc.close();
				System.exit(-1);
				break;
			
			default :
				System.out.println("다시 입력 하세요");
			}
		}
	}
}
