public class Enemy {

	// 기본 스탯
	private String name;
	private int hp;
	private int defense;
	private int power;
	
	// 생성자
	
	public Enemy(String name, int hp, int defense, int power) {
		super();
		this.name = name;
		this.hp = hp;
		this.defense = defense;
		this.power = power;
	}
	
	// Getter Setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	
	// 템플릿(상수값)을 복사해서 적용 할 복제 메서드
	public Enemy copy() {
		return new Enemy(name, hp, defense, power);
	}
	
	// toString
	@Override
	public String toString() {
	    return String.format("%s (HP: %d, ATK: %d, DEF: %d)", name, hp, power, defense);
	}

	
	// Enemy 들의 템플릿들. 각 스테이지에 원하는만큼 복사해서 사용
	public static final Enemy enemyA = new Enemy("enemyA", 100, 10, 5);
	public static final Enemy enemyB = new Enemy("enemyB", 200, 20, 10);
	public static final Enemy enemyC = new Enemy("enemyC", 500, 30, 15);
	public static final Enemy enemyD = new Enemy("enemyD", 1000, 40, 20);
	public static final Enemy enemyE = new Enemy("enemyE", 1500, 50, 25);
	public static final Enemy enemyF = new Enemy("enemyF", 2000, 60, 30);
}
