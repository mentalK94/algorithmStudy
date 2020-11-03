/**
 * Backjoon - 7568. 덩치
 * BigSize_7568.java
 * @date 2020-08-31
 * @author hansolKim
 **/

package p7000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BigSize_7568 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> personList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			personList.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<personList.size(); i++) {
			int cnt = 1;
			int w = personList.get(i)[0];
			int h = personList.get(i)[1];
			
			// 본인보다 덩치가 큰 사람 몇명있는지 조사
			for(int j=0; j<personList.size(); j++) {
				if(w<personList.get(j)[0] && h<personList.get(j)[1]) {
					cnt++;
				}
			}
			sb.append(cnt).append(" ");
		}

		System.out.println(sb);
		br.close();
	}

}
