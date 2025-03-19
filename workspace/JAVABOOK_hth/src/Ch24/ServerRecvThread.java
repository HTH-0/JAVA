package Ch24;

import java.io.DataInputStream;

public class ServerRecvThread implements Runnable {
	DataInputStream din;
	
	public ServerRecvThread(DataInputStream din) {
		this.din = din;

	}

	@Override
	public void run() {
		String recv;

		try {
			while(true) {
				recv = din.readUTF();
				if(recv.equals("q"))
					break;
				System.out.println("[SERVER] : " + recv);	
			}
		}catch(Exception e) {
			System.out.println("[SERVER] 연결 오류 발생: " + e.getMessage());
		}finally {
			try {			
			if(din != null) {din.close();}
			}catch(Exception e) {
				System.out.println("[SERVER] 리소스 해제 중 오류 발생: " + e.getMessage());
			}
		}
		
	}
}
