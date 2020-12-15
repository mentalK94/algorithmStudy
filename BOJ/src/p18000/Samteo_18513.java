/**
 * Backjoon - 18513. 샘터
 * Samteo_18513.java
 * @date 2020-09-05 (시도)
 * @date 2020-12-10 (해결)
 * @author hansolKim
 **/

package p18000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Samteo_18513 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long answer = 0;
		boolean[][][] build = new boolean[2][10011][10001]; // 음수와 양수구분, 1억을 쪼개서 사용 10000*10000
		
		int N = Integer.parseInt(st.nextToken()); // 치킨 집의 수 입력
		int K = Integer.parseInt(st.nextToken()); // 집의 수 입력
		
		st = new StringTokenizer(br.readLine()); // 치킨집의 위치 라인 입력 및 토큰생성
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			int chicken = Integer.parseInt(st.nextToken());
			
			q.add(new int[] {chicken+1, 1, 1}); // 오른쪽 방향
			q.add(new int[] {chicken-1, 0, 1}); // 왼쪽 방향
			
			if(chicken >= 0) { // 양수인 경우(0포함)
				int second = chicken/10000; // 두 번째 인덱스 
				int third = chicken%10000; // 세 번째 인덱스
				build[0][second][third] = true; // 해당위치에 치킨집이 차려졌음을 표기(더 이상 이 위치 사용 불가)
			} else { // 음수인 경우
				chicken = Math.abs(chicken);
				int second = chicken/10000; // 두 번째 인덱스 
				int third = chicken%10000; // 세 번째 인덱스 
				build[1][second][third] = true; // 해당위치에 치킨집이 차려졌음을 표기(더 이상 이 위치 사용 불가)
			}
			
		}
		
		while(K>0) {
			
			int[] info = q.poll();
			int x = info[0]; // 위치
			int dir = info[1]; // 방향
			int dist = info[2]; // 거리	
			
			int firstIdx = x>=0 ? 0:1;
			
			x = Math.abs(x);
			int secondIdx = x/10000;
			int thirdIdx = x%10000;

			if(build[firstIdx][secondIdx][thirdIdx]) { continue; }
			
			build[firstIdx][secondIdx][thirdIdx] = true;
			answer += dist;

			x = firstIdx == 0 ? x : -x;
			
			if(dir == 1) { q.add(new int[] {x+1, 1, dist+1}); }
			if(dir == 0) { q.add(new int[] {x-1, 0, dist+1}); }
			K--;
			
		}
		
		System.out.println(answer); // 결과 출력
	}

}
