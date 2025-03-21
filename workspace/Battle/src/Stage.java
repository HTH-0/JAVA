import java.util.ArrayList;
import java.util.List;

public class Stage {
	String stagenumber;
	private List<Enemy> enemylist = new ArrayList<>();
	
	public Stage(String stagenumber, List<Enemy> enemylist) {
		this.stagenumber = stagenumber;
		
		initEnemy();
	}
	
	public void initEnemy() {
		switch(stagenumber) {
		case "Stage 1" :
			
			break;
		case "Stage 2" :
			
			break;
			
		case "Stage 4" :
			
			break;
			
		case "Stage 5" :
			
			break;
			
		case "Stage 6" :
			
			break;
			
		default : 
			
			
		}
	}
	
}
