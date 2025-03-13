package Practice;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Todo2 {

	private static final String FILE_NAME = "C:/Users/Administrator/Downloads/TodoList.txt";
	private static ArrayList<String> TodoList = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Load();
		while (true) {
			System.out.println("\n📌 To-Do List");
			System.out.println("1. 할 일 추가");
			System.out.println("2. 리스트 삭제");
			System.out.println("3. 목록 조회");
			System.out.println("4. 검색하기");
			System.out.println("5. 종료하기");
			System.out.print("선택 : ");
			int Select = sc.nextInt();
			sc.nextLine(); // 버퍼 비우기

			switch (Select) {

			// 할일추가
			case 1:
				while (true) {
					System.out.println("추가 할 내용 : ");
					String task = sc.nextLine();
					if (task.equals("exit")) {
						break;
					}
					TodoList.add(task);
					Save(); // 추가 이후 저장
					System.out.println("추가되었습니다 (나가기 : exit)");
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
					Save(); // 삭제 이후 저장
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
				System.out.println("키워드를 입력해주세요 : ");
				String Search = sc.nextLine();
				System.out.println("🔍 검색 결과:");
				boolean found = false;
				for (int i = 0; i < TodoList.size(); i++) {
					if (TodoList.get(i).contains(Search)) {
						System.out.println(i + 1 + ". " + TodoList.get(i));
						found = true;
					}
				}
				if (!found) {
					System.out.println("검색 결과가 없습니다.");
				}
				break;

			case 5:
				System.out.println("종료합니다.");
				sc.close();
				return;

			default:
				System.out.println("번호를 다시 입력해주세요");
			}

		}

	}

	private static void Save() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
			for (String task : TodoList) {
				writer.write(task);
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("저장 중 오류 발생 : " + e.getMessage());
		}
	}

	private static void Load() {
		File loadData = new File(FILE_NAME);
		if (loadData.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(loadData))) {
				String line;
				while ((line = reader.readLine()) != null) {
					TodoList.add(line);
				}
			} catch (IOException e) {
				System.out.println("불러오기 중 오류 발생 : " + e.getMessage());
			}
		}
	}
}