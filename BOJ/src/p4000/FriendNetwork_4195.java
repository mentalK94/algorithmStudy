/**
 * Backjoon - 4195. 친구 네트워크
 * FriendNetwork_4195.java
 * @date 2020-12-06
 * @author hansolKim
 **/

package p4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FriendNetwork_4195 {
	
	static int[] parents, cnts;
	static HashMap<String, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {			
			int N = Integer.parseInt(br.readLine()); // 관계의 수
			
			map = new HashMap<>();
			parents = new int[2*N];
			cnts = new int[2*N];
			
			for(int i=0; i<parents.length; i++) {
				parents[i] = i;
			}
			
			int group = 0;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				String a = st.nextToken();
				String b = st.nextToken();
				
				// 그룹이 없는 경우 그룹 추가
				if(!map.containsKey(a)) { 
					map.put(a, group);
					cnts[group++]++;
				}
				
				if(!map.containsKey(b)) { 
					map.put(b, group);
					cnts[group++]++;
				}
				// 두개의 그룹 합치기
				union(a, b);
				
				sb.append(cnts[find(map.get(a))]).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void union(String a, String b) {
		int rootA = find(map.get(a));
		map.put(a, rootA);
		int rootB = find(map.get(b));
		map.put(b, rootB);
		
		if(rootA != rootB) {
			cnts[rootA] += cnts[rootB];
			cnts[rootB] = 0;
			map.put(b, rootA);
			parents[rootB] = rootA;
		}
	}

	private static int find(int group) {
		if(group == parents[group]) return group;
		cnts[parents[group]] += cnts[group];
		cnts[group] = 0;
		return parents[group] = find(parents[group]);
	}

}