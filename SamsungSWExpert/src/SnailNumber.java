import java.util.Scanner;

/**
 * SW ExpertAcademy
 * 달팽이 숫자
 * 달팽이의 크기 N은 1~10 정수
 * */


public class SnailNumber {

	private static int N; // 달팽이의 크기
	private static int map[][]; // 달팽이
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case).append("\n");
			
			N = sc.nextInt(); // 달팽이의 크기 입력
			
			map = new int[N][N];
			
			int point = 1;
			int x=0, y=0;
			
			if(N == 1) {
				sb.append(1).append("\n");
				continue;
			}
			
			while(true) {
				if(point != 1) {
					y++;
					x++;
				}
				
				if(map[x][y] != 0) {break;}
				
				while(y<N) { // 우측방향 채우기
					if(map[x][y] != 0) {break;}
					map[x][y] = point++;
					y++;
				}
				
				y--; x++;
				while(x<N) { // 아랫방향 채우기
					if(map[x][y] != 0) {break;}
					map[x][y] = point++;
					x++;
				}
				
				x--; y--;
				while(y>=0) { // 오른쪽 방향 채우기
					if(map[x][y] != 0) {break;}
					map[x][y] = point++;
					y--;
				}
				
				y++; x--;
				while(x>=0) { // 위쪽방향 채우기
					if(map[x][y] != 0) {break;}
					map[x][y] = point++;
					x--;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb.toString());
		
	}

}
