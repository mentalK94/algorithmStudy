package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1_200922 {

	private static int[] memory;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		memory = new int[num+1];
		
		System.out.println(fibonacci(num));
	}

	private static int fibonacci(int num) {
		if(num == 1) {return 2;}
		if(num == 2) {return 3;}
		if(num >=3 && memory[num] == 0) {
			memory[num] = fibonacci(num-1) + fibonacci(num-2); 
		}
		return memory[num]; 
	}

}
