/**
 * programmers - 3진법 변환
 * _3진법_변환.java
 * @date 2021-03-19
 * @author hansolKim
 **/

package programmers;

public class _3진법_변환 {
	
	public int solution(int n) {
		int answer = 0;

		int k = 1;
		while (k * 3 <= n) {
			k *= 3;
		}

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append((n / k));
			n %= k;
			k /= 3;
		}

		k = 1;
		for (int i = 0; i < sb.length(); ++i) {
			answer += ((sb.toString().charAt(i) - '0') * k);
			k *= 3;
		}

		return answer;
	}
}
