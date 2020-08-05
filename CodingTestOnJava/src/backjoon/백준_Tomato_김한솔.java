package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {

	private static int N, M;
	private static int[][] box;
	private static int day;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static Queue<Integer> xQueue;
	private static Queue<Integer> yQueue;
	private static int curCnt = 0, nextCnt = 0;
	private static boolean isAll = true;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer size = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(size.nextToken());
		N = Integer.parseInt(size.nextToken());
		
		box = new int[N][M]; // N행, M열의 박스배열 생성
		
		xQueue = new LinkedList<>();
		yQueue = new LinkedList<>();
		
		// 토마토 상태 입력
		for(int i=0; i<N; i++) {
			StringTokenizer tomatoState = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(tomatoState.nextToken());
			}
		}
				
		// 토마토 상태 입력
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 1) { // 토마토인 경우 탐색 시작
					xQueue.add(i);
					yQueue.add(j);
					curCnt++;
				}
			}
		}
		
		bfs();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 0) {
					isAll = false;
					break;
				}
			}
		}
		
		if(isAll) // 다 익은 경우 -> 날짜 출력
			System.out.println(day);
		else System.out.println(-1);
	}

	/* bfs 탐색 */
	private static void bfs() {
		
		while(!xQueue.isEmpty()) {
			
			if(curCnt == 0) { // 해당 일의 토마토가 할일을 다 한 경우
				curCnt = nextCnt;
				nextCnt = 0;
				day++;
			}
			
			int x = xQueue.poll();
			int y = yQueue.poll();
			curCnt--;
			
			for(int i=0; i<4; i++) {
				int rx = x+dx[i];
				int ry = y+dy[i];
				
				if(isInBox(rx, ry)) { // box영역 내부에 존재하는 경우
					if(box[rx][ry] == 0) { // 아직 익지 않은 토마토인 경우
						box[rx][ry] = 1;
						xQueue.add(rx);
						yQueue.add(ry);
						nextCnt++;
					}
				}
			}
			
		}
	}

	private static boolean isInBox(int rx, int ry) {
		return (rx>=0 && ry>=0 && rx<N && ry<M) ? true : false;
	}
}
