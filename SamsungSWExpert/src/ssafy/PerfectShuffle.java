package ssafy;

import java.util.Scanner;

public class PerfectShuffle {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case+" ");
			
			int cardCnt = sc.nextInt();
			String[] cards = new String[cardCnt];
			
			// card 입력
			for(int i=0; i<cardCnt; i++) {
				cards[i] = sc.next();
			}
			
			int halfStart = (cardCnt%2==0) ? (cardCnt/2):(cardCnt/2)+1;
			
			for(int i=0; i<cardCnt/2; i++) {
				sb.append(cards[i]+" ");				
				sb.append(cards[halfStart]+" ");
			}				

			if(cardCnt % 2 == 1)
				sb.append(cards[(cardCnt/2)]);

			sb.append("\n");
	
		}
		System.out.println(sb.toString());
	}
}
