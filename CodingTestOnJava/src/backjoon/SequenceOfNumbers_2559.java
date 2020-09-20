/**
 * Backjoon - 2559. 수열
 * SequenceOfNumbers_2559.java
 * @date 2020-09-20
 * @author hansolKim
 **/

/**
 * review : 시뮬레이션 문제는 유도조건과 기저조건의 순서가 상당히 중요하다
 * */ 
package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SequenceOfNumbers_2559 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
	
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i=0; i<K; i++) {
			sum += arr[i];
		}

		int answer = sum;
		int idx = 0;
		while(true) {
			
			if(idx+K >= N) { break;} // idx+K 지점이 배열의 인덱스를 초과한 경우 break
			
			sum -= (arr[idx]); // 이전 인덱스 값 제거
			sum += (arr[idx+K]); // 새로운 인데스 값 추가
			answer = Math.max(answer, sum);
			
			idx++;
		}
		
		System.out.println(answer);
		br.close();
	}

}
