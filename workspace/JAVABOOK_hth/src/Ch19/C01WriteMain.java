package Ch19;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class C01WriteMain {
	public static void main(String[] args) throws IOException{
		
//		Writer fout = new FileWriter("C:\\IOTEST\\test1.txt",false); // 덮어쓰기
		Writer fout = new FileWriter("C:\\IOTEST\\test1.txt",true); // 덮어쓰기
		fout.write("test5\n");
		fout.write("test6\n");
		fout.write("test7\n");
		fout.write("test8\n");
		
		
		
		
		fout.flush();
		fout.close();
		
	}
}
