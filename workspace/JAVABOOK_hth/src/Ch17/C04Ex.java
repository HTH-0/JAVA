package Ch17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;


public class C04Ex {
	public static void main(String[] args) {
		
		// 1) 1 ~ 45 까지 숫자 중 6개를 랜덤으로 받아 (Random 클래스를 이용) set에 저장/ 출력
		
		// 2) [추가] 저장된 set의 오름차순 정렬을 해보세요
		// (스트림을 사용)
		Set<Integer> Lotto = new HashSet<>();
		
		Random random = new Random();
		
		while(Lotto.size() < 6){
			int RandomLottoNum = random.nextInt(45) + 1;
			Lotto.add(RandomLottoNum);
		}
		
		System.out.println(Lotto);
		
		for(int i = 0; i<Lotto.size(); i++) {
			
		}
		
		// Stream을 이용한 오름차순
		// list 스트림값을 새로 받은 뒤 출력
		List<Integer> LottoAsc = Lotto.stream().sorted().collect(Collectors.toList());
		
		System.out.println(LottoAsc);
		
		// 두번째 오름차순 방법
		
		List<Integer> Lottolist = new ArrayList<>(Lotto);
		Collections.sort(Lottolist);
		
		System.out.println(Lottolist);
		
	}
}
