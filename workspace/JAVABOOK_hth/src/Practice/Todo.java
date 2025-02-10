package Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Todo {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<String> TodoList = new ArrayList<>();

		while (true) {
			System.out.println("\n📌 To-Do List");
			System.out.println("1. 할 일 추가");
			System.out.println("2. 리스트 삭제");
			System.out.println("3. 조회");
			System.out.println("4. 종료하기");
			System.out.print("선택 : ");

			int Select = sc.nextInt();
			sc.nextLine(); // 버퍼 비우기

			switch (Select) {

			// 할일추가
			case 1:
				while(true) {
				System.out.println("추가 할 내용 : ");
				String task = sc.nextLine();
				if(task.equals("Y")) {
					break;
				}
				TodoList.add(task);
				System.out.println("추가되었습니다. 추가할 내용이 없다면 Y를 입력해주세요");
				}
				continue;

			// 리스트 삭제
			case 2:
				System.out.println("삭제하고 싶은 번호를 입력해주세요");
				for (int i = 1; i <= TodoList.size(); i++) {
					System.out.println(i + "." + TodoList.get(i - 1));
				}
				System.out.println("번호 선택 : ");
				int num = sc.nextInt() - 1;

				if (num >= 0 && num < TodoList.size()) {
					TodoList.remove(num);
					System.out.println("삭제되었습니다");
				} else {
					System.out.println("번호를 다시 입력해주세요");
				}
				break;
				// 조회
			case 3:
				System.out.println("📄 List ");
				if (TodoList.isEmpty()) {
					System.out.println("리스트가 비어있습니다\n할 일을 추가해주세요");
				} else {
					for (int i = 1; i <= TodoList.size(); i++) {
						System.out.println(i + "." + TodoList.get(i - 1));
					}
				}
				break;

				// 종료
			case 4:
				System.out.println("종료합니다.");
				sc.close();
				return;
			default:
				System.out.println("번호를 다시 입력해주세요");
			}

		}

	}
}