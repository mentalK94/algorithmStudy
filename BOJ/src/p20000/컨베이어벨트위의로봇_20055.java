/**
 * Backjoon - 20055. 컨베이어 벨트 위의 로봇
 * 컨베이어벨트위의로봇_20055.java
 * @date 2020-12-18
 * @author hansolKim
 **/

package p20000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇_20055 {

	static int N, K; // 벨트 위의 칸의 갯수, 내구도 종료 개수
	static int[] arr; // 내구도 정보
	static boolean[] used; // 로봇이 있는지 여부
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N*2];
		used = new boolean[N*2];
		
		for(int i=0; i<N*2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		int cnt = 0;
		int curIdx = 0;
		
		Queue<Integer> robots = new LinkedList<>();
		while(true) {
			
			// 1. 벨트가 한 칸 회전
			curIdx = --curIdx<0 ? N*2-1 : curIdx;
			
			// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
			// 2-1. 벨트 회전에 따른 로봇위치 변경
			int size = robots.size();
			for(int i=0; i<size; i++) {
				int cur = robots.poll();
				used[cur] = false;
				cur = --cur<0 ? N*2-1 : cur;
				used[cur] = true;
				robots.add(cur);
			}
			
			// 2-2. 로봇이 이동하려면 이동하는 칸에 로봇이 없고, 그 칸의 내구도가 1 이상 남아있어야 한다.
			for(int i=0; i<size; i++) {
				int cur = robots.poll();
				int nIdx = ++cur==N*2 ? 0 : cur;
				int downIdx = N+curIdx>=2*N ? N+curIdx-2*N : N+curIdx;
				
				if(nIdx == downIdx) { continue; } // 내려가는 위치에 있는 경우
				
				if(!used[nIdx] && arr[nIdx] > 0) { // 이동할 수 있는 경우				
					used[cur] = false;
					if(--arr[nIdx] == 0) {K--;}
					used[nIdx] = true;
					robots.add(nIdx);
				} else {
					robots.add(cur);
				}
			}
			
			// 3. 올라가는 위치에 로봇이 없다면 로봇을 하나 올린다.
			if(!used[curIdx]) {
				robots.add(curIdx);
				if(--arr[curIdx] == 0) {K--;}
			}
			
			time++;
			if(cnt == K) { break;}
		}
		
		System.out.println(time);
		br.close();
	}

}
