package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CombinationTest {

	private static int N, R;
	private static int[] numbers, input;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer data = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(data.nextToken());
		R = Integer.parseInt(data.nextToken());
		
		input = new int[N];
		numbers = new int[R];
		
		data = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(data.nextToken());
		}
		
		combination(0, 0);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}

}
