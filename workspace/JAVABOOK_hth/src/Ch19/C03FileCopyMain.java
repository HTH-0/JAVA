package Ch19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class C03FileCopyMain {

	private static String Filedir = "C:\\IOTEST\\";

	public static void main(String[] args) throws IOException { // args[0] 원본파일, args[1] 대상파일 복사위치
		for (String arg : args) {
			System.out.println(arg);
		}
		Reader fin = new FileReader(Filedir + args[0]);
		Writer fout = new FileWriter(Filedir + args[1]);

		while (true) {
			int data = fin.read();
			if (data == -1) {
				break;
			}
			fout.write((char) data);
			fout.flush();
		}
		fout.close();
		fin.close();
	}
}
