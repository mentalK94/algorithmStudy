/**
 * Backjoon - 9934. 완전 이진 트리
 * 완전이진트리_9934.java
 * @date 2021-01-04
 * @author hansolKim
 **/

package p9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 완전이진트리_9934 {
	
	static int[] input, tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		
		int size = (int) Math.pow(2, K);
		tree = new int[size];
		input = new int[size];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<size; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
				
		makeTree(1, size-1, 1);
		
		StringBuilder sb = new StringBuilder();
		int base = 1;
		for(int i=1; i<size; ) {
			for(int j=i; j<i+base; j++) {
				sb.append(tree[j]).append(" ");
			}
			sb.append("\n");
			base *= 2;
			i = base;
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void makeTree(int left, int right, int idx) {
		int mid = (left+right)/2;
		tree[idx] = input[mid];
		
		if(left == right) { return;} // 리프노드인 경우
		
		makeTree(left, mid-1, idx*2); // 왼쪽노드로 이동
		makeTree(mid+1, right, idx*2+1); // 왼쪽노드로 이동	
	}
}