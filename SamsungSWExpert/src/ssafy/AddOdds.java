package ssafy;

import java.util.Scanner;

public class AddOdds {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T;
		T=sc.nextInt();
	
		int sum;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case).append(" ");
			sum = 0;
			
			for(int i=0; i<10; i++) {
				int num = sc.nextInt();
				if(num%2==1) sum+=num;
			}
			
			sb.append(sum).append("\n");			
		}
		
		System.out.println(sb.toString());
	}

}
