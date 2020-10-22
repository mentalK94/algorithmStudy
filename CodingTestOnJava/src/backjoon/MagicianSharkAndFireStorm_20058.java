/**
 * Backjoon - 20058. 마법사상어와 파이어스톰
 * MagicianSharkAndFireStorm_20058.java
 * @date 2020-10-21
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MagicianSharkAndFireStorm_20058 {

	static int[][] map;
	static int N, K, Q, sum, max, tempMax;
	static ArrayList<Integer> levelList;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		K = (int) Math.pow((double) 2, (double) N);
		sum = 0;
		max = 0;
		map = new int[K][K];
		levelList = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			levelList.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < Q; i++) {
			int level = levelList.get(i);

			if(level>=1) { level1(); }
			if(level>=2 && level<=6) {
				for(int j=2; j<=level; j++) {
					level(j);
				}
			}
			int[][] tempMap = new int[K][K];
			for(int j=0; j<K; j++) {
				tempMap[j] = map[j].clone();
			}
			
			// 얼음의 양 줄어듦
			for(int j=0; j<K; j++) {
				for(int k=0; k<K; k++) {
					
					int iceCnt = 0;
					
					for(int t=0; t<4; t++) {
						int nx = j+dx[t];
						int ny = k+dy[t];
						
						// 영역 밖이거나 얼음이 없는 경우
						if(nx<0 || nx>=K || ny<0 || ny>=K || map[j][k]<=0) continue;
						
						iceCnt++;
					}
					
					if(iceCnt<3) { // 주위 얼음의 갯수가 3개 미만인 경우 --> 얼음양 감소
						tempMap[j][k]--;
					}
					
				}
			}
			
			for(int j=0; j<K; j++) {
				map[j] = tempMap[j].clone();
			}
		}
		
		for(int i=0; i<K; i++) {
			for(int j=0; j<K; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i=0; i<K; i++) {
			for(int j=0; j<K; j++) {
				if(map[i][j]>0) {
					sum += map[i][j];
					visited = new boolean[K][K];
					tempMax = 0;
					dfs(i, j);
					if(max<tempMax) {
						max = tempMax;
					}
				}
			}
		}

		System.out.println(sum);
		System.out.println(max);
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		tempMax++;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx>=K || ny<0 || ny>=K || visited[nx][ny] || map[nx][ny]<=0) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}

	private static void level(int level) {
		int p = (int) Math.pow((double) 2, (double) level);
		for(int i=0; i<K; i+=p) {
			for(int j=0; j<K; j+=p) {
				rotate(i, j, level);
			}
		}
	}

	private static void rotate(int x, int y, int level) {
		int p = (int) Math.pow((double) 2, (double) level-1);
		int[][] temp = new int[p][p];
		
		// 임시저장
		for(int i=x; i<x+p; i++) {
			for(int j=y; j<y+p; j++) {
				temp[i-x][j-y] = map[i][j];
			}
		}
		// 좌상저장
		for(int i=x; i<x+p; i++) {
			for(int j=y; j<y+p; j++) {
				map[i][j] = map[i+p][j];
			}
		}
		// 좌하저장
		for(int i=x+p; i<x+(2*p); i++) {
			for(int j=y; j<y+p; j++) {
				map[i][j] = map[i][j+p];
			}
		}
		// 우하저장
		for(int i=x+p; i<x+(2*p); i++) {
			for(int j=y+p; j<y+(2*p); j++) {
				map[i][j] = map[i-p][j];
			}
		}
		
		// 우상저장
		for(int i=x; i<x+p; i++) {
			for(int j=y+p; j<y+(2*p); j++) {
				map[i][j] = temp[i-x][j-y-p];
			}
		}
	}

	private static void level1() {
		for(int i=0; i<K; i+=2) {
			for(int j=0; j<K; j+=2) {
				rotate1(i, j);
			}
		}
	}

	private static void rotate1(int x, int y) {
		int temp = map[x][y];
		map[x][y] = map[x+1][y];
		map[x+1][y] = map[x+1][y+1];
		map[x+1][y+1] = map[x][y+1];
		map[x][y+1] = temp;
	}

}
