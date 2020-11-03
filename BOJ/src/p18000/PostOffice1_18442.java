/**
 * Backjoon - 18442. 우체국 1
 * PostOffice1_18442.java
 * @date 2020-10-05
 * @author hansolKim
 **/

package p18000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PostOffice1_18442 {

	static int v, p;
	static long minDist, l;
	static int[] selectedIdx;
	static long[] input, selected, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기 위한 BufferedReader 생성

		StringTokenizer st = new StringTokenizer(br.readLine()); // 마을과 경찰서 입력받고 token으로 구분하기위한 StringTokenizer 생성

		v = Integer.parseInt(st.nextToken()); // 마을의 개수
		p = Integer.parseInt(st.nextToken()); // 경찰서의 개수
		l = Long.parseLong(st.nextToken()); // 둘레의 길이

		input = new long[v]; // 마을의 좌표를 담는 배열
		selected = new long[p]; // 경찰서를 지을 선택된 마을의 좌표를 담는 배열
		selectedIdx = new int[p]; // 경찰서를 지을 선택된 마을의 좌표의 인덱스를 담는 배열
		answer = new long[p];
		minDist = Long.MAX_VALUE; // 최소거리 값을 담을 변수

		st = new StringTokenizer(br.readLine()); // 마을의 위치좌표 입력받고 token으로 구분
		for (int i = 0; i < v; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}

		combination(0, 0);

		System.out.println(minDist); // 전체 결과 출력
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		br.close(); // BufferedReader close
	}

	// 조합코드 구현
	private static void combination(int start, int cnt) {
		if (cnt == p) {

			int idx = 0;
			long dist = 0;

			for (int i = 0; i < input.length; i++) {
				// 선택된 마을은 거리가 0이므로 pass
				if (idx < p && i == selectedIdx[idx]) {
					idx++;
					continue;
				}

				// 거리 계산이 필요한 경우
				long tempDist = Long.MAX_VALUE;
				for (int j = 0; j < selected.length; j++) { // 해당 마을과 가장 가까운 마을의 경찰서 거리 계산
					long value = Math.abs(input[i] - selected[j]); // 두 마을과의 거리
					tempDist = Math.min(tempDist, Math.min(value, l - value)); // 원형거리 비교
				}

				if (tempDist >= minDist) { // 계산된 거리가 이전에 계산된 전체거리와 같거나 큰 경우 ---> 더 이상 계산할 필요가 없다
					return;
				}

				dist += tempDist;
			}

			if (dist < minDist) { // 더 짧은 거리를 찾은 경우 ---> 갱신
				minDist = dist;
				answer = selected.clone();
			}
			return;
		}

		for (int i = start; i < v; i++) {
			selected[cnt] = input[i];
			selectedIdx[cnt] = i;
			combination(i + 1, cnt + 1);
		}
	}

}
