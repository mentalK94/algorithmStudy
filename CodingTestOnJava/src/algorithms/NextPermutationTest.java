package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NextPermutationTest {

	private static int N, R;
	private static int[] numbers, input;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer data = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(data.nextToken());
		R = Integer.parseInt(data.nextToken());
		
		input = new int[N];
		
		data = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(data.nextToken());
		}
		
		Arrays.sort(input);
		nextPermutation(input);
	}
	
	private static boolean nextPermutation(int numbers[]) {
		
		// 1. 맨 끝에서부터 전으로 탐색했을 때 작아지는 구간이 생기는 경우 큰 수를 i번째 수, 작은 수 i-1번째 수
		
		// 2. i번째 수부터 탐색해서 i-1번째보다 다음 큰 수를 찾아 교환
		
		// 3. i번째 수부터 끝까지 오름차순으로 변경
		
		System.out.println(Arrays.toString(numbers));
		return true;
	}
	
	private static void swap(int numbers[], int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
