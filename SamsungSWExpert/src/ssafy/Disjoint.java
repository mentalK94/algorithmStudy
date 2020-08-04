/**
 * Samsung SW Expert 과제 - 3289. 서로소 집합
 * Disjoint.java
 * @date 2020-08-04
 * @author hansolKim
 **/


package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Disjoint {

	private static int N;
	private static int M;
	private static int[] set;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T;
		T=Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#"+test_case+" ");
			
			StringTokenizer init = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(init.nextToken());
			M = Integer.parseInt(init.nextToken());
			
			set = new int[N+1];
			
			make();
			
			for(int i=0; i<M; i++) {
			
				StringTokenizer input = new StringTokenizer(br.readLine());
				
				int command = Integer.parseInt(input.nextToken());
				int numA = Integer.parseInt(input.nextToken());
				int numB = Integer.parseInt(input.nextToken());
				
				/* 합집합 연산 */
				if(command == 0) {
					union(numA, numB);
					continue;
				}
				
				/* 같은 집합인지 여부 확인 */
				if(command == 1) {
					if(find(numA) == find(numB)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void make() {
		for (int i = 1; i <= N; i++) {
			set[i] = i;
		}
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return; 
		set[bRoot] = aRoot;
	}
	
	static int find(int a) {//a의 부모
		if(set[a] == a) return a;
		return set[a] = find(set[a]);
	}

}
