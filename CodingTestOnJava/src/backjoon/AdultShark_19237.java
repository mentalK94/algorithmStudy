/**
 * Backjoon - 19237. 어른 상어
 * AdultShark_19237.java
 * @date 2020-09-19
 * @time 16:45~
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AdultShark_19237 {

	private static int N, M, K, sharkCnt; // N:맵의 크기, M:상어의 수, K:상어의 냄새
	private static int[][] map, sharkList; // 격자 정보, 상어의 위치정보
	private static ArrayList<int[]> smellList; // 냄새 영역 정보
	private static ArrayList<Integer> sharkCurDirection; // 상어들의 현재 방향정보
	private static int[][][] directionInfos; // 상어들의 방향 정보

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 격자 크기입력
		M = Integer.parseInt(st.nextToken()); // 상어의 수 입력
		K = Integer.parseInt(st.nextToken()); // 상어의 냄새
		sharkCnt = M;

		map = new int[N][N];
		sharkCurDirection = new ArrayList<>();
		smellList = new ArrayList<>();
		sharkList = new int[M + 1][2];

		// 격자정보 넣기 및 상어위치정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) { // 상어인 경우 --> 위치정보, 냄새정보 입력
					sharkList[map[i][j]][0] = i;
					sharkList[map[i][j]][1] = j;
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		sharkCurDirection.add(-1); // 의미없는 값 삽입
		// 상어의 현재 방향정보 입력
		for (int i = 1; i <= M; i++) {
			sharkCurDirection.add(Integer.parseInt(st.nextToken()));
		}

		int[][][] directionInfos = new int[M + 1][4][4]; // 각 상어들의 방향에 따른 우선순위 정보를 담을 공간

		// 각 상어들의 방향에 따른 우선순위 정보 삽입
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					directionInfos[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		int t = 0;

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		while (t < 1000) {
			t++; // 시간 증가

			// 1. 자신의 위치에서 자신의 냄새를 뿌림
			for (int i = 1; i < sharkList.length; i++) {
				if (sharkList[i][0] == -1)
					continue; // 유효하지 않은 상어 패스
				smellList.add(new int[] { sharkList[i][0], sharkList[i][1], i, K });
				map[sharkList[i][0]][sharkList[i][1]] = i; // 지도에 영역 표기
			}

			// 2. 모든 상어가 동시에 상하좌우로 인접한 칸 중 하나로 이동
			for (int i = 1; i < sharkList.length; i++) {
				if (sharkList[i][0] == -1)
					continue; // 유효하지 않은 상어
				int curDir = sharkCurDirection.get(i); // 상어의 현재 방향
				boolean isMove = false;
				// 상어의 현재방향에 따른 우선순위대로 아무 냄새없는 칸 찾기
				for (int j = 0; j < 4; j++) {
					int nextDir = directionInfos[i][curDir - 1][j];
					System.out.println(i + ":" + curDir + "=>" + nextDir);

					int nx = sharkList[i][0] + dx[nextDir - 1];
					int ny = sharkList[i][1] + dy[nextDir - 1];

					// 영역 밖이거나 냄새가 있는 경우 패스
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0)
						continue;

					// 상어의 위치변경
					sharkList[i][0] = nx;
					sharkList[i][1] = ny;

					// 상어의 방향정보 변경
					sharkCurDirection.set(i, nextDir);

					// 이동했음을 표기
					isMove = true;
					break;
				}

				if (!isMove) { // 이동할 곳이 없어서 이동하지 못한 경우 ---> 자신의 냄새가 있는 곳으로 이동
					for (int j = 0; j < 4; j++) {
						int nextDir = directionInfos[i][curDir - 1][j];

						int nx = sharkList[i][0] + dx[nextDir - 1];
						int ny = sharkList[i][1] + dy[nextDir - 1];

						// 영역 밖이 거나 본인 냄새가 아닌 경우 패스
						if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != i)
							continue;

						// 상어의 위치변경
						sharkList[i][0] = nx;
						sharkList[i][1] = ny;

						// 상어의 방향정보 변경
						sharkCurDirection.set(i, nextDir);
						break;
					}
				}
			}

			// 상어의 위치 비교(같은 곳에 상어가 여러마리인지 확인)
			for (int i = 1; i < sharkList.length - 1; i++) {
				if (sharkList[i][0] == -1)
					continue;
				int x = sharkList[i][0];
				int y = sharkList[i][1];
				for (int j = i + 1; j < sharkList.length; j++) {
					if (i == j)
						continue;
					if (sharkList[j][0] == -1)
						continue;
					if (x == sharkList[j][0] && y == sharkList[j][1]) { // 같은 곳에 상어가 존재하는 경우
						sharkList[j][0] = -1;
						sharkCnt--;
					}
				}
			}

			System.out.println("turn " + t);
			for (int i = 1; i < sharkList.length; i++) {
				if (sharkList[i][0] == -1)
					continue;
				System.out.println(i + " : " + sharkList[i][0] + ", " + sharkList[i][1]);
			}
			System.out.println();
			// 상어의 갯수가 1마리인지 확인
			if (sharkCnt == 1) {
				break;
			}

			// 현재 냄새정보 갱신
			for (int i = 0; i < smellList.size(); i++) {
				if (smellList.get(i)[3] - 1 == 0) { // 냄새가 사라지는 경우
					map[smellList.get(i)[0]][smellList.get(i)[1]] = 0; // 격자 정보에 아무것도 없음으로 갱신
					smellList.remove(i); // 냄새정보리스트에서 삭제
					i--;
				} else {
					smellList.get(i)[3]--; // 냄새정보 갱신
				}
			}

		}

		if (t > 1000)
			System.out.println(-1);
		else
			System.out.println(t);
	}

}
