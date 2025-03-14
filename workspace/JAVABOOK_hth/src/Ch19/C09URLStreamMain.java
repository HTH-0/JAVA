package Ch19;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URL;

public class C09URLStreamMain {
	public static void main(String[] args) throws Exception {
		
		URL url = (new URI("https://contents.premium.naver.com/byteplus/byte/contents/250314043729973vt")).toURL();
		
		InputStream in = url.openStream();		
		
		// 보조 스트림 추가(ch20)
		BufferedInputStream buffIn = new BufferedInputStream(in);
		Reader rin = new InputStreamReader(buffIn);
		
		Writer out = new FileWriter("C:\\IOTEST\\index.html");
		
		int data;
		while((data = rin.read()) != -1) {
			System.out.print((char)data);
			out.write((char)data);
			out.flush();
		}
		
		rin.close();
		buffIn.close();
		in.close();
		out.close();
		
		
		
	}
}
