/**
 * Backjoon - 1021. 회전하는 큐
 * RotateQueue_1021.java
 * @date 2020-11-30
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class RotateQueue_1021 {
	
	static Deque<Integer> dq;
	static int size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dq = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 숫자의 길이
		int M = Integer.parseInt(st.nextToken()); // 뽑아내려는 수

		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}

		int cnt = 0;
		size = N;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {

			int search = Integer.parseInt(st.nextToken());

			int leftCnt = left(search);

			cnt += leftCnt < (size-leftCnt) ? leftCnt : (size-leftCnt);
			size = dq.size();
		}

		System.out.println(cnt);
		br.close();
	}

	private static int left(int search) {

		int cnt = 0;

		while (true) {
			int n = dq.poll();
			if (n == search) {
				break;
			}
			
			dq.addLast(n);
			cnt++;
		}

		return cnt;
	}

}
