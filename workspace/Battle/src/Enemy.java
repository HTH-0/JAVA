public class Enemy {

	// 기본 스탯
	private String name;
	private int hp;
	private int defense;
	private int power;
	
	public Enemy(String name, int hp, int defense, int power) {
		this.name = name;
		this.hp = hp;
		this.defense = defense;
		this.power = power;
	}
	
	// Enemy 들의 템플릿들. 각 스테이지에 원하는만큼 복사해서 사용한다.
	public static final Enemy enemyA = new Enemy("enemyA", 100, 10, 10);
	public static final Enemy enemyB = new Enemy("enemyB", 200, 20, 20);
	public static final Enemy enemyC = new Enemy("enemyC", 500, 30, 30);
	public static final Enemy enemyD = new Enemy("enemyD", 1000, 40, 40);
	
	// 템플릿(상수값)을 복사해서 적용 할 복제 메서드
	public Enemy copy() {
		return new Enemy(name, hp, defense, power);
	}
}
