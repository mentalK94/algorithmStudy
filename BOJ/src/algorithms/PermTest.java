package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PermTest {

	private static int N, R;
	private static int[] numbers, input;
	private static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer data = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(data.nextToken());
		R = Integer.parseInt(data.nextToken());
		
		input = new int[N];
		isSelected = new boolean[N];
		numbers = new int[R];
		
		data = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(data.nextToken());
		}
		
		permutation(0);
	}
	
	private static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) { continue; }
			
			isSelected[i] = true;
			numbers[cnt] = input[i];
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

}
