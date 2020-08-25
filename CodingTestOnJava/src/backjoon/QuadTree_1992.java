/**
 * Backjoon - 1992. 쿼드트리
 * QuadTree_1992.java
 * @date 2020-08-25
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QuadTree_1992 {

	private static int map[][];
	private static int N;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = data.charAt(j) - '0';
			}
		}
		
		compression(0, 0, N-1, N-1);
		
		System.out.println(sb);

	}

	private static void compression(int x, int y, int height, int width) {

		// 1. 해당 상태에서 처리 ---> 사각형 형태 조사
		if ((x + 1) == height && (y + 1) == width) {
			StringBuilder temp = new StringBuilder();

			temp.append("(");
			temp.append(map[x][y]);
			temp.append(map[x][y+1]);
			temp.append(map[x+1][y]);
			temp.append(map[x+1][y+1]);
			temp.append(")");
			
			// "(0000)" ---> 0 예외처리
			if(temp.toString().equals("(0000)")) {
				sb.append(0);
				return;				
			}
			
			// "(1111)" ---> 1 예외처리			
			if(temp.toString().equals("(1111)")) {
				sb.append(1);
				return;
			}
			sb.append(temp.toString()); // 기존  스트링 삽입
			return;
		}

		// 4 분할
		int midX = (x+height)/2;
		int midY = (y+width)/2;
		
		sb.append("(");
		compression(x, y, midX, midY);
		compression(x, midY+1, midX, width);
		compression(midX+1, y, height, midY);
		compression(midX+1, midY+1, height, width);
		sb.append(")");
		
		if(sb.substring(sb.length()-6, sb.length()).equals("(0000)")) {
			sb.replace(sb.length()-6, sb.length(), "0");
			return;
		}
		
		if(sb.substring(sb.length()-6, sb.length()).equals("(1111)")) {
			sb.replace(sb.length()-6, sb.length(), "1");
			return;
		}
	}

}
