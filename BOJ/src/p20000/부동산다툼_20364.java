/**
 * Backjoon - 20364. 부동산 다툼
 * 부동산다툼_20364.java
 * @date 2021-01-05
 * @author hansolKim
 **/

package p20000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 부동산다툼_20364 {

	static int N, Q; // 땅의 개수, 오리의 수
	static int[] tree; // 땅 형태
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		tree = new int[N+1];
		
		sb = new StringBuilder();
		
		for(int i=1; i<=Q; i++) {
			int num = Integer.parseInt(br.readLine());
			
			occupation(i, num);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	 // id번째 오리가 num번호 땅을 차지하는 행위
	private static void occupation(int id, int num) {
		
		boolean isSuccess = true;
		int preOccupation = 0;
		int temp = num;
		
		while(temp>0) {
			if(tree[temp] != 0) { // 이미 차지한 주인이 있는 경우
				preOccupation = temp;
				isSuccess = false;
			}
			temp /= 2;
		}
		
		tree[num] = isSuccess ? id : tree[num];
		sb.append(isSuccess ? 0 : preOccupation).append("\n");
	}
}