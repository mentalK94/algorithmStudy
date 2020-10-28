/**
 * Samsung SW Expert - 4014. 활주로 건설
 * ConstructRunway_4014.java
 * @date 2020-10-28
 * @author hansolKim
 **/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConstructRunway_4014 {
	
	static int N, X;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int answer = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int road;
			boolean[][][] isSlope = new boolean[N][N][N];
			
			// 행에서 지나갈 수 있는 길의 개수 검사
			for(int i=0; i<N; i++) {
				road = 1;
				int curH = map[i][0];
				for(int j=1; j<N; j++) {
					if(curH == map[i][j]) { // 높이가 같은 경우
						road++;
						continue;
					}
					
					if(curH == map[i][j]+1) { // 내리막 경사로
						// X의 길이만큼 map[i][j] 높이와 같은 지 확인
						int connect = 1; // 연속적으로 연결된 갯수
						int tempJ = j;
						isSlope[i][i][tempJ] = true;
						while(tempJ+1<N && map[i][tempJ] == map[i][tempJ+1] && connect<X && !isSlope[i][i][tempJ+1]) {
							connect++;
							tempJ++;
							isSlope[i][i][tempJ] = true;
						}
						
						if(connect == X) { // 경사로 연결에 성공한 경우
							road += connect;
							j = tempJ;
							curH = map[i][j];
						} else { // 경사로 연결에 실패한 경우
							break;
						}
					} else if(curH == map[i][j]-1) { // 오르막 경사로
						
						int cnt = 1; // 연속적으로 연결된 갯수
						int tempJ = j-1;
						if(isSlope[i][i][tempJ]) { break;}
						isSlope[i][i][tempJ] = true;
						while(tempJ-1>=0 && map[i][tempJ] == map[i][tempJ-1] && cnt < X && !isSlope[i][i][tempJ-1]) {
							cnt++; tempJ--;
							isSlope[i][i][tempJ] = true;
						}
						
						if(cnt == X) { // 경사로 연결에 성공한 경우
							road++;
							curH = map[i][j];
						} else { // 경사로 연결에 실패한 경우
							break;
						}
						
					} else { // 높이가 1이상 차이나는 경우
						break;
					}
				}
				
				if(road == N) { 
					answer++; 
				}
			}
			
			isSlope = new boolean[N][N][N];
			// 열에서 지나갈 수 있는 길의 개수 검사
			for(int i=0; i<N; i++) {
				road = 1;
				int curH = map[0][i]; // 해당 줄의 첫 시작 높이
				for(int j=1; j<N; j++) {
					if(curH == map[j][i]) {
						road++;
						continue;
					}
					
					if(curH == map[j][i]+1) { // 내리막 경사로
						// L의 길이만큼  map[i][j]높이와 같은 지 확인
						int connect = 1; // 연속적으로 연결된 갯수
						int tempJ = j;
						isSlope[i][tempJ][i] = true;
						while(tempJ+1<N && map[tempJ][i] == map[tempJ+1][i] && connect < X && !isSlope[i][tempJ+1][i]) {
							connect++; tempJ++;
							isSlope[i][tempJ][i] = true;
						}
						
						if(connect == X) { // 경사로 연결에 성공한 경우
							road += connect;
							j = tempJ;
							curH = map[j][i];						
						} else { // 경사로 연결에 실패한 경우
							break;
						}
						
					} else if(curH == map[j][i]-1) { // 오르막 경사로
						
						int cnt = 1; // 연속적으로 연결된 갯수
						int tempJ = j-1;
						
						if(isSlope[i][tempJ][i]) { break;}
						isSlope[i][tempJ][i] = true;
						while(tempJ-1>=0 && map[tempJ][i] == map[tempJ-1][i] && cnt < X && !isSlope[i][tempJ-1][i]) {
							cnt++; tempJ--;
							isSlope[i][tempJ][i] = true;
						}
						
						if(cnt == X) { // 경사로 연결에 성공한 경우
							road++;
							curH = map[j][i];
						} else { // 경사로 연결에 실패한 경우
							break;
						}
						
					} else { // 높이가 1이상 차이나는 경우
						break;
					}
				}
				
				if(road == N) { 
					answer++; 
				}
			}

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();

	}

}
