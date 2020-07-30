package ssafy;

import java.util.Scanner;

public class SubscriberWar {

	private static int max;
	private static int min;
	private static int N, A, B;
	private static StringBuilder sb;
	
	public static void main(String args[]) throws Exception
	{
		
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case).append(" ");
			N = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			
			max = (A < B) ? A : B;
			
			min = ((A+B)-N < 0) ? 0 : (A+B)-N; 
			
			sb.append(max).append(" ");
			sb.append(min).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
