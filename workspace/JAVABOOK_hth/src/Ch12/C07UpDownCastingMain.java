package Ch12;

// 각 클래스에 모든 인자를 받는 생성자 코드 삽입
// toString 코드 삽입

class A {
	int a;

	A(int a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}

}

class B extends A {
	int b;

	public B(int a, int b) {
		super(a);
		this.b = b;
	}

	@Override
	public String toString() {
		return "B [b=" + b + ", a=" + a + "]";
	}

}

class C extends A {
	int c;

	public C(int a, int c) {
		super(a);
		this.c = c;
	}

	@Override
	public String toString() {
		return "C [c=" + c + ", a=" + a + "]";
	}

}

class D extends B {
	int d;

	public D(int a, int b, int d) {
		super(a, b);
		this.d = d;
	}

	@Override
	public String toString() {
		return "D [d=" + d + ", b=" + b + ", a=" + a + "]";
	}

}

class E extends B {
	int e;

	public E(int a, int b, int e) {
		super(a, b);
		this.e = e;
	}

	@Override
	public String toString() {
		return "E [e=" + e + ", b=" + b + ", a=" + a + "]";
	}

}

class F extends C {
	int f;

	public F(int a, int c, int f) {
		super(a, c);
		this.f = f;
	}

	@Override
	public String toString() {
		return "F [f=" + f + ", c=" + c + ", a=" + a + "]";
	}

}

class G extends C {
	int g;

	public G(int a, int c, int g) {
		super(a, c);
		this.g = g;
	}

	@Override
	public String toString() {
		return "G [g=" + g + ", c=" + c + ", a=" + a + "]";
	}

}

public class C07UpDownCastingMain {

	public static void UpDownCastTestFunc(A obj, int... arg) {
		// A-G 를 받아 모든 속성 출력

		obj.a = arg[0];

		if (obj instanceof D) {
			D down = (D) obj;
			down.b = arg[1];
			down.d = arg[2];
		} else if (obj instanceof E) {
			E down = (E) obj;
			down.b = arg[1];
			down.e = arg[2];
		} else if (obj instanceof F) {
			F down = (F) obj;
			down.c = arg[1];
			down.f = arg[2];
		} else if (obj instanceof G) {
			G down = (G) obj;
			down.c = arg[1];
			down.g = arg[2];
		}else if (obj instanceof B) {
			B down = (B) obj;
			down.b = arg[1];
		} else if (obj instanceof C) {
			C down = (C) obj;
			down.c = arg[1];
		}
		
		System.out.println(obj);

	}

	public static void main(String[] args) {

		A ob1 = new A(0);
		B ob2 = new B(0, 0);
		C ob3 = new C(0, 0);
		D ob4 = new D(0, 0, 0);
		E ob5 = new E(0, 0, 0);
		F ob6 = new F(0, 0, 0);
		G ob7 = new G(0, 0, 0);

		UpDownCastTestFunc(ob1, 10);					// nocasting
		UpDownCastTestFunc(ob2, 10, 20);				// Upcasting
		UpDownCastTestFunc(ob3, 30, 40); 				// Upcasting
		UpDownCastTestFunc(ob4, 50, 60, 70);			// Upcasting
		UpDownCastTestFunc(ob5, 80, 90, 100);			// Upcasting
		UpDownCastTestFunc(ob6, 110, 120, 130);			// Upcasting
		UpDownCastTestFunc(ob7, 140, 150, 160);			// Upcasting

	}
}
