import java.util.ArrayList;
import java.util.HashMap;

public class Solution4 {

	public static void main(String[] args) {
		Solution4 s4 = new Solution4();
		String depar = "ULSAN";
		String hub = "SEOUL";
		String dest = "BUSAN";
		String[][] roads= {{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},
				{"DAEJEON","GWANGJU"},{"SEOUL","DAEJEON"},
				{"SEOUL","ULSAN"},{"DAEJEON","DAEGU"},
				{"GWANGJU","BUSAN"},{"DAEGU","GWANGJU"},
				{"DAEGU","BUSAN"},{"ULSAN","DAEGU"},
				{"GWANGJU","YEOSU"},{"BUSAN","YEOSU"}};
		
		String[][] roads2 = {{"SEOUL","DAEJEON"},{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},{"DAEJEON","GWANGJU"},{"SEOUL","ULSAN"},{"DAEJEON","BUSAN"},{"GWANGJU","BUSAN"}};
		
		s4.solution(depar, hub, dest, roads2);
	}
	
	static HashMap<String, ArrayList<String>> map;
	static int deparTohub = 0;
	static int hubTodest = 0;
	
	public int solution(String depar, String hub, String dest, String[][] roads) {
		int answer = 0;
		map = new HashMap<>();
		
		for(int i=0; i<roads.length; i++) {
			ArrayList<String> list = new ArrayList<>(); 
			if(map.containsKey(roads[i][0])) { // 이미 존재하는 경우
				list = map.get(roads[i][0]);
			} 
			list.add(roads[i][1]);
			map.put(roads[i][0], list);
		}
		
		dfs(depar, hub, 0);
		dfs(hub, dest, 1);
		
		answer = deparTohub%10007 * hubTodest%10007;
		System.out.println(answer);
		return answer%10007;
	}

	private void dfs(String depar, String dest, int flag) {
		
		// 현재 지점이 목적지인 경우
		if(depar.equals(dest)) {
			if(flag == 0) {
				deparTohub++;
			} else {
				hubTodest++;
			}
			return;
		}
		
		// 현재 지점에서 갈 수 있는 모든 경로 탐색
		ArrayList<String> list = map.get(depar);
		
		if(list == null) { return; }
		for(int i=0; i<list.size(); i++) {
			dfs(list.get(i), dest, flag);
		}
	}

}
