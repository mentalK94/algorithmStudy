package ssafy;

import java.util.Scanner;

/**
 * [0729 과제]SW Expert - 파리퇴치 구현
 * */
public class EliminateFlies {

	private static int N, M;	
	private static int[][] map;
	private static int maxEliminate; // 죽은 파리의 최대 갯수
	private static int eliminateCount; // 죽은 파리의 갯수
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
			
			N = sc.nextInt(); // 배열 크기 입력
			M = sc.nextInt(); // 파리채 크기 입력
			
			map = new int[N][N];
			
			maxEliminate = 0;
			
			/* 파리 갯수 입력 */
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					eliminateCount = 0;
					
					/* 죽은 파리의 개수 */
					getEliminateCount(i, j);
					
					maxEliminate = Math.max(maxEliminate, eliminateCount); 
				}
			}
			
			sb.append(maxEliminate).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void getEliminateCount(int x, int y) {
		for(int i=x; i<x+M; i++) {
			for(int j=y; j<y+M; j++) {
				eliminateCount += map[i][j];
			}
		}
	}
}
