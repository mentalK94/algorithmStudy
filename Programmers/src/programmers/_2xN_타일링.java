/**
 * programmers - 2xN 타일링
 * _2xN_타일링.java
 * @date 2021-03-19
 * @author hansolKim
 **/

package programmers;

public class _2xN_타일링 {

	static int[] mem;

	public int solution(int n) {
		mem = new int[n + 1];
		mem[1] = 1;
		mem[2] = 2;

		for (int i = 3; i <= n; ++i) {
			mem[i] = mem[i - 1] % 1000000007 + mem[i - 2] % 1000000007;
		}

		return mem[n] % 1000000007;
	}
}
