/**
 * Backjoon - 10868. 최솟값
 * 최솟값_10868.java
 * @date 2020-12-16
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 최솟값_10868 {

	static int N, M;
	static int[] input, minTree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정수의 개수 입력
		M = Integer.parseInt(st.nextToken()); // 연산의 개수 입력
		
		input = new int[N+1];
		minTree = new int[4*N];
		
		for(int i=1; i<=N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<4*N; i++) {
			minTree[i] = Integer.MAX_VALUE;
		}
		
		initMinTree(1, N, 1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			sb.append(getMinTree(1, N, 1, left, right)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int getMinTree(int start, int end, int node, int left, int right) {
		if(right < start || end < left) { return Integer.MAX_VALUE; }
		if(left <= start && end <= right) { return minTree[node]; }
		
		int mid = (start+end)/2;
		int leftNodeValue = getMinTree(start, mid, node*2, left, right);
		int rightNodeValue = getMinTree(mid+1, end, node*2+1, left, right);
		return Math.min(leftNodeValue, rightNodeValue);
	}

	private static int initMinTree(int start, int end, int node) {
		if(start == end) { return minTree[node] = input[start]; }
		int mid = (start+end)/2;
		int left = initMinTree(start, mid, node*2);
		int right = initMinTree(mid+1, end, node*2+1);
		return minTree[node] = Math.min(left, right);
	}
}