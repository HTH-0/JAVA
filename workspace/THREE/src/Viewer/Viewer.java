package Viewer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.FrontController;
import Domain.BookDTO;

public class Viewer {
	// 사용자의 상태정보
	private String userid; // UserId
	private String username; // Username
	private String role;

	private Scanner sc = new Scanner(System.in);

	private FrontController controller;

	Viewer() throws Exception {
		controller = FrontController.getInstance();
	}

	public void MainMenu() {

		while (true) {
			System.out.println("------------M E N U--------------");
			System.out.println("1 Book_Tbl");
			System.out.println("2 Member_Tbl");
			System.out.println("3 Rental_Tbl");
			System.out.println("4 Exit");
			System.out.print("번호 : ");
			int num = sc.nextInt();

			if (num == 4)
				break; // 종료 조건

//			if (num != 1) {
//				System.out.println("다시 입력해주세요");
//				continue; // 메뉴 처음으로 다시
//			}

			while (true) { // Book_Tbl 서브 메뉴 루프
				System.out.println("1 Insert");
				System.out.println("2 Update");
				System.out.println("3 Select");
				System.out.println("4 SelectAll");
				System.out.println("5 Delete");
				System.out.println("6 Prev");
				System.out.print("번호 : ");
				int subNum = sc.nextInt();

				switch (subNum) {
				case 1:
					// insert 메서드
					Insert();
					break;
				case 2:
					// update 메서드
					Update();
					break;
				case 3:
					// Select 메서드
					Select();
					break;
				case 4:
					// selectAll 메서드
					SelectAll();
					break;
				case 5:
					// delete 메서드
					Delete();
					break;
				case 6:
					// 서브메뉴 종료 → 메인 메뉴로 돌아감
					System.out.println("메인 메뉴로 돌아갑니다.");
					break;
				default:
					System.out.println("다시 입력해주세요.");
				}

				if (subNum == 6)
					break; // 내부 while 탈출
			}
		}

	}

	public void Insert() {
		System.out.println("------------INSERT--------------");
		System.out.print("BOOK_CODE : ");
		String book_code = sc.next();
		System.out.print("CLASSIFICATION_ID : ");
		String classification_id = sc.next();
		System.out.print("BOOK_AUTHOR : ");
		String book_author = sc.next();
		System.out.print("BOOK_NAME : ");
		String book_name = sc.next();
		System.out.print("PUBLISHER : ");
		String publisher = sc.next();
		System.out.print("ISRESERVE : ");
		String isreserve = sc.next();

		// 요청처리
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/book");
		params.put("serviceNo", 1);
		params.put("BOOK_CODE", book_code);
		params.put("CLASSIFICATION_ID", classification_id);
		params.put("BOOK_AUTHOR", book_author);
		params.put("BOOK_NAME", book_name);
		params.put("PUBLISHER", publisher);
		params.put("ISRESERVE", isreserve);

		Map<String, Object> response = controller.execute(params);

		for (String key : response.keySet())
			System.out.println(key + " : " + response.get(key));

	}

	public void Update() {
		System.out.println("------------UPDATE--------------");
		System.out.print("BOOK_CODE : ");
		String book_code = sc.next();
		System.out.print("CLASSIFICATION_ID : ");
		String classification_id = sc.next();
		System.out.print("BOOK_AUTHOR : ");
		String book_author = sc.next();
		System.out.print("BOOK_NAME : ");
		String book_name = sc.next();
		System.out.print("PUBLISHER : ");
		String publisher = sc.next();
		System.out.print("ISRESERVE : ");
		String isreserve = sc.next();

		// 요청처리
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/book");
		params.put("serviceNo", 2);
		params.put("BOOK_CODE", book_code);
		params.put("CLASSIFICATION_ID", classification_id);
		params.put("BOOK_AUTHOR", book_author);
		params.put("BOOK_NAME", book_name);
		params.put("PUBLISHER", publisher);
		params.put("ISRESERVE", isreserve);

		Map<String, Object> response = controller.execute(params);

		for (String key : response.keySet())
			System.out.println(key + " : " + response.get(key));
	}

	public void Select() {
		System.out.println("------------SELECT--------------");
		System.out.print("BOOK_CODE : ");
		String book_code = sc.next();
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/book");
		params.put("serviceNo", 3);
		params.put("BOOK_CODE", book_code);
		Map<String, Object> response = controller.execute(params);

		for (String key : response.keySet())
			System.out.println(key + " : " + response.get(key));
	}

	public void SelectAll() {
		System.out.println("------------SELECTALL--------------");

		// 요청 생성
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/book");
		params.put("serviceNo", 4);

		// 컨트롤러 호출
		Map<String, Object> response = controller.execute(params);

		// 결과 처리
		Object statusObj = response.get("status");
		if (statusObj instanceof Boolean && (Boolean) statusObj) {
			System.out.println("전체 도서 목록:");

			// bookList 꺼내기 (캐스팅)
			Object listObj = response.get("book_code");
			if (listObj instanceof List<?>) {
				List<?> list = (List<?>) listObj;

				for (Object obj : list) {
					if (obj instanceof BookDTO) {
						BookDTO book = (BookDTO) obj;
						System.out.println("----------------------------------");
						System.out.println("BOOK_CODE       : " + book.getBOOK_CODE());
						System.out.println("CLASSIFICATION  : " + book.getCLASSIFICATION_ID());
						System.out.println("AUTHOR          : " + book.getBOOK_AUTHOR());
						System.out.println("BOOK_NAME       : " + book.getBOOK_NAME());
						System.out.println("PUBLISHER       : " + book.getPUBLISHER());
						System.out.println("ISRESERVE       : " + book.getISRESERVE());
					}
				}
				System.out.println("----------------------------------");
			}
		} else {
			System.out.println("조회 실패: " + response.get("message"));
		}
	}

	public void Delete() {
		System.out.println("------------DELETE--------------");
		System.out.print("BOOK_CODE : ");
		String book_code = sc.next();

		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/book");
		params.put("serviceNo", 5);
		params.put("BOOK_CODE", book_code);

		Map<String, Object> response = controller.execute(params);

		for (String key : response.keySet())
			System.out.println(key + " : " + response.get(key));

	}

}
