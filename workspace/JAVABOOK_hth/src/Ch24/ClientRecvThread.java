package Ch24;

import java.io.DataInputStream;

public class ClientRecvThread implements Runnable {

	DataInputStream din;

	ClientRecvThread(DataInputStream din) {
		this.din = din;
	}

	public void run() {
		String recv;

		try {
			while (true) {
				// CLIENT->SERVER (수신)
				recv = din.readUTF();
				if (recv.equals("q"))
					break;
				System.out.println("[CLIENT] : " + recv);
			}
		} catch (Exception e) {
			System.out.println("[CLIENT] 연결 오류 발생: " + e.getMessage());
		} finally {
			try {
				din.close();
			} catch (Exception e) {
				System.out.println("[CLIENT] 리소스 해제 중 오류 발생: " + e.getMessage());
			}
		}
	}
}
