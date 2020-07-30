package swexpert;

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
			
			N = sc.nextInt(); // ������ ũ�� �Է�
			map = new int[N][N];
			
			/* ���۹� ��ġ �Է� */
			for(int i=0; i<N; i++) {
				String str = sc.next();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j) - '0';
 				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j] + " ");
 				}
				System.out.println();
			}
			
			// ���� ��Ī ���۹� ���
			for(int i=0; i<N/2; i++) {				
				for(int j=((N/2)-i); j<=((N/2)+i); j++) {
					sum+=map[i][j];
					sum+=map[N-1-i][j];
				}
			}
			
			// ��� ���۹� ���
			for(int i=0; i<N; i++) {
				sum += map[N/2][i];
			}
			
			sb.append(sum).append("\n");

		}
		
		System.out.println(sb.toString());
	}

}
