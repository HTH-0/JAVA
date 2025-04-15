import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Player player = new Player(100 ,30, 10, 20);
		
		StageInit stageInit = new StageInit();
		
		Battle battle = new Battle();
	
		System.out.println("게임을 시작합니다!");

        while (true) {
            Stage currentStage = stageInit.getCurrentStage();
            if (currentStage == null) {
                System.out.println("모든 스테이지를 클리어! 게임 종료");
                break;
            }

            System.out.println("\n▶ " + currentStage);
            for (Enemy enemy : currentStage.getEnemyList()) {
                System.out.println("전투 시작! 상대: " + enemy);

                // 적이 죽을 때까지 반복 전투
                while (enemy.getHp() > 0 || player.getHp() > 0) {
                    System.out.print("행동을 선택하세요 (1.공격 2.방어 3.마법) >> ");
                    int choice = sc.nextInt();
                    BattleChoice battleChoice = switch (choice) {
                        case 1 -> BattleChoice.ATTACK;
                        case 2 -> BattleChoice.DEFEND;
                        case 3 -> BattleChoice.MAGIC;
                        default -> BattleChoice.ATTACK;
                    };
                    
                    battle.battle(player, enemy, battleChoice);
                    battle.attacked(enemy, player);
                    System.out.println();
                }

                System.out.println("적을 처치했습니다!\n");
            }

            boolean next = stageInit.nextStage();
            if (!next) {
                System.out.println("마지막 스테이지까지 완료했습니다.");
                break;
            }
        }

        System.out.println("게임을 종료합니다.");
        sc.close();
	}
}
