import java.util.ArrayList;
import java.util.List;

public class StageInit {
	
	int stageNum;
	
	private List<Stage> stages;
	
	public StageInit() {
		// 1부터 시작한다.
		stageNum = 1;
		stages = new ArrayList<>();
		
		
        List<Enemy> s1 = new ArrayList<>();
        s1.add(Enemy.enemyA.copy());
        stages.add(new Stage("Stage 1", s1));

        List<Enemy> s2 = new ArrayList<>();
        s2.add(Enemy.enemyB.copy());
        stages.add(new Stage("Stage 2", s2));

        List<Enemy> s3 = new ArrayList<>();
        s3.add(Enemy.enemyC.copy());
        stages.add(new Stage("Stage 3", s3));

        List<Enemy> s4 = new ArrayList<>();
        s4.add(Enemy.enemyD.copy());
        stages.add(new Stage("Stage 4", s4));

        List<Enemy> s5 = new ArrayList<>();
        s5.add(Enemy.enemyE.copy());
        stages.add(new Stage("Stage 5", s5));

        List<Enemy> s6 = new ArrayList<>();
        s6.add(Enemy.enemyF.copy());
        stages.add(new Stage("Stage 6", s6));
        
	}
	
	// 스테이지 진행을 위한 메서드
	public Stage getCurrentStage() {
		// 스테이지 끝이 아니라면
		if(stageNum <= stages.size()) {
			return stages.get(stageNum -1);
		}else {			
		return null;
		}
	}
	
	// 다음 스테이지로 가기 위한 메서드
	public boolean nextStage() {
		if(stageNum < stages.size()) {
			stageNum++;
			return true;
		}
		return false;
	}
	
	
	
	
}
