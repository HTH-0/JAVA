public class Battle {
	
	public void battle(Player player, Enemy enemy, BattleChoice choice) {
		switch(choice) {
		case ATTACK:
			attack(player, enemy);
			break;
		case DEFEND:
			defend(player);
			break;
		case MAGIC:
			magic();
			break;
		}
	}
	public void attacked(Enemy enemy, Player player) {
		enemyAttack(enemy, player);
	}
	
	private void attack(Player player, Enemy enemy) {
		// 적 hp = 적 hp - (플레이어 power - 적 defense);
		int damage = player.getPower() - enemy.getDefense();
		enemy.setHp(enemy.getHp() - damage);
		System.out.printf("%s에게 %d의 피해를 입혔습니다!\n 적 체력 %d", enemy.getName(), damage, enemy.getHp());
	}
	
	private void enemyAttack(Enemy enemy, Player player) {
		int enemyDamage = enemy.getPower() - player.getNewDefense();
		player.setHp(player.getHp() - enemyDamage);
		System.out.printf("\n%s에게 %d의 피해를 입었습니다!\n 나의 체력 %d", enemy.getName(), enemyDamage, player.getHp());
	}
	
	private void defend(Player player) {
		// defense += 상승량;
		player.setNewDefense(player.getDefense() * 2);
		System.out.println("플레이어가 방어 태세를 취합니다. 방어력 2배!");
	}
	private void magic() {
		System.out.println("아직 마법 기능은 구현되지 않았습니다.");
	}
}

