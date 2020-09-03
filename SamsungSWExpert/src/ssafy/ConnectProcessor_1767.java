/**
 * Samsung SW Expert - 1767. 프로세서 연결하기
 * ConnectProcessor_1767.java
 * @date 2020-09-03
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ConnectProcessor_1767 {

	private static int[][] map;
	private static int N, max, min, totalCnt;
	private static ArrayList<int[]> list;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			
			list = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if((i==0 || j==0 || i==N-1 || j==N-1) && map[i][j] == 1) continue;
					// 가장자리에 있지 않은 코어리스트 추가 
					if(map[i][j] == 1) {
						list.add(new int[] {i, j});
						totalCnt++;
					}
				}
			}
			go(0, 0, 0);
			sb.append(min).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void go(int index, int coreCnt, int lineCnt) { // index: 처리할 코어의 index, coreCnt:직전까지 포함된 코어 수, lineCnt : 연결된 전선의 길이
		
		// 현재까지 연결된 코어 수 + 앞으로 처리해야할 남은 코어 수 : 기대할 수 있는 최대 코어 수
		// 최대코어 수가 임시해 작다면
		if(coreCnt+totalCnt-index < max) return; 
		
		if(index == totalCnt) {
			if(max < coreCnt) {
				max = coreCnt;
				min = lineCnt;
			} else if(max == coreCnt) {
				if(min > lineCnt) {
					min = lineCnt;
				}
			}
			return;
		}
		
		int[] cur = list.get(index);
		int x = cur[0];
		int y = cur[1];
		// 해당 코어 선택
		// 4방향의 직선으로 전선 놓아보는 시도
		for(int d=0; d<4; d++) {
			// 해당 방향으로 전선 놓는게 가능한지 체크
			if(isAvailable(x, y, d)) {
				// 가능하다면 전선 놓기 : 판에 2로 셋팅
				int len = setStatus(x, y, d, 2);
				// 다음코어로 넘어가기
				go(index+1, coreCnt+1, lineCnt+len);
				// 놓았던 전선 지우기(되돌리기)
				setStatus(x, y, d, 0);
			}
		}
		
		// 해당 코어 비선택
		// 아무런 전선도 놓지 않고 다음 코어로 넘어가기
		go(index+1, coreCnt, lineCnt);
	}
	
	// 현 코엉의 위치에서 해당 방향으로 전선을 놓는 게 가능하지 체크
	private static boolean isAvailable(int x, int y, int d) {
		int nx = x, ny = y;
		while(true) {
			nx += dx[d];
			ny += dy[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N) { break;	}
			
			// 1: 코어, 2: 전선
			if(map[nx][ny] >= 1) { return false; }
		}
		return true;
	}
	
	// 현 코어의 위치에서 해당 방향으로 전선을 놓거나(s=2) 지우는(s=0) 셋팅
	private static int setStatus(int x, int y, int d, int s) {
		int nx = x, ny = y;
		int cnt=0;
		while(true) {
			nx += dx[d];
			ny += dy[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N) { break;	}
			map[nx][ny] = s;
			++cnt;
		}
		return cnt;
	}

}
