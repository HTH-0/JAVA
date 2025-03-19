package Ch24;

import java.io.DataOutputStream;
import java.util.Scanner;

public class ClientSendThread implements Runnable {

	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);

	ClientSendThread(DataOutputStream dout) {
		this.dout = dout;
	}

	public void run() {
		String send;

		try {
			while (true) {

				// SERVER->CLIENT (송신)
				System.out.print("[CLIENT(q:종료)] :");
				send = sc.nextLine();
				if (send.equals("q")) {
					break;
				}
				dout.writeUTF(send);
				dout.flush();
			}
		} catch (Exception e) {
			System.out.println("[CLIENT] 연결 오류 발생: " + e.getMessage());
		} finally {
			try {
				if (dout != null)
					dout.close();
				if (sc != null)
					sc.close();
			} catch (Exception e) {
				System.out.println("[CLIENT] 리소스 해제 중 오류 발생: " + e.getMessage());

			}
		}
	}
}
