/**
 * Backjoon - 19237. 어른 상어
 * AdultShark_19237.java
 * @date 2020-12-18
 * @author hansolKim
 **/

package p19000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Shark {
	int id;
	int x;
	int y;
	int dir;

	public Shark(int id, int x, int y, int dir) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

public class AdultShark_19237 {
	
	static int N, M, K; // 격자의 크기, 상어의 개수, 냄새가 없어지기까지 걸리는 시간
	static int[][][] map; // 격자정보(x, y, (상어위치, 냄새에 대한 상어번호, 냄새가 없어지기까지 걸리는 시간))
	static int[][][] dirs; // 상어번호와 방향에 따른 우선순위 방향정보 저장 
	static PriorityQueue<Shark> sharks; // [0:상어의 번호, 1:x위치, 2:y위치, 3:방향]
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N][3];
		sharks = new PriorityQueue<>(new Comparator<Shark>() {

			@Override
			public int compare(Shark o1, Shark o2) {
				return Integer.compare(o1.id, o2.id);
			}
		});
		
		int[][] tempShark = new int[M+1][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
				if(map[i][j][0] != 0) { // 해당 칸에 상어가 존재하면
					map[i][j][1] = map[i][j][0];
					map[i][j][2] = K; // 냄새 시간 세팅
					tempShark[map[i][j][0]][0] = i;
					tempShark[map[i][j][0]][1] = j;
				}
			}
		}
		
		// 상어의 초기방향 저장
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			sharks.add(new Shark(i, tempShark[i][0], tempShark[i][1], Integer.parseInt(st.nextToken())));
		}
		
		dirs = new int[M+1][5][4];
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<4; k++) {
					int dir = Integer.parseInt(st.nextToken());
					dirs[i][j][k] = dir;
				}
			}
		}
		
		int time = 0;
		
		while(true) {
			if(sharks.size() == 1) { break; } // 1번 상어만 남은 경우
			
			time++; // 시간 증가
			if(time > 1000) { time = -1; break; } // 1000초가 넘은 경우
			
			PriorityQueue<Shark> temp = new PriorityQueue<>(new Comparator<Shark>() {

				@Override
				public int compare(Shark o1, Shark o2) {
					return Integer.compare(o1.id, o2.id);
				}
			});
			
			// 1. 상어의 이동 구현
			while(!sharks.isEmpty()) {
				Shark curShark = sharks.poll(); // 현재 상어
				int curId = curShark.id; // 현재 상어 번호
				int curX = curShark.x; // 현재 상어 x위치
				int curY = curShark.y; // 현재 상어 y위치
				int curDir = curShark.dir; // 현재 상어 방향
				
				boolean isMove = false;
				// 1-1. 아무냄새가 없는 곳으로 이동
				for(int i=0; i<4; i++) {
					// System.out.println(curId + " " + curDir);
					int nx = curX + dx[dirs[curId][curDir][i]];
					int ny = curY + dy[dirs[curId][curDir][i]];
					
					// 격자 범위를 벗어나는지 또는 상어냄새가 있는지 확인
					if(nx<0 || nx>=N || ny<0 || ny>=N || map[nx][ny][1] != 0) continue;
					
					isMove = true; // 이동완료
					map[curX][curY][0] = 0; // 현재위치 초기화
					// 상어냄새가 존재하지 않는 공간인 경우 ---> 현재위치에 상어가 있는지 확인
					if(map[nx][ny][0] == 0) {
						map[nx][ny][0] = curId;
						temp.add(new Shark(curId, nx, ny, dirs[curId][curDir][i]));
					}
					break;
				}
				
				// 1-2. 자신의 냄새가 있는 곳으로 이동
				if(!isMove) {
					for(int i=0; i<4; i++) {
						int nx = curX + dx[dirs[curId][curDir][i]];
						int ny = curY + dy[dirs[curId][curDir][i]];
						
						// 격자 범위를 벗어나는지 또는 상어냄새가 있는지 확인
						if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
						
						if(map[nx][ny][1] != curId) continue; // 자신의 냄새가 아닌 경우
						
						isMove = true; // 이동완료
						map[curX][curY][0] = 0; // 현재위치 초기화
						// 상어냄새가 존재하지 않는 공간인 경우 ---> 현재위치에 상어가 있는지 확인
						if(map[nx][ny][0] == 0) {
							map[nx][ny][0] = curId;
							temp.add(new Shark(curId, nx, ny, dirs[curId][curDir][i]));
						}
						break;
					}
				}
				
				// 1-3. 아무곳도 이동못한 경우 --> 우선순위대로 이동
				if(!isMove) {
					for(int i=0; i<4; i++) {
						int nx = curX + dx[dirs[curId][curDir][i]];
						int ny = curY + dy[dirs[curId][curDir][i]];
						
						// 격자 범위를 벗어나는지 또는 상어냄새가 있는지 확인
						if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
						
						// 상어냄새가 존재하지 않는 공간인 경우 ---> 현재위치에 상어가 있는지 확인
						map[curX][curY][0] = 0; // 현재위치 초기화
						if(map[nx][ny][0] == 0) {
							map[nx][ny][0] = curId;
							temp.add(new Shark(curId, nx, ny, dirs[curId][curDir][i]));
						}
						break;
					}
				}
			}
			
			// 2. 현재 냄새정보 -1갱신
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j][2] == 0) continue; // 냄새가 없는 경우
					if(--map[i][j][2] == 0) { map[i][j][1] = 0;} // 냄새가 없어진 경우
				}
			}
			
			// 3. temp배열에 존재하는 상어들의 위치에 따른 냄새정보 저장
			while(!temp.isEmpty()) {
				Shark s = temp.poll();
				// 3-1. 상어냄새 정보 저장 
				map[s.x][s.y][1] = s.id;
				map[s.x][s.y][2] = K;
				
				sharks.add(s);
			}
		}
		
		System.out.println(time);
		br.close();
	}	
}