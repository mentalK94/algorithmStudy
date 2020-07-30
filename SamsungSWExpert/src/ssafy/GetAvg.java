package ssafy;

import java.util.Scanner;

public class GetAvg {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T;
		T=sc.nextInt();
	
		double sum;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case).append(" ");
			sum = 0;
			
			for(int i=0; i<10; i++) {
				int num = sc.nextInt();
				sum+=num;
			}
			
			sb.append(Math.round(sum/10)).append("\n");			
		}
		
		System.out.println(sb.toString());
	}

}
