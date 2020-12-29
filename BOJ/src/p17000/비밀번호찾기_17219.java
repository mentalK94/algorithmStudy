/**
 * Backjoon - 17219. 비밀번호 찾기
 * 비밀번호찾기_17219.java
 * @date 2020-12-29
 * @author hansolKim
 **/

package p17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 비밀번호찾기_17219 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 사이트 주소의 수
		int M = Integer.parseInt(st.nextToken()); // 찾는 사이트 주소의 수
		
		HashMap<String, String> siteMap = new HashMap<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String password = st.nextToken();
			
			siteMap.put(site, password);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			String site = br.readLine();
			sb.append(siteMap.get(site)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}