import java.util.Arrays;
import java.util.Scanner;

public class Flatten {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int dump = sc.nextInt(); // 덤프 횟수
			int[] boxlist = new int[100];
			
			// box 높이 입력
			for(int i=0; i<boxlist.length; i++) {				
				boxlist[i] = sc.nextInt();
			}
			
			for(int i=0; i<dump; i++) {
				
				Arrays.sort(boxlist);
				
				boxlist[boxlist.length-1]-=1;
				boxlist[0]+=1;
			}

			Arrays.sort(boxlist);
			System.out.println("#"+test_case + " " + (boxlist[boxlist.length-1] - boxlist[0]));

		}
	}
}
