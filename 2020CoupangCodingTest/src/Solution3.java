import java.util.HashMap;

public class Solution3 {

	public static void main(String[] args) {
		Solution3 s3 = new Solution3();
		int k = 2;
		int[] score = {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100};
		s3.solution(k, score);
	}
	
	public int solution(int k, int[] score) {
		int answer = 0;
		int delete = 0;
		
		int[] diff = new int[score.length]; // 점수 차 배열
		HashMap<Integer, Integer> map = new HashMap<>();
		
		diff[0] = 0;
		map.put(0, 1);
		for(int i=1; i<score.length; i++) {
			int dist = score[i-1] - score[i];
			if(map.containsKey(dist)) { // 이전에 차이가 있는 경우
				map.put(dist, map.get(dist)+1);
			} else {
				map.put(dist, 1);
			}
			diff[i] = dist;
		}
		
		boolean[] checked = new boolean[diff.length];
		if(map.get(diff[0]) >= k) { 
			checked[0] = true;
		}
		for(int i=1; i<diff.length; i++) {
			if(map.get(diff[i]) >= k) {
				checked[i-1] = true;
				checked[i] = true;
			}
		}
		
		for(int i=0; i<checked.length; i++) {
			if(checked[i]) {
				delete++;
			}
		}
		
		if(delete == 0) {
			answer = 0;
		} else {
			answer = score.length-delete;
		}
		
		System.out.println(answer);
		return answer;
	}

}
