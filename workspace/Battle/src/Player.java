
public class Player {
	// 스탯
	private int hp;
	private int mana;
	private final int defense;
	private int power;

	private int newDefense;

	// 생성자
	public Player(int hp, int mana, int defense, int power) {
		super();
		this.hp = hp;
		this.mana = mana;
		this.defense = defense;
		this.newDefense = defense;
		this.power = power;
	}

	// Getter Setter
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	// final 변수에는 setter 없다.
	public int getDefense() {
		return defense;
	}

	public int getNewDefense() {
		return newDefense;
	}

	public void setNewDefense(int newDefense) {
		this.newDefense = newDefense;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
