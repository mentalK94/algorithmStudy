/**
 * Samsung SW Expert - 2383. 점심 식사시간
 * LunchTime_2383.java
 * @date 2020-12-03
 * @author hansolKim
 * */

package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LunchTime_2383 {
	
	static int answer, R;
	static boolean[] isSelected;
	static int[][] map, stairs;
	static ArrayList<int[]> persons;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			persons = new ArrayList<>();
			stairs = new int[2][3];
			map = new int[N][N];
			
			int stairIdx = 0;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						persons.add(new int[] {i, j});
					}
					if(map[i][j] > 1) {
						stairs[stairIdx][0] = i;
						stairs[stairIdx][1] = j;
						stairs[stairIdx++][2] = map[i][j];
					}
				}
			}
			
			R = persons.size();
			isSelected = new boolean[R];
			
			answer = Integer.MAX_VALUE;
			subSet(0);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void subSet(int cnt) {
		if(cnt == R) {
			
			Queue<int[]> q = new LinkedList<>();
			
			for(int i=0; i<R; i++) {
				int[] person = persons.get(i);
				int stairType = 0;
				int dist = 0;
				if(isSelected[i]) { // 1번 계단 이용
					dist = getDist(person[0], person[1], stairs[0][0], stairs[0][1]);
					stairType = 1;
				} else { // 2번 계단 이용
					dist = getDist(person[0], person[1], stairs[1][0], stairs[1][1]);
					stairType = 2;
				}
				q.add(new int[] {dist, stairType});
			}
			
			ArrayList<Integer> stairA = new ArrayList<>();
			ArrayList<Integer> stairB = new ArrayList<>();
			
			int time = 1;
			int personCnt = 0;
			while(true) {
				
				time++; // 시간 증가
				
				// 계단에 사람이 있으면 최대 3명까지 시간 감소
				int stairSize = stairA.size()<3 ? stairA.size():3;
				for(int i=0; i<stairSize; i++) {
					stairA.set(i, stairA.get(i)-1);
				}
				
				stairSize = stairB.size()<3 ? stairB.size():3;
				for(int i=0; i<stairSize; i++) {
					stairB.set(i, stairB.get(i)-1);
				}
				
				for(int i=0; i<stairA.size(); i++) {
					if(stairA.get(i) == 0) {
						stairA.remove(i);
						personCnt++;
						i--;
					}
				}
				
				for(int i=0; i<stairB.size(); i++) {
					if(stairB.get(i) == 0) {
						stairB.remove(i);
						personCnt++;
						i--;
					}
				}
				
				if(personCnt == R) {
					if(time < answer) {
						answer = time;
					}
					return;
				}
				
				int size = q.size();
				for(int i=0; i<size; i++) {
					int[] person = q.poll();
					int dist = person[0];
					int type = person[1];
					
					if(--dist == 0) {
						if(type == 1) {
							stairA.add(stairs[0][2]);
						} else {
							stairB.add(stairs[1][2]);
						}
					} else {
						q.add(new int[] {dist, type});
					}
					
				}
			}
		}
		
		isSelected[cnt] = true;
		subSet(cnt+1);
		isSelected[cnt] = false;
		subSet(cnt+1);
	}
	
	private static int getDist(int x, int y, int tX, int tY) {
		return Math.abs(x-tX) + Math.abs(y-tY); 
	}

}
