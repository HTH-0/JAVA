package Ch19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class C07FileCopyMain {
	public static void main(String[] args) throws Exception {

		InputStream in = new FileInputStream("C:\\IOTEST\\dummy.exe");
		OutputStream out = new FileOutputStream("C:\\IOTEST\\COPY_dummy.exe");

		// 01 버퍼 미사용
//		while (true) {
//
//			int data = in.read();
//			if (data == -1) {
//				break;
//			}
//			out.write((byte) data);
//
//			out.flush();
//		}
//
//		in.close();
//		out.close();

		// 02 버퍼 사용
		
		
		byte [] buff = new byte[4096];
		
		while (true) {

			int data = in.read(buff);
			if (data == -1) {
				break;
			}	
			out.write(buff, 0, data);
			out.flush();
		}

		in.close();
		out.close();

	}
}
