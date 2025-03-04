package Practice;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

// 난수를 만들어내는 클래스
class MakeNum {
	public static int[] RandomArr(int length) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random random = new Random();

		// Fisher-Yates 셔플
		for (int i = numbers.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}

		return Arrays.copyOf(numbers, length);
	}
}

public class BASEBALL {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			int length = 3;
			int Chance = 9;
			int[] Goal = MakeNum.RandomArr(length);

			System.out.println("\n⚾ 게임 시작 ⚾\n");

			System.out.println("정답: " + Arrays.toString(Goal)); // 정답 확인용

			// 9번의 기회가 주어지는 게임 시작
			for (int i = 1; i <= Chance; i++) {
				int[] Input = new int[length];
				System.out.println("< " + i + "번째 시도 >\n숫자를 입력해주세요 : ");

				int count = 0; // 올바른 숫자를 입력한 개수

				while (count < length) {
					int num = sc.nextInt();

					// 1~9 범위 검사
					if (num < 1 || num > 9) {
						System.out.println("❌ 1부터 9까지의 숫자만 입력해주세요");
						continue;
					}

					// 중복 검사
					boolean duplicate = false;
					for (int j = 0; j < count; j++) {
						if (Input[j] == num) {
							duplicate = true;
							break;
						}
					}

					if (duplicate) {
						System.out.println("❌ 중복된 숫자입니다");
						continue;
					}

					// 유효한 숫자면 배열에 저장
					Input[count] = num;
					count++;
				}

				// Strike, Ball 판단
				int strike = 0;
				int ball = 0;

				for (int j = 0; j < length; j++) {
					for (int k = 0; k < length; k++) {
						if (Input[j] == Goal[k]) {
							if (j == k) {
								strike++; // 같은 자리 같은 숫자
							} else {
								ball++; // 숫자만 같고 자리 다름
							}
						}
					}
				}

				// 결과 출력
				if (strike == length) {
					System.out.println("🎉 성공 🎉");
					break;
				} else {
					System.out.println(strike + " Strike, " + ball + " Ball\n");
				}

				// 기회를 다 썼을 때
				if (i == Chance) {
					System.out.println("😥 실패 😥");
					System.out.println("정답은 " + Arrays.toString(Goal));
				}
			}
			System.out.println("\n 다시 하시겠습니까? (Y/N)");
			sc.nextLine();// 개행문제 없애는 용도
			
			// 입력받은 값을 공백 없애고 대문자로 바꿔서 저장한다.
			String restart = sc.nextLine().trim().toUpperCase();
			if (restart.equals("Y")) {
				System.out.println("다시 시작합니다\n");
			} else if (restart.equals("N")) {
				System.out.println("게임을 종료합니다");
				break;
			} else {
				System.out.println("< INPUT Y/N >");
			}

		}
		sc.close();
	}
}
