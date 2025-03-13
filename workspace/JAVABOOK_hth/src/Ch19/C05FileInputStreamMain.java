package Ch19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class C05FileInputStreamMain {
	public static void main(String[] args) throws IOException {

		InputStream fin = new FileInputStream("C:\\IOTEST\\data.xlsx");

		StringBuffer sb = new StringBuffer();

		// fin.read() 확인
//		long sTime = System.currentTimeMillis();
//
//		while (true) {
//			int data = fin.read();
//			if (data == -1) {
//				break;
//			}
//		}
//		long eTime = System.currentTimeMillis();
//		System.out.println("소요 시간 : " + (eTime - sTime) + "ms");
		
		
		// read([])
		
		byte [] buf = new byte[1024];
		
		long sTime = System.currentTimeMillis();

		while (true) {
			int data = fin.read(buf);
			if (data == -1) {
				break;
			}
		}
		long eTime = System.currentTimeMillis();
		System.out.println("소요 시간 : " + (eTime - sTime) + "ms");

		
		
		
		fin.close();
	}
}
