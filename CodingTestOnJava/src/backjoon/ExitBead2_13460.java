/**
 * Backjoon - 13460. 구슬 탈출 2
 * ExitBead2_13460.java
 * @date 2020-10-04
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.xml.ws.Holder;

class Board {
	int[] redBall = new int[2];
	int[] blueBall = new int[2];
	char[][] map;
	int time = 0;
	
	public Board(char[][] map, int[] redBall, int[] blueBall) {
		this.redBall = redBall;
		this.blueBall = blueBall;
		
		this.map = new char[map.length][];
		for(int i=0; i<map.length; i++) {
			this.map[i] = map[i].clone();
		}
	}
}

public class ExitBead2_13460 {

	static int N, M;
	static char[][] map;
	static int blueX, blueY, redX, redY, answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = data.charAt(j);
				if(map[i][j] == 'R') {
					redX = i;
					redY = j;
				}
				if(map[i][j] == 'B') {
					blueX = i;
					blueY = j;
				}
			}
		}
		
		answer = bfs();
		
		System.out.println(answer);
	}

	private static int bfs() {
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		Queue<Board> boards = new LinkedList<>();
		boards.add(new Board(map, new int[] {redX, redY}, new int[] {blueX, blueY})); // 빨간공의 위치, 횟수
		
		while(!boards.isEmpty()) {
			Board board = boards.poll();
			
			int time = board.time;
			
			// board에서 빨간 공 기준으로 벽이 아닌 경우 이동
			for(int i=0; i<4; i++) {
				int nx = board.redBall[0] + dx[i];
				int ny = board.redBall[1] + dy[i];
				
				// 가는 방향이 벽이면 패스
				if(map[nx][ny] == '#') continue;
				
				blueX = board.blueBall[0];
				blueY = board.blueBall[1];
				redX = board.redBall[0];
				redY = board.redBall[1];
				
				// 만약 바로 옆에 파란 공인 경우 --> 파란 공부터 진행
				if(board.map[nx][ny] == 'B') {
					if(map[nx+dx[i]][ny+dy[i]] == '#') continue; // 파란 공의 진행방향에  벽이 있으면 패스					
					
					// 파란 공부터 진행
					while(map[blueX+dx[i]][blueY+dy[i]] != '#') {
						blueX += dx[i];
						blueY += dy[i];
						if(map[blueX][blueY] == 'O') {
							return -1;
						}
					}
					
					// 빨간 공 진행
					while(map[redX+dx[i]][redY+dy[i]] != '#') {
						redX += dx[i];
						redY += dy[i];
						if(map[redX][redY] == 'O') {
							return time+1;
						}
					}
					
				} else {
					
					boolean success = false;
					// 빨간 공 진행
					while(map[redX+dx[i]][redY+dy[i]] != '#') {
						redX += dx[i];
						redY += dy[i];
						if(map[redX][redY] == 'O') {
							success = true;
						}
					}
					// 파란 공부터 진행
					while(map[blueX+dx[i]][blueY+dy[i]] != '#') {
						blueX += dx[i];
						blueX += dy[i];
						if(map[blueX][blueY] == 'O') {
							return -1;
						}
					}
					
					if(success) {
						return time+1;
					}
				}
				
				board.map[board.blueBall[0]][board.blueBall[1]] = '.';
				board.map[board.redBall[0]][board.redBall[1]] = '.';
				board.map[redX][redY] = 'R';
				board.map[blueX][blueY] = 'B';
				board.time = time+1;
				
				boards.add(board);
				
			}
			
		}
		
		return -1;
	}

}
