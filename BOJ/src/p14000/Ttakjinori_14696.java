/**
 * Backjoon - 14696. 딱지놀이
 * Ttakjinori_14696.java
 * @date 2020-09-20
 * @author hansolKim
 **/

package p14000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ttakjinori_14696 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int round = Integer.parseInt(br.readLine());
		int[] a, b;

		StringTokenizer st;
		for (int i = 0; i < round; i++) {
			a = new int[4]; // 0: 별, 1: 동그라미, 2: 네모, 3: 세모
			b = new int[4];

			// A의 그림 총 갯수 + 그림
			st = new StringTokenizer(br.readLine());
			int aCnt = Integer.parseInt(st.nextToken());

			for (int j = 0; j < aCnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				a[4 - num]++;
			}

			// B의 그림 총 갯수 + 그림
			st = new StringTokenizer(br.readLine());
			int bCnt = Integer.parseInt(st.nextToken());

			for (int j = 0; j < bCnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				b[4 - num]++;
			}
			
			boolean isDraw = true;
			// 비교
			for(int j=0; j<4; j++) {
				if(a[j] > b[j]) {
					sb.append("A").append("\n");
					isDraw = false;
					break;
				} else if(a[j] < b[j]) {
					sb.append("B").append("\n");
					isDraw = false;
					break;
				} 
			}
			
			if(isDraw) {
				sb.append("D").append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}

}
