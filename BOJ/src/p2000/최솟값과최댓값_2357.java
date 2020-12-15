/**
 * Backjoon - 2357. 최솟값과 최댓값
 * 최솟값과최댓값_2357.java
 * @date 2020-12-15
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 최솟값과최댓값_2357 {

	static int N, M;
	static int[] maxTree, minTree, input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N+1];
		// 숫자 입력
		for(int i=1; i<=N; i++) { input[i] = Integer.parseInt(br.readLine()); }
		
		maxTree = new int[4*N];
		minTree = new int[4*N];
		
		for(int i=0; i<4*N; i++) {
			minTree[i] = Integer.MAX_VALUE;
		}
		
		// maxtree, mintree 초기화
		initMaxTree(1, N, 1);
		initMinTree(1, N, 1);
		
		StringBuilder sb = new StringBuilder();
		
		// M개의 연산 수행
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			int min = getMinTree(1, N, 1, left, right);
			int max = getMaxTree(1, N, 1, left, right);
			
			sb.append(min).append(" ").append(max).append("\n");
		}
		
		bw.append(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int getMinTree(int start, int end, int node, int left, int right) {
		if(left > end || right < start) { return Integer.MAX_VALUE; }
		if(left<=start && end<=right) { return minTree[node]; }
		
		int mid = (start+end)/2;
		int leftNodeValue = getMinTree(start, mid, node*2, left, right);
		int rightNodeValue = getMinTree(mid+1, end, node*2+1, left, right);
		return Math.min(leftNodeValue, rightNodeValue);
	}
	
	private static int getMaxTree(int start, int end, int node, int left, int right) {
		if(left > end || right < start) { return Integer.MIN_VALUE; }
		if(left<=start && end<=right) { return maxTree[node]; }
		
		int mid = (start+end)/2;
		int leftNodeValue = getMaxTree(start, mid, node*2, left, right);
		int rightNodeValue = getMaxTree(mid+1, end, node*2+1, left, right);
		return Math.max(leftNodeValue, rightNodeValue);
	}

	private static int initMinTree(int start, int end, int node) {
		if(start == end) { 
			return minTree[node] = input[start]; 
		}
		
		int mid = (start+end)/2;
		int left = initMinTree(start, mid, node*2);
		int right = initMinTree(mid+1, end, node*2+1);
		
		return minTree[node] = left < right ? left : right;
	}

	private static int initMaxTree(int start, int end, int node) {
		if(start == end) { 
			return maxTree[node] = input[start]; 
		}
		
		int mid = (start+end)/2;
		int left = initMaxTree(start, mid, node*2);
		int right = initMaxTree(mid+1, end, node*2+1);
		
		return maxTree[node] = left > right ? left : right;
	}

}
