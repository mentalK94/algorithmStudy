/**
 * programmers - 이진_변환_반복하기
 * 이진_변환_반복하기.java
 * @date 2021-03-09
 * @author hansolKim
 **/

package programmers;

import java.lang.StringBuilder;

public class 이진_변환_반복하기 {

	public int[] solution(String s) {
		int[] answer = new int[2];

		StringBuilder sb = new StringBuilder();
		int cnt = 0; // 변환 횟수
		int removeCnt = 0; // 제거된 0의 개수
		while (s.length() > 1) {
			cnt++;
			// 1. x의 모든 0을 제거
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					sb.append(s.charAt(i));
				} else {
					removeCnt++;
				}
			}

			// 2. x의 길이
			int len = sb.length();
			s = Integer.toBinaryString(len);
			sb.replace(0, sb.length(), "");
		}

		answer[0] = cnt;
		answer[1] = removeCnt;
		return answer;
	}
}