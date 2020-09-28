import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
	public static void main(String[] args) {
		
	}
	
	
	public int solution(int n, int[][] edges) {
		int answer = 0;
		
		int[][] map = new int[edges.length][1];

		for(int i=0; i<edges.length; i++) {
			map[edges[i][0]][0]++;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		
		// int idx = 0;
		for(int i=0; i<list.size(); i++) {
			
			// 각 노드의 모든 자식의 개수 계산
			
			
			
			
		}
		
		
		
		
		return answer;
	}

}

