/**
 * Samsung SW Expert - 1247. 최적 경로
 * OptimumRoute_1247.java
 * @date 2020-08-27
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Address {
	int x;
	int y;
	
	public Address(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}

public class OptimumRoute_1247 {

	private static int N;
	private static List<Address> clients;
	private static Address company, home;
	private static int answer = Integer.MAX_VALUE;
	private static boolean[] selected;
	private static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			sb.append("#").append(test_case).append(" ");
			
			N = Integer.parseInt(br.readLine()); // 고객의 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			selected = new boolean[N];
			numbers = new int[N];
			
			company = new Address(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 회사 위치
			home = new Address(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 집 위치
			
			clients = new ArrayList<>();
			for(int i=0; i<N; i++) {
				clients.add(new Address(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))); // 고객들의 위치리스트
			}
			
			permutation(0);
			
			 sb.append(answer).append("\n");
			 answer = Integer.MAX_VALUE;
		}
		
		System.out.println(sb);

	}

	private static void permutation(int cnt) {
		if(cnt == N) { // 여기서 모든 거리값 계산
			int tempRoute = 0;
			
			// 현재위치를 회사 위치로 셋팅
			int curX = company.getX(); 
			int curY = company.getY();	
			
			for(int i=0; i<N; i++) {
				// 1. 현재 위치와 고객 위치의 거리계산
				int clientX = clients.get(numbers[i]).getX();
				int clientY = clients.get(numbers[i]).getY();
				tempRoute+=getDist(curX, curY, clientX, clientY);
				
				// 2. 현재 위치 갱신
				curX = clientX;
				curY = clientY;
			}
			
			// 3. 집위치와 계산
			tempRoute += getDist(curX, curY, home.getX(), home.getY());
			
			answer = Math.min(answer, tempRoute);
		}
		
		for(int i=0; i<N; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			numbers[cnt] = i;
			permutation(cnt+1);
			selected[i] = false;
		}
	}
	
	/* 두 좌표 거리계산 */
	private static int getDist(int curX, int curY, int targetX, int targetY) {
		return Math.abs(curX-targetX) + Math.abs(curY-targetY);
	}
}
