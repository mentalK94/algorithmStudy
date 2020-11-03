/**
 * Backjoon - 17144. 미세먼지 안녕!
 * FineDustBye_17144.java
 * @date 2020-09-02
 * @author hansolKim
 **/

package p17000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FineDustBye_17144 {

	private static int R, C, T, purifierX; // purifierX는 공기청정기의 위치
	private static int map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 행의 크기 입력
		C = Integer.parseInt(st.nextToken()); // 열의 크기 입력
		T = Integer.parseInt(st.nextToken()); // T초 크기 입력

		map = new int[R][C];

		/* 미세먼지 상태 입력 */
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		/* 공기청정기의 위치 찾기 */
		for (int i = 0; i < R; i++) {
			if (map[i][0] == -1) {
				purifierX = i;
				break;
			}
		}

		/* 전체 시뮬레이션 진행 */
		for (int i = 0; i < T; i++) {

			// 미세먼지 확산
			doDiffusion();

			// 공기청정기 작동
			doAirPurifier();
		}

		int answer = 0;

		/* 총 미세먼지 계산 */
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					answer += map[i][j];
				}
			}
		}

		System.out.println(answer);
	}

	private static void doDiffusion() { // 미세먼지 확산 메서드

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		int[][] temp = new int[R][C];

		for (int x = 0; x < R; x++) {
			for (int y = 0; y < C; y++) {

				temp[x][y] += map[x][y]; // 임시 공간에 현재위치 값 저장

				// 1. 확산될 수 있는 양의 미세먼지가 있는지 확인
				if (map[x][y] >= 5) {

					int diffusionValue = map[x][y] / 5;
					// 2. 인접한 4곳으로 미세먼지 전달
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];

						// 영역 밖이거나 공기청정기인 경우 확산 x
						if (nx < 0 || nx >= R || ny < 0 || ny >= C || (map[nx][ny] == -1))
							continue;

						// 확산 성공
						temp[nx][ny] += diffusionValue;

						// 확산 양만큼 줄어듦
						temp[x][y] -= diffusionValue;
					}

				}

			}
		}

		// 임시배열에서 map배열로 깊은 복사
		for (int i = 0; i < R; i++) {
			map[i] = temp[i].clone();
		}

	}

	private static void doAirPurifier() {

		// 1. 반시계방향 작동(purifierX)
		// 1-1. 맨 왼쪽열 데이터 아래로 1칸씩 이동(↓)
		for (int i = purifierX - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}

		// 1-2. 맨 위쪽행 데이터 왼쪽으로 1칸씩 이동(←)
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}

		// 1-3. 맨 오른쪽행 데이터 위쪽으로 1칸씩 이동(↑)
		for (int i = 0; i < purifierX; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}

		// 1-4. 첫번째 공기청정기 행 데이터 오른쪽으로 1칸씩 이동(→)
		for (int i = C - 1; i > 1; i--) {
			map[purifierX][i] = map[purifierX][i - 1];
		}

		map[purifierX][1] = 0;

		// 2. 시계방향 작동(purifierX+1)
		// 1-1. 맨 왼쪽행 데이터 위쪽으로 1칸씩 이동(↑)
		for (int i = purifierX+2; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}

		// 1-2. 맨 아랫쪽행 데이터 왼쪽으로 1칸씩 이동(←)
		for (int i = 0; i < C - 1; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}

		// 1-3. 맨 오른쪽열 데이터 아래로 1칸씩 이동(↓)
		for (int i = R - 1; i > purifierX + 1; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}

		// 1-4. 두번째 공기청정기 행 데이터 오른쪽으로 1칸씩 이동(→)
		for (int i = C - 1; i > 1; i--) {
			map[purifierX + 1][i] = map[purifierX + 1][i - 1];
		}

		map[purifierX + 1][1] = 0;
	}

}
