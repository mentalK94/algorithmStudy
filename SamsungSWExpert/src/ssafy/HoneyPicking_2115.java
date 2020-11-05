/**
 * Samsung SW Expert - 2115. 벌꿀채취
 * HoneyPicking_2115.java
 * @date 2020-11-05
 * @author hansolKim
 * */

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HoneyPicking_2115 {
	
	static StringBuilder sb;
	static int N, M, C, answer, tempA, tempB;
	static int[][] map;
	static boolean[][] checked;
	static boolean[] selected;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			checked = new boolean[N][N];
			list = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = 0;
			
			main1:for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(j+M-1>=N) continue main1; // 범위를 초과한 경우
					
					for(int l=0; l<M; l++) { checked[i][j+l] = true; }
					
					main2:for(int k=i; k<N; k++) {
						for(int t=0; t<N; t++) {
							if(checked[k][t]) continue;
							if(t+M-1>=N) continue main2;
							
							selected = new boolean[M];
							tempA = 0;
							tempB = 0;
							subSet(i, j, 0, 0);
							subSet(k, t, 0, 1);
							if(tempA+tempB>answer) {
								answer = tempA+tempB;
							}
						}
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void subSet(int r, int c, int cnt, int type) {
		if(cnt == M) {
			list.clear();
			int num=0;
			for(int i=0; i<M; i++) {
				if(selected[i]) {
					num+=map[r][c+i];
					list.add(map[r][c+i]);
				}
			}
			
			if(num == 0 || num>C) {return;}
			num = 0;
			for(int n : list) {
				num += (n*n);
			}
			
			if(type == 0 && tempA<num) {tempA=num; return;}
			if(type == 1 && tempB<num) {tempB=num; return;}
			return;
		}
		
		selected[cnt] = true;
		subSet(r, c, cnt+1, type);
		selected[cnt] = false;
		subSet(r, c, cnt+1, type);
	}
}
