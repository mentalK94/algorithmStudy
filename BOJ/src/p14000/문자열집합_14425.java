/**
 * Backjoon - 14425. 문자열 집합
 * 문자열집합_14425.java
 * @date 2021-01-04
 * @author hansolKim
 **/

package p14000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 문자열집합_14425 {

public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		while(N-->0) {
			set.add(br.readLine());
		}
		
		int cnt = 0;
		while(M-->0) {
			if(set.contains(br.readLine())) { cnt++; }
		}
		
		System.out.println(cnt);
		br.close();
	}
}