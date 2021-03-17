/**
 * programmers - 방문 길이
 * 방문길이.java
 * @date 2021-03-18
 * @author hansolKim
 **/

package programmers;

public class 방문길이 {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][][] visited;

	public int solution(String dirs) {
		int answer = 0;

		visited = new boolean[4][11][11];

		int curX = 0;
		int curY = 0;

		for (int i = 0; i < dirs.length(); ++i) {
			char com = dirs.charAt(i);
			int idx = -1;
			if (com == 'U') {
				idx = 0;
			}
			if (com == 'D') {
				idx = 1;
			}
			if (com == 'L') {
				idx = 2;
			}
			if (com == 'R') {
				idx = 3;
			}
			int nx = curX + dx[idx];
			int ny = curY + dy[idx];

			if (nx == -6 || nx == 6 || ny == -6 || ny == 6) {
				continue;
			}

			curX = nx;
			curY = ny;

			if (visited[idx][curX + 5][curY + 5])
				continue;

			visited[idx][curX + 5][curY + 5] = true;
			int preIdx = idx % 2 == 0 ? idx + 1 : idx - 1;
			visited[preIdx][curX - dx[idx] + 5][curY - dy[idx] + 5] = true;
			answer++;
		}

		return answer;
	}
}
