/**
 * Backjoon - 7785. 회사에 있는 사람
 * 회사에있는사람_7785.java
 * @date 2020-12-30
 * @author hansolKim
 **/

package p7000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 회사에있는사람_7785 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String type = st.nextToken();
			
			if(type.equals("enter")) {
				set.add(name);
			} else {
				if(set.contains(name)) { set.remove(name); }
			}
		}
		
		String[] names = new String[set.size()];
		int idx = 0;
		for(String s : set) {
			names[idx++] = s;
		}
		
		Arrays.sort(names);
		
		StringBuilder sb = new StringBuilder();
		for(int i=names.length-1; i>=0; i--) {
			sb.append(names[i]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}