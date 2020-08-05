package backjoon;

import java.util.Scanner;

public class Hansu {

	private static int[] arr;
	private static int answer;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		arr = new int[3];
		answer = 0;
		
		int n = sc.nextInt(); // 1~999
		
		if(n<100) answer = n;
		else {
			for(int i=100; i<=n; i++) {
				if(i == 1000) {break;}
				isHansu(i);
			}
			
			answer += 99;
		}
		
		System.out.println(answer);
	}
	
	public static void isHansu(int number) {		
		
		for(int i=0; i<3; i++) {
			arr[i] = number%10;
			number /= 10;
		}
				
		if(arr[0]-arr[1] == arr[1]-arr[2]) {
			answer++;
		}
	}

}
