/**
 * Backjoon - 1043. 거짓말
 * 거짓말_1043.java
 * @date 2020-12-30
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말_1043 {
	
	static int[][] relation;
	static boolean[] person;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		person = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		int truePersonCnt = Integer.parseInt(st.nextToken());
		for(int i=0; i<truePersonCnt; i++) {
			int num = Integer.parseInt(st.nextToken());
			person[num] = true;
		}
		
		ArrayList<Integer>[] party = new ArrayList[M]; // 파티의 개수	
		
		relation = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				party[i].add(num);				
			}
			
			for(int j=0; j<party[i].size(); j++) {
				int a = party[i].get(j);
				for(int k=0; k<party[i].size(); k++) {
					if(j == k) continue;
					int b = party[i].get(k);
					relation[a][b] = 1;
					relation[b][a] = 1;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(person[i]) { // 진실을 아는 사람일 경우
				connect(i);
			}
		}
		
		int cnt = 0;
		for(int i=0; i<M; i++) {
			boolean fakeSuccess = true;
			for(int j=0; j<party[i].size(); j++) {
				if(person[party[i].get(j)]) {
					fakeSuccess = false;
					break;
				}
			}
			
			cnt = fakeSuccess ? cnt+1 : cnt;
		}
		
		System.out.println(cnt);
		br.close();
	}

	private static void connect(int num) {
		
		for(int i=1; i<=N; i++) {
			if(relation[num][i] == 1 && !person[i]) { // 연관되어 있고 아직 진실을 전하지 않은 경우
				person[i] = true;
				connect(i);
			}
		}
	}
}