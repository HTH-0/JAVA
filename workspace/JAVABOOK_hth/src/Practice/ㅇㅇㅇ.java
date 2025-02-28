package Practice;

public class ㅇㅇㅇ {

}

class Solution {
	public int solution(int num) {
		int answer = 0;
		if (num == 1) {
			answer = 0;
		} else if (answer < 500) {

			while (num != 1) {

				if (num % 2 == 0) {
					num = num / 2;
					answer++;
				} else if (num % 2 == 1) {
					num = (3 * num) + 1;
					answer++;
				}
			}

		} else if (answer >= 500) {
			answer = -1;
		}
		return answer;

	}
}