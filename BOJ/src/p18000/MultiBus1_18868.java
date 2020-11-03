/**
 * Backjoon - 18868. 멀티버스 Ⅰ
 * MultiBus_18868.java
 * @date 2020-09-01
 * @author hansolKim
 **/

package p18000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MultiBus1_18868 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); // 학급 수 입력
		int N = Integer.parseInt(st.nextToken()); // 반 학생 수 입력
		int[][] arr = new int[M][N]; // M*N크기만큼 2차원 배열 생성
		int answer = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()); // 각 반 학생들의 점수라인으로 토큰 생성
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); // 각 토큰(학생 점수) 배열에 삽입
			}
		}

		boolean flag = true;

		for (int i = 0; i < M - 1; i++) { // i반을 기준으로 탐색(ex. 0, 1, 2... 4(5반까지 있다면))
			for (int t = i+1; t < M; t++) { // i+1반부터 M-1반까지 i반과 비교 (ex. 1, 2, 3, ... 5(5반까지 있다면))
				flag = true;
				main:for (int j = 0; j < N - 1; j++) {
					for (int k = j + 1; k < N; k++) {
						// i반의 학생 분포의 따른 i+1반 학생분포 탐색
						if ((arr[i][j] < arr[i][k]) && (arr[t][j] < arr[t][k])) { // 비슷한 학급의 상태 1
							continue;
						} else if ((arr[i][j] > arr[i][k]) && (arr[t][j] > arr[t][k])) { // 비슷한 학급의 상태 2
							continue;
						} else if ((arr[i][j] == arr[i][k]) && (arr[t][j] == arr[t][k])) { // 비슷한 학급의 상태 3
							continue;
						} else { // 학급이 비슷하지 않은 경우 ---> 현재 두 학급은 비슷하지 않으므로 더 이상 비교할 필요가 없다
							flag = false; // 비슷하지 않다는 표기
							break main; // main으로 label된 for-loop 탈출
						}
					}
				}
				if(flag) { // 비슷한 학급인 경우
					answer++; // 비슷한 학급의 쌍 개수 추가
				}
				
			}
		}
		
		System.out.println(answer); // 결과 출력

	}

}
