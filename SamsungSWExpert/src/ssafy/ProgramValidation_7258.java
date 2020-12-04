/**
 * Samsung SW Expert - 7258. 혁진이의 프로그램 검증
 * ProgramValidation_7258.java
 * @date 2020-12-04
 * @author hansolKim
 * */

package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ProgramValidation_7258 {

	static String answer;
	static int r, c, dir, mem;
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 }; // 우좌상하
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][][][] visited;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			map = new char[r][c];
			for (int i = 0; i < r; i++) {
				map[i] = br.readLine().toCharArray();
			}

			visited = new boolean[r][c][4][16];

			answer = execute() == true ? "YES" : "NO";

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	// 실행을 bfs로 구현
	private static boolean execute() {

		Queue<int[]> stateQueue = new LinkedList<>();
		stateQueue.add(new int[] { 0, 0, 0, 0 }); // 현재위치 x, y, 방향: dir, 메모리: mem

		while (!stateQueue.isEmpty()) {
			int[] state = stateQueue.poll();

			int x = state[0];
			int y = state[1];
			int dir = state[2];
			int mem = state[3];
			
			System.out.println(x + " " + y + " " + dir + " " + mem);
			
			if(visited[x][y][dir][mem]) { continue; } // 이미 방문된 곳인 경우 --> 패스

			visited[x][y][dir][mem] = true; // 방문처리
			char command = map[x][y];

			switch (command) {
			case '<': // 왼쪽으로 방향전환
				dir = 1; 
				break;
			case '>': // 오른쪽으로 방향전환
				dir = 0;
				break;
			case '^': // 위쪽으로 방향전환
				dir = 2;
				break;
			case 'v': // 아랫쪽으로 방향전환
				dir = 3;
				break;
			case '_': // 메모리의 0이 저장되어 있으면 이동향방 -> 오른쪽, 아니면 -> 왼쪽
				dir = mem == 0 ? 0 : 1;
				break;
			case '|': // 메모리의 0이 저장되어 있으면 이동향방 -> 아래쪽, 아니면 -> 위쪽
				dir = mem == 0 ? 3 : 2;
				break;
			case '.': // 아무것도 하지 않는다.
				break;
			case '@': // 프로그램 실행 정지
				return true;
			case '+': // 메모리에 저장된 값 1을 더한다
				mem = (mem+1) == 16 ? 0 : mem+1;
				break;
			case '-': // 메모리에 저장된 값 1을 뺀다
				mem = (mem-1) == -1 ? 15 : mem-1;
				break;
			case '?':
				for(int i=0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					nx = (nx==-1) ? r-1 : nx;
					nx = (nx==r) ? 0 : nx;
					ny = (ny==-1) ? c-1 : ny;
					ny = (ny==c) ? 0 : ny;
					
					stateQueue.add(new int[] {nx, ny, i, mem});
				}
				continue;
			default: // 숫자가 들어온 경우
				mem = command-'0';
				break;
			}
			
			// 해당 방향대로 이동
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			nx = (nx==-1) ? r-1 : nx;
			nx = (nx==r) ? 0 : nx;
			ny = (ny==-1) ? c-1 : ny;
			ny = (ny==c) ? 0 : ny;
			
			stateQueue.add(new int[] {nx, ny, dir, mem});
		}
		return false;
	}

}
