package BubbleGame;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 백그라운드 서비스 (독립적인 스레드로 돌려야 한다)
public class BackgroundBubbleService implements Runnable {

	private static final String TAG = "BackgroundBubbleService : ";

	private Bubble bubble;
	private BufferedImage image;

	public BackgroundBubbleService(Bubble bubble) {
		this.bubble = bubble;

		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// 멈추지 않고 while을 돌며 색상 확인
		while (true) {
			try {

				Color leftColor = new Color(image.getRGB(bubble.getX() - 10, bubble.getY() + 25));
				Color rightColor = new Color(image.getRGB(bubble.getX() + 50 + 10, bubble.getY() + 25));

				int topColor = image.getRGB(bubble.getX() + 25, bubble.getY() - 5);



				if (topColor == -65536) { 
					bubble.setUp(false); 
					bubble.setTopWallCrash(true);
					bubble.pop();
				}

				if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) { 

					bubble.setLeftWallCrash(true);
					bubble.setLeft(false);
				} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {

					bubble.setRightWallCrash(true);
					bubble.setRight(false);
				}

				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
