/**
 * Backjoon - 2491. 수열
 * SequenceOfNumbers_2491.java
 * @date 2020-09-20
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SequenceOfNumbers_2491 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxConnection = 1;
		int startIdx = 0;
		int finishIdx = 0;
		int dir = 0; // 0: 같음, 1: 증가, -1: 감소

		while(true) {
			
			 startIdx = finishIdx;
			 while(startIdx>0 && arr[startIdx] == arr[startIdx-1]) {
				 startIdx--;
			 }
			 finishIdx = startIdx+1;
			 if(finishIdx >= N) { break;}
			 
			 // startIdx와 finishIdx값 비교해서 방향 찾기
			 // 같을 경우 finishIdx값 증가
			 while(finishIdx<N-1 && arr[startIdx] == arr[finishIdx]) {
				 finishIdx++;
			 }
			 
			 if(arr[startIdx] < arr[finishIdx]) {
				 dir = 1; // 증가
			 } else if(arr[startIdx] > arr[finishIdx]) {
				 dir = -1; // 감소
			 }
			 
			 // 방향이 정해졌으니 해당 방향과 반대방향이 나올 때 까지 finishIdx 증가
			 if(dir == 1) { // 증가하는 경우
				 while(finishIdx+1 < N && arr[finishIdx] <= arr[finishIdx+1]) {
					 finishIdx++;
				 }
			 } else {
				 while(finishIdx+1 < N && arr[finishIdx] >= arr[finishIdx+1]) {
					 finishIdx++;
				 }
			 }
			 
			 // 연속적인 최대의 경우까지 이동했으므로 갱신
			 if(maxConnection < (finishIdx-startIdx+1)) {
				 maxConnection = finishIdx-startIdx+1;
			 }
			 
			 if(finishIdx >= N-1) {break;}
		}

		System.out.println(maxConnection);
	}

}
