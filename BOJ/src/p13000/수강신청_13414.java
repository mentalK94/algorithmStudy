/**
 * Backjoon - 13414. 수강신청
 * 수강신청_13414.java
 * @date 2020-12-29
 * @author hansolKim
 **/

package p13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 수강신청_13414 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); // 수강 가능한 인원 수
		int L = Integer.parseInt(st.nextToken()); // 수강신청 버튼을 클릭한 학생의 학번
		
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0; i<L; i++) {
			int cnt = 1;
			String key = br.readLine();
			list.add(key);
			if(map.containsKey(key)) {
				cnt = map.get(key)+1;
			}
			
			map.put(key, cnt);
		}
		
		StringBuilder sb = new StringBuilder();

		for(String key : list) {
			if(map.get(key) == 1) { // 한번 남았을 때 => 대기 목록 추가
				sb.append(key).append("\n");
				if(--K == 0) { break;}
			} else {
				map.put(key, map.get(key)-1);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}