/**
 * Samsung SW Expert - 5643. 키 순서
 * HeightOrder_5643.java
 * @date 2020-11-04
 * @author hansolKim
<<<<<<< HEAD
 **/
=======
 * */
>>>>>>> 586106e81792d81fd729195de545a19cf8b76d87

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Student {
	Set<Integer> inputList;
	Set<Integer> outputList;

	public Student() {
		inputList = new HashSet<>();
		outputList = new HashSet<>();
	}
}

public class HeightOrder_5643 {

	static Student[] students;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine()); // 학생 수
			int M = Integer.parseInt(br.readLine()); // 비교 수

			// ArrayList<int[]> info = new ArrayList<>();
			students = new Student[N + 1];

			for (int i = 1; i <= N; i++) {
				students[i] = new Student();
			}

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				// a의 아웃풋 추가
				students[a].outputList.add(b);

				// b의 인풋 추가
				students[b].inputList.add(a);

			}

			int answer = 0;
			for (int i = 1; i <= N; i++) {
				Student s = students[i];
				int cnt = 0;
				cnt += getInputCnt(s);
				cnt += getOutputCnt(s);

				if (cnt == N - 1) {
					answer++;
				}
			}

			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			 
		}

=======
import java.util.StringTokenizer;

public class HeightOrder_5643 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			int n = Integer.parseInt(br.readLine()); // 학생 수
			int m = Integer.parseInt(br.readLine()); // 비교 수
			
			int[][] map = new int[n+1][n+1];
			
			for(int i=0; i<m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map[a][b] = 1;
			}
			
			for(int k=1; k<=n; k++) { // 경유지 
				for(int i=1; i<=n; i++) { // 출발지
					for(int j=1; j<=n; j++) { // 도착지
						if(map[i][j] == 1) continue;
						if(map[i][k] == 1 && map[k][j] == 1) {map[i][j] = 1;}
					}
				}
			}
			
			int answer = 0;
			main:for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(i == j) continue;
					if(map[i][j] == 0 && map[j][i] == 0) {
						continue main;
					}
				}
				answer++;
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
>>>>>>> 586106e81792d81fd729195de545a19cf8b76d87
		System.out.println(sb);
		br.close();
	}

<<<<<<< HEAD
	private static int getInputCnt(Student s) {

		if(s.inputList.size() == 0) { return 0; }
		
		Set<Integer> tempSet = new HashSet<Integer>();
		for (int n : s.inputList) {
			getInputParent(s, n, tempSet);
		}
		
		for(int n : tempSet) {
			s.inputList.add(n);
		}
		return s.inputList.size();
	}

	private static void getInputParent(Student s, int n, Set<Integer> set) {
		for (int a : students[n].inputList) {
			set.add(a);
			getInputParent(s, a, set);
		}
	}

	private static int getOutputCnt(Student s) {

		if(s.outputList.size() == 0) { return 0; }
		
		Set<Integer> tempSet = new HashSet<Integer>();
		for (int n : s.outputList) {
			getOutputParent(s, n, tempSet);
		}
		
		for(int n : tempSet) {
			s.outputList.add(n);
		}
		return s.outputList.size();
	}

	private static void getOutputParent(Student s, int n, Set<Integer> set) {
		for (int a : students[n].outputList) {
			set.add(a);
			getOutputParent(s, a, set);
		}
	}

=======
>>>>>>> 586106e81792d81fd729195de545a19cf8b76d87
}
