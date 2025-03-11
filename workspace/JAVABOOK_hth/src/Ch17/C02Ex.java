package Ch17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C02Ex {
	Scanner sc = new Scanner(System.in);

	public static void func1(List<String> list) {
		// ArrayList에 있는 정수값을 입력받는데 전달되는 수 중에
		// 짝수의 값만 입력받는 코드 작성
		
		
		List<Integer> evenList = new ArrayList<>();
		for (String el : list) {
			try {
				int num = Integer.parseInt(el); // 문자열을 숫자로 변환
				if (num % 2 == 0) { // 짝수인지 확인
					evenList.add(num); // 짝수만 리스트에 추가
				}
			} catch (NumberFormatException e) {

			}
		}
	}

	public static List<String> func2(List<String> list) {
		// ArrayList에 있는 문자열 중에서 길이가 5보다 큰 문자열만 필터링해서 리턴하는 함수
		List<String> lengthFilterList = new ArrayList<>();

		for (String el : list) {
			if (el.length() > 5) {
				lengthFilterList.add(el);
			}
		}

		return lengthFilterList;

	}

	public static int func3(List<String> list) {
		// ArrayList에 있는 문자열 중에서 숫자형 데이터만 추출해서 합을 구하기
		int numCheck = 0;
		for (String el : list) {
			try {
				numCheck += Integer.parseInt(el);
			} catch (NumberFormatException e) {

			}
		}
		return numCheck;
	}

	public static void main(String[] args) {
		List<String> li = new ArrayList<>();

		func1(li);

		List<String> lengthFilterList = func2(li);

		int sum = func3(lengthFilterList);

		System.out.println(sum);

	}
}
