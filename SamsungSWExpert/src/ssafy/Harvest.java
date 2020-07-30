package ssafy;


import java.util.Scanner;

public class Harvest {

	private static int N;
	private static int[][] map;
	private static int sum;
	private static StringBuilder sb;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			sb.append("#").append(test_case).append(" ");
			
			N = sc.nextInt(); // 농장 크기 입력
			map = new int[N][N];
			
			/* 농작물 가치 입력 */
			for(int i=0; i<N; i++) {
				String str = sc.next();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j) - '0';
 				}
			}
			
			/* 상하 대칭 계산 */
			for(int i=0; i<N/2; i++) {				
				for(int j=((N/2)-i); j<=((N/2)+i); j++) {
					sum+=map[i][j];
					sum+=map[N-1-i][j];
				}
			}
			
			/* 가운데 계산 */
			for(int i=0; i<N; i++) {
				sum += map[N/2][i];
			}
			
			sb.append(sum).append("\n");

		}
		
		System.out.println(sb.toString());
	}

}
