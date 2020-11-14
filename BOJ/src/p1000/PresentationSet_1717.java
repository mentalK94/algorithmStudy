/**
 * Backjoon - 1717. 집합의 표현
 * PresentationSet_1717.java
 * @date 2020-11-14
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PresentationSet_1717 {

	static int n, m;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parents = new int[n+1];
		
		make();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken()); // 명령
			int a = Integer.parseInt(st.nextToken()); // a값
			int b = Integer.parseInt(st.nextToken()); // b값
			
			if(cmd == 0) { // 합집합
				union(a, b);
			} else { // 포합되어있는지 여부
				if(isUnion(a, b)) {sb.append("YES");}
				else {sb.append("NO");}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}

	private static void make() {
		for(int i=0; i<=n; i++) {
			parents[i]=i;
		}
	}
	
	private static int getParent(int x) {
		if(x == parents[x]) return x;
		return x = getParent(parents[x]);
	}
	
	private static void union(int x, int y) {
		int xRoot = getParent(x);
		int yRoot = getParent(y);
		
		if(xRoot == yRoot) { return;}
		parents[yRoot] = xRoot;
	}
	
	private static boolean isUnion(int x, int y) {
		int xRoot = getParent(x);
		int yRoot = getParent(y);
		
		if(xRoot == yRoot) { return true;}
		return false;
	}
}