/**
 * Backjoon - 14500. 테트로미노
 * Tetromino_14500.java
 * @date 2020-10-14
 * @author hansolKim
 **/

package p14000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino_14500 {

	static int N, M, answer;
	static int[][] map;
	static int[][][] dir = {
		{{0, 1}, {0, 1}, {0, 1}}, // 가로 막대
		{{1, 0}, {1, 0}, {1, 0}}, // 세로 막대
		{{0, 1}, {1, 0}, {0, -1}}, // 정사각형
		{{1, 0}, {1, 0}, {0, 1}}, // 'ㄴ'자 1번 형
		{{0, -1}, {0, -1}, {1, 0}}, // 'ㄴ'자 2번 형
		{{-1, 0}, {-1, 0}, {0, -1}}, // 'ㄴ'자 3번 형
		{{0, 1}, {0, 1}, {-1, 0}}, // 'ㄴ'자 4번 형
		{{1, 0}, {1, 0}, {0, -1}}, // 'ㄴ'자 5번 형
		{{0, 1}, {0, 1}, {1, 0}}, // 'ㄴ'자 6번 형
		{{-1, 0}, {-1, 0}, {0, 1}}, // 'ㄴ'자 7번 형
		{{0, -1}, {0, -1}, {-1, 0}}, // 'ㄴ'자 8번 형
		{{1, 0}, {0, 1}, {1, 0}}, // 의자모양 1번 형
		{{0, 1}, {-1, 0}, {0, 1}}, // 의자모양 2번 형
		{{1, 0}, {0, -1}, {1, 0}}, // 의자모양 3번 형
		{{0, 1}, {1, 0}, {0, 1}}, // 의자모양 4번 형
		{{0, 1}, {1, 0}, {-1, 1}}, // 'ㅏ'모양 1번 형
		{{0, 1}, {-1, 0}, {1, 1}}, // 'ㅏ'모양 2번 형
		{{1, 0}, {0, 1}, {1, -1}}, // 'ㅏ'모양 3번 형
		{{1, 0}, {0, -1}, {1, 1}}, // 'ㅏ'모양 4번 형
	};
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				putTetromino(i, j);
			}
		}
		
		System.out.println(answer);
	}

	private static void putTetromino(int x, int y) {
		for(int i=0; i<dir.length; i++) { // 전체 모양 모두 해보기
			
			boolean isSuccess = true;
			int temp = map[x][y];
			int nx = x;
			int ny = y;
			for(int j=0; j<dir[i].length; j++) {
				nx += dir[i][j][0];
				ny += dir[i][j][1];
				
				if(x == 2 && y == 2) {
					System.out.println(nx +" " +ny);
				}
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) {
					isSuccess = false; // 불가능
					break;
				}
				
				temp += map[nx][ny]; 
			}
			if(x == 2 && y == 2) {
				System.out.println();
			}
			
			if(isSuccess && answer < temp) { // 테트로미노를 성공적으로 두고 해당 합이 지금까지의 합보다 큰 경우
				answer = temp;
			}
		}
	}

}
