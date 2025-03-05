package Ch08;

class Rectangle {
	int x;
	int y;
	int width;
	int height;

	Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	int square() {
		return height * width;
	}

	void show() {
		System.out.printf("(%d,%d)에서 크기가 %dx%d인 사각형\n", x, y, width, height);
	}

	boolean contains(Rectangle r) {
		// 포함되려면, x, y 시작점이 더 작아야한다, width+x/ height+y 값이 더 커야한다

		if (x < r.x && y < r.y && width + x > (r.width) + r.x && height + y > r.height + r.y) {
			return true;
		}
		return false;

	}
}

public class Ex4_4Rectangle {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(2, 2, 8, 7);
		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10);

		r.show();
		System.out.println("s의 면적은 " + s.square());
		if (t.contains(r))
			System.out.println("t는 r을 포함합니다.");
		if (t.contains(s))
			System.out.println("t는 s를 포함합니다.");
//		(2,2)에서 크기가 8x7인 사각형
//		s의 면적은 36
//		t는 r을 포함합니다.
	}
}
