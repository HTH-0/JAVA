package Ch19;

import java.io.BufferedInputStream; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class C10JsoupMain {
	public static void main(String[] args) throws IOException, URISyntaxException {
		// URL연결
		Connection conn = Jsoup.connect("https://www.op.gg/champions");

		Document doc = conn.get();

//		System.out.println(doc);

		Elements elements = doc.getElementsByTag("img");
//		System.out.println(elements);

		for (Element el : elements) {
			
		
			try {
				System.out.println(el);
//				String img_url = el.getElementsByAttribute("src").attr("src");
				String img_url = el.attr("src");
				System.out.println(img_url);

				URL url = (new URI(img_url)).toURL();
				InputStream in = url.openStream();
				BufferedInputStream buffIn = new BufferedInputStream(in);

				OutputStream out = null;

				if (img_url.contains(".png")) {
					out = new FileOutputStream("C:\\IOTEST\\" + UUID.randomUUID() + ".png");
				} else if (img_url.contains(".svg")) {
					out = new FileOutputStream("C:\\IOTEST\\" + UUID.randomUUID() + ".svg");
				} else if (img_url.contains(".webp")) {
					out = new FileOutputStream("C:\\IOTEST\\" + UUID.randomUUID() + ".webp");
				} else {
					out = new FileOutputStream("C:\\IOTEST\\" + UUID.randomUUID() + ".jpg");
				}
					while (true) {
						int data = buffIn.read();
						if (data == -1) {
							break;
						}
						out.write((byte) data);
						out.flush();
					}
				
				out.close();
				buffIn.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
