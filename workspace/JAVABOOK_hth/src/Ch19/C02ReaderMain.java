package Ch19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class C02ReaderMain {
	public static void main(String[] args) throws IOException{
		
		Reader fin = new FileReader("C:\\IOTEST\\test1.txt");
		int data = 0;
		StringBuffer buffer = new StringBuffer();
		while((data = fin.read()) != -1) {
			buffer.append((char)data);
		}
		System.out.println(buffer);
		
		fin.close();
	}
}
