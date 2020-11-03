package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LISTest {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] LIS = new int[N]; // 각 LIS의 길이를 만족하는 맨 끝에오는 최소값을 저장
		
		StringTokenizer st = new StringTokenizer(br.readLine());		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = 0;
		for(int i=0; i<N; i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]); // 탐색 키 --> 찾으면 인덱스, 못찾으면 음수값으로 자신이 삽입될 위치 : -삽입위치 -1
		
			// 중복값이 없다면 temp : 음수 값
			temp = Math.abs(temp)-1; // 삽입위치 환산
			LIS[temp] = arr[i];
			
			if(temp == size) { // 맨뒤에 추가하는 상황
				++size;
			}
		}
		
		System.out.println(size);
	}

}
