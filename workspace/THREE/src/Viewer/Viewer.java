package Viewer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.FrontController;
import Domain.BookDTO;

public class Viewer {
	private Scanner sc = new Scanner(System.in);

	private FrontController controller;

	public Viewer() throws Exception {
		controller = FrontController.getInstance();
	}

	public void MainMenu() {
		boolean isRunning = true;

		while (isRunning) {
			System.out.println("------------M E N U--------------");
			System.out.println("1 Book_Tbl");
			System.out.println("2 Member_Tbl");
			System.out.println("3 Rental_Tbl");
			System.out.println("4 Exit");
			System.out.println("------------M E N U--------------");
			System.out.print("번호 : ");
			int num = sc.nextInt();

			if (num == 4) {
				System.out.println("시스템을 종료합니다.");
				break; // 종료 조건
			}
			if (num == 2 || num == 3) {
				System.err.println("1번을 선택해주세요.");
			}
			if (num != 1 && num != 2 && num != 3) {
				System.err.println("다시 입력해주세요");
				continue; // 메뉴 처음으로 다시
			}
			if (num == 1) {
				boolean isSubRunning = true;
				while (isSubRunning) { // Book_Tbl 서브 메뉴 루프
					System.out.println("------------B O O K--------------");
					System.out.println("1 Insert");
					System.out.println("2 Update");
					System.out.println("3 Select");
					System.out.println("4 SelectAll");
					System.out.println("5 Delete");
					System.out.println("6 Prev");
					System.out.println("------------B O O K--------------");
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
						System.err.println("다시 입력해주세요.");
					}

					if (subNum == 6)
						break; // 내부 while 탈출
				}
			}
		}

	}

	public void Insert() {
		System.out.println("------------INSERT--------------");
		System.out.println("BOOK_CODE는 5자 이상으로 입력.");
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
		System.out.print("ISRESERVE (0: 미예약, 1: 예약됨) : ");
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
		System.out.println("바꾸고 싶은 북코드를 입력해주세요.");
		System.out.print("BOOK_CODE : ");
		String book_code = sc.next();
		System.out.println("변경 하실 값을 입력해주세요.");
		System.out.print("CLASSIFICATION_ID : ");
		String classification_id = sc.next();
		System.out.print("BOOK_AUTHOR : ");
		String book_author = sc.next();
		System.out.print("BOOK_NAME : ");
		String book_name = sc.next();
		System.out.print("PUBLISHER : ");
		String publisher = sc.next();
		System.out.print("ISRESERVE (0: 미예약, 1: 예약됨) : ");
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

		// 에러 메시지 출력
		if (response.containsKey("ERROR")) {
			System.err.println("오류: " + response.get("ERROR"));
			return;
		}

		if (response.containsKey("status") && (Boolean) response.get("status")) {
			// BookDTO 받아서 출력
			BookDTO book = (BookDTO) response.get("book");

			System.out.println("-------- 도서 상세 정보 --------");
			System.out.printf("%-15s : %s\n", "BOOK_CODE", book.getBOOK_CODE());
			System.out.printf("%-15s : %s\n", "CLASSIFICATION_ID", book.getCLASSIFICATION_ID());
			System.out.printf("%-15s : %s\n", "BOOK_AUTHOR", book.getBOOK_AUTHOR());
			System.out.printf("%-15s : %s\n", "BOOK_NAME", book.getBOOK_NAME());
			System.out.printf("%-15s : %s\n", "PUBLISHER", book.getPUBLISHER());
			System.out.printf("%-15s : %s\n", "ISRESERVE", book.getISRESERVE().equals("1") ? "예약됨" : "미예약");
			System.out.println("--------------------------------");
		} else {
			System.out.println("조회 실패: " + response.get("message"));
		}
	}


	public void SelectAll() {
		System.out.println("------------SELECT ALL--------------");

		// 요청 생성
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/book");
		params.put("serviceNo", 4);

		// 컨트롤러 호출
		Map<String, Object> response = controller.execute(params);
		
		// 추가: 오류 메시지가 있을 경우 출력
		if (response.containsKey("message")) {
		    System.out.println("결과: " + response.get("message"));
		}
		if (response.containsKey("ERROR")) {
		    System.err.println("오류: " + response.get("ERROR"));
		}
		
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
