/**
 * Samsung SW Expert - 10888. 음식 배달
 * FoodDelivery_10888.java
 * @date 2020-10-19
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FoodDelivery_10888 {
	
	static int answer, N, R;
	static int[][] map;
	static ArrayList<int[]> foodList;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			R = 0;
			answer = Integer.MAX_VALUE;
			foodList = new ArrayList<>();
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]>1) { // 음식점인 경우
						foodList.add(new int[] {i, j, map[i][j]});
						map[i][j] = 0;
						R++;
					}
				}
			}
			
			visited = new boolean[R];
			
			subSet(0);		
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void subSet(int cnt) {
		if(cnt == R) {
			
			int c = 0;
			for(int i=0; i<R; i++) {
				if(!visited[i]) c++;
			}
			
			if(c == R) return;
			int tempAnswer = 0;
			ArrayList<int[]> foodXY = new ArrayList<>();
			
			for(int i=0; i<R; i++) {
				if(visited[i]) {
					int[] food = foodList.get(i);
					foodXY.add(new int[] {food[0], food[1]});
					tempAnswer += food[2];
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1) {
						int dist = Integer.MAX_VALUE;
						for(int k=0; k<foodXY.size(); k++) {
							int foodDist = getDist(i, j, foodXY.get(k)[0], foodXY.get(k)[1]);
							if(foodDist < dist) {
								dist = foodDist;
							}
						}
						
						tempAnswer += dist;
					}
				}
			}
			
			if(tempAnswer < answer) {
				answer = tempAnswer;
			}
			return;
		}
		
		visited[cnt] = false;
		subSet(cnt+1);
		visited[cnt] = true;
		subSet(cnt+1);
	}

	private static int getDist(int x, int y, int targetX, int targetY) {
		return Math.abs(x-targetX) + Math.abs(y-targetY);
	}

}
