package Ch08;

class Song{
	String title;
	String artist;
	int year;
	String country;
	
	
	Song(String title, String artist, int year, String country){
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}
	
	void show() {
		System.out.printf("%d년 %s국적의 %s가 부른 %s", year, country, artist, title);
	}
}



public class Ex4_3Song {
	public static void main(String[] args) {
		
		// main() 메소드에서는 1978년, 스웨덴 국적의 ABBA가 부른 "Dancing Queen"을
		// song 객체로 생성하고 show()를 이용하여 노래의 정보를 다음과 같이 출력하라.
		// 1978년 스웨덴국적의 ABBA가 부른 Dancing Queen
		
		Song song = new Song("Dancing Queen","ABBA", 1978, "스웨덴");
		
		song.show();
		
	}
}
