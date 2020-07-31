package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SquareRoom {

	private static int N;
	private static int[][] square;
	private static int count;
	private static int dx[] = {-1, 1, 0, 0};
	private static int dy[] = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		int T, answer, roomNumber = 0;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case+ " ");
			
			N = Integer.parseInt(br.readLine());
			
			square = new int[N][N];

			// 방 번호 입력
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				
				for(int j=0; j<N; j++) {
					square[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			// 최대 이동갯수 초기화
			answer = 0;
			
			// 각 방마다 이동할 수 있는 방 갯수 탐색
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					count = 1;
					getMoveCount(i, j); // i, j 방에서 이동할 수 있는 횟수 구하는 메서드 호출
					if(answer < count) {
						roomNumber = square[i][j];
						answer = count;
					} else if(answer == count && 
							square[i][j] < roomNumber) {
						roomNumber = square[i][j];						
					}
				}
			}
			
			sb.append(roomNumber + " " + answer + "\n");
		}
		
		System.out.println(sb);
	}

	private static void getMoveCount(int x, int y) {		
		for(int i=0; i<4; i++) {
			int rx = x+dx[i];
			int ry = y+dy[i];
			if(isInSquare(rx, ry)) {
				if(square[x][y]+1 == square[rx][ry]) {
					count++;
					getMoveCount(rx, ry);	
				}				
			}
		}		
	}
	
	private static boolean isInSquare(int x, int y) {
		return (x>=0 && x<N && y>=0 && y<N) ? true : false;
	}
}