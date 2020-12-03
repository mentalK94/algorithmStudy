/**
 * Samsung SW Expert - 8275. 햄스터
 * Hamster_8275.java
 * @date 2020-12-03
 * @author hansolKim
 * */

package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Hamster_8275 {
	
	static int N, X, M, hamsterCnt; // 우리의 개수, X마리 이하의 햄스터, 기록의 개수
	static int[] answer, selected;
	static ArrayList<int[]> logs;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			logs = new ArrayList<>();

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				logs.add(new int[] {from, to, cnt});
			}
			
			answer = new int[N+1];
			selected = new int[N+1];
			hamsterCnt = -1;
			perm(1);
			
			sb.append("#").append(tc).append(" ");
			if(hamsterCnt != -1) {
				for(int i=1; i<answer.length; i++) {
					sb.append(answer[i]).append(" ");
				}
			} else {
				sb.append(hamsterCnt);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void perm(int cnt) {
		if(cnt == N+1) {
			
			// M개의 기록에 대해서 검사
			for(int i=0; i<logs.size(); i++) {
				int from = logs.get(i)[0];
				int to = logs.get(i)[1];
				int hamCnt = logs.get(i)[2];
				
				int tempCnt = 0;
				for(int j=from; j<=to; j++) {
					tempCnt+=selected[j];
				}
				
				if(hamCnt != tempCnt) { return;}
			}
			
			// M개의 기록을 통과한 경우
			int hamCnt = 0;
			for(int i=1; i<selected.length; i++) {
				hamCnt += selected[i];
			}
			
			if(hamsterCnt < hamCnt) {
				hamsterCnt = hamCnt;
				
				for(int i=1; i<selected.length; i++) {
					answer[i] = selected[i];
				}
			}			
			return;
		}
		
		for(int i=0; i<=X; i++) {
			selected[cnt] = i;
			perm(cnt+1);
		}
	}

}
