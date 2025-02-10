package Ch08;

class TV{
	String company;
	int year;
	int size;
	
	TV(String company, int year, int size) {
		this.company = company;
		this.year = year;
		this.size = size;
	}
	
	void show() {
		System.out.printf("%s에서 만든 %d년 %d인치", company, year, size);
	}
}


public class Ex4_1Tv {
	public static void main(String[] args) {
		TV myTV = new TV("LG", 2017, 32); // LG에서 만든 2017년 32인치
		myTV.show();
	}
}
