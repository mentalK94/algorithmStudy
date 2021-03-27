/**
 * programmers - 3xN 타일링
 * _3xN_타일링.java
 * @date 2021-03-24
 * @author hansolKim
 **/

package programmers;

public class _3xN_타일링 {
	public int solution(int n) {
		long[] arr = new long[n + 1];
		int mod = 1000000007;

		arr[0] = 1;
		arr[2] = 3;

		for (int i = 4; i <= n; i += 2) {
			arr[i] = arr[i - 2] * 3;
			for (int j = i - 4; j >= 0; j -= 2) {
				arr[i] = arr[i] + arr[j] * 2;
			}
			arr[i] %= mod;
		}

		return (int) arr[n];
	}
}
