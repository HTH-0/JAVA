import java.util.ArrayList;
import java.util.List;

public class Stage {
	private String stageNumber;
	private List<Enemy> enemyList;
	
	// 생성자
	public Stage(String stagenumber, List<Enemy> enemyList) {
		this.stageNumber = stagenumber;
		this.enemyList = (enemyList != null) ? new ArrayList<>(enemyList) : new ArrayList<>();
	}
	
	// Getter ( Stage 내용은 수정하지 않기 때문에 Setter 제외 )
	public String getStageNumber() {
		return stageNumber;
	}

	public List<Enemy> getEnemyList() {
		return enemyList;
	}

	@Override
    public String toString() {
        return "[%s] - 적 수: %d명".formatted(stageNumber, enemyList.size());
    }
	
}
