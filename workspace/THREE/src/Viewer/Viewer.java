package Viewer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Controller.FrontController;

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

		    if (num == 4) break; // 종료 조건

		    if (num != 1) {
		        System.out.println("다시 입력해주세요");
		        continue; // 메뉴 처음으로 다시
		    }

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
		                break;
		            case 2:
		                // update 메서드
		                break;
		            case 3:
		                // Select 메서드
		                break;
		            case 4:
		                // selectAll 메서드
		                break;
		            case 5:
		                // delete 메서드
		                break;
		            case 6:
		                // 서브메뉴 종료 → 메인 메뉴로 돌아감
		                System.out.println("메인 메뉴로 돌아갑니다.");
		                break;
		            default:
		                System.out.println("다시 입력해주세요.");
		        }

		        if (subNum == 6) break; // 내부 while 탈출
		    }
		}

	}

	public void Insert() {
		System.out.println("--------------------------");
		System.out.println("회원정보 입력");
		System.out.println("--------------------------");
		System.out.print("USERID : ");
		String id = sc.next();
		System.out.print("USERNAME : ");
		String name = sc.next();
		System.out.print("PASSWORD: ");
		String pw = sc.next();

		// 요청처리
		Map<String, Object> params = new HashMap<>();
		params.put("endPoint", "/user");
		params.put("serviceNo", 1);
		params.put("userid", id);
		params.put("username", name);
		params.put("password", pw);

		Map<String, Object> response = controller.execute(params);

		for (String key : response.keySet())
			System.out.println(key + " : " + response.get(key));

	}

	public void loginMenu() {
		System.out.println("--------------------------");
		System.out.println("로그인");
		System.out.println("--------------------------");
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();

	}

	public void 사서Menu() {
		while (true) {
			System.out.println("--------------------------");
			System.out.println("사서메뉴");
			System.out.println("--------------------------");
			System.out.println("[도서]			[회원]			[대여]");
			System.out.println("1 도서조회하기		5 회원 전체조회		7 도서 대여");
			System.out.println("2 도서추가하기		6 회원 단건조회		8 도서 반납");
			System.out.println("3 도서수정하기		 						");
			System.out.println("4 도서삭제하기								");
			System.out.println("9 이전으로");
			System.out.println("10로그아웃");
			System.out.print("번호 : ");
			int num = sc.nextInt();
			switch (num) {
			case 1:

				break;
			case 2:
				BookMenu();
				break;
			case 3:
				break;

			case 7:

				break;

			case 10:

				// 로그아웃
				return;
			}

		}
	}

	public void 회원Menu() {
		while (true) {
			System.out.println("--------------------------");
			System.out.println("회원메뉴");
			System.out.println("--------------------------");
			System.out.println("[도서]			[회원]			[대여]");
			System.out.println("1 도서조회하기		5 나의 정보조회		8 대여 도서 조회");
			System.out.println("2 도서추가하기		6 나의 정보수정		9 대여 도서 예약");
			System.out.println("3 도서수정하기		7 회원 탈퇴					");
			System.out.println("4 도서삭제하기									");

			System.out.println("10 이전으로");
			System.out.println("11 로그아웃");
			System.out.print("번호 : ");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;

			case 5:
				return;

			}
		}
	}

	public void BookMenu() {
		System.out.println("--------------------------");
		System.out.println("도서 정보 입력");
		System.out.println("--------------------------");
		System.out.printf("도서코드 도서명 출판사 ISBN순으로 입력 : ");
		String bookcode = sc.next();
		String bookname = sc.next();
		String publisher = sc.next();
		String isbn = sc.next();

		// 컨트롤러 호출!

	}

	public void MemberMenu() {
		System.out.println("--------------------------");
		System.out.println("회원 정보 입력");
		System.out.println("--------------------------");
		System.out.printf("ID PW USERNAME ROLE 순으로 입력 : ");
		String id = sc.next();
		String pw = sc.next();
		String username = sc.next();
		String role = sc.next();

	}

	public void LendMenu() {
		System.out.println("--------------------------");
		System.out.println("대여 정보 입력");
		System.out.println("--------------------------");

		System.out.printf("BOOKCODE USERID 입력 : ");
		int bookcode = sc.nextInt();
		String id = sc.next();

	}
}
