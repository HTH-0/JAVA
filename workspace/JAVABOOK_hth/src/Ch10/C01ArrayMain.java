package Ch10;

import java.util.Arrays;
import java.util.Scanner;

public class C01ArrayMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr1 = new int[5];

		System.out.println("배열길이 : " + arr1.length);
		System.out.println("5개의 값을 입력하세요");

		// 배열 입력받기
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt();
		}

		// for
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(i + "번째 배열 " + arr1[i]);
		}
		System.out.println("----------------");

		// for each
		for (int el : arr1) {
			System.out.println(el);
		}
		System.out.println("----------------");

		// 람다 스트림
		// Arrays.stream(arr1).forEach(el -> System.out.println);
		Arrays.stream(arr1).forEach(System.out::println);

		// 배열에 입력된 정수 중에 최대값과 최소값을 출력
		
		// case 1
		int max = arr1[0];
		int min = arr1[0];
		
		for(int i = 0; i<arr1.length; i++) {
			if(arr1[i]>max) {
				max = arr1[i];
			}
			if(arr1[i] < min) {
				min = arr1[i];
			}
		}

		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		// case 2
		// 배열을 오름/내림차순 정렬 한 뒤 첫번째와 마지막 배열 고른다.
		
		// 내림차순 정렬
		for(int i = 0; i<arr1.length; i++) {
			for(int j = i; j<arr1.length; j++) {
				if (arr1[i] > arr1[j]) {
					int tmp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = tmp;
				}
			}
		}
		
		System.out.println("최대 : " + arr1[arr1.length - 1]);
		System.out.println("최소 : " + arr1[0]);
		
		
		// case 3 
		// stream을 이용해서
		System.out.println("최대 : " + Arrays.stream(arr1).max().getAsInt());
		System.out.println("최소 : " + Arrays.stream(arr1).min().getAsInt());
		
		sc.close();
	}
}
