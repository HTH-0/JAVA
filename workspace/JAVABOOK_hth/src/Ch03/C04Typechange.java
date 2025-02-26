package Ch03;

public class C04Typechange {

	public static void main(String[] args) {


		// 정수 연산식(int 보다 작은 변수 자료형(short, char, byte))
		// int로 자동 형변환
		
//		byte x = 10;
//		byte y = 20;
//		byte result1 = x + y;	//	byte result1 = (byte)(x + y);
//		int result2 = x + y;
//		System.out.println(result1);
//		
		
		// 정수 연산식(int 보다 큰 변수 자료형(long))
		// 큰 타입으로 자동형변환
//		
//		byte var1 = 10;
//		int var2 = 100;
//		long var3 = 1000L;
//		int result = (int)(var1 + var2 + var3);
//		
//		long result2 = var1 + var2 + var3;
//		System.out.println(result2);
		
		
		// 실수 연산식
		// 큰 타입으로 자동형변환
		
		int intvar = 10;
		float flvar = 3.3F;
		double dbvar = 5.5;
		int result3 = (int)(intvar + flvar + dbvar);
		double result4 = intvar + flvar + dbvar;
		System.out.println(result3);
		
		
		
	}

}
