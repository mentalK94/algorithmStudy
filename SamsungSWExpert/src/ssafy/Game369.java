package ssafy;

import java.util.Scanner;

public class Game369 {
	
	private static StringBuilder sb;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int T;
		T=1;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt(); // 숫자 입력
			
			for(int i=1; i<=N; i++) {				
				if(!isThreeSixNine(i)) { //  3, 6, 9가 포함되지 않은 경우
					sb.append(i+ " ");
				}
			}
			sb.append("\n");

		}
		System.out.println(sb.toString());
	}

	private static boolean isThreeSixNine(int num) {
		
		boolean flag = false;
		
		while(num>0) {
			
			int digit = num%10;
			if(digit == 3 || digit == 6 || digit == 9) {
				sb.append("-");
				flag = true;
			}
			
			num /= 10;
		}
		if(flag) { sb.append(" "); }
		
		return flag;
	}
}
