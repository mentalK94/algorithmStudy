/**
 * Backjoon - 2042. 구간 합 구하기
 * SegmentSum_2042.java
 * @date 2020-12-10
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SegmentSum_2042 {
	
	static int N, M, K; // 수의 개수, 수의 변경 횟수, 구간합을 구하는 갯수
	static long[] numArray, segTree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		numArray = new long[N+1];
		segTree = new long[2*N];
		
		for(int i=1; i<=N; i++) {			
			numArray[i] = Long.parseLong(br.readLine());
		}
		
		init(1, N, 1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			// System.out.println(Arrays.toString(segTree));
			
			if(command == 1) { // left번째 수 right로 변경
				update(1, N, 1, left, right);
			} else {
				long answer = getSegSum(1, N, 1, left, right);
				sb.append(answer).append("\n");
			}
			
		}
		
		bw.write(sb.toString());;
		bw.flush();
		bw.close();
		br.close();
	}

	private static long getSegSum(int start, int end, int idx, int left, int right) {
		if(right < start || end < left) { return 0; }
		if(left <= start && end <= right) { return segTree[idx]; }
		
		int mid = (start+end)/2;
		
		return getSegSum(start, mid, idx*2, left, right) 
				+ getSegSum(mid+1, end, idx*2+1, left, right); 
		
	}

	private static long update(int start, int end, int node, int idx, int value) {
		
		if(idx < start || end < idx) { return segTree[node]; }
		if(start == end) { return segTree[node] = value;}
		
		int mid = (start+end)/2;
		
		long leftValue = update(start, mid, node*2, idx, value);
		long rightValue = update(mid+1, end, node*2+1, idx, value);
		
		segTree[node] = (leftValue + rightValue);
		
		return segTree[node]; 
	}

	private static long init(int start, int end, int idx) {
		if(start == end) {
			return segTree[idx] = numArray[start];
		}
		
		int mid = (start+end)/2;
		
		segTree[idx]+=init(start, mid, idx*2);
		segTree[idx]+=init(mid+1, end, idx*2+1);
		
		return segTree[idx];
	}
}
