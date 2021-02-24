/**
 * Backjoon - 4796. 캠핑
 * 캠핑_4796.java
 * @date 2021-02-24
 * @author hansolKim
 **/

package p4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 캠핑_4796 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			if (L == 0) {
				break;
			}

			int answer = (V / P) * L;
			answer += V % P < L ? V % P : L;

			sb.append("Case ").append(tc).append(": ").append(answer).append("\n");
			tc++;
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
