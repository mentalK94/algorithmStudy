package ssafy;

import java.util.Scanner;

public class BattleField {

	private static char[][] field; // 필드
	private static int row; // 행 갯수
	private static int col; // 열 갯수
	private static int commendCount; // 수행할 명령갯수 입력
	private static String command; // 수행할 사용자 입력
	private static StringBuilder sb;
	private static int curX; // 전차의 현재 위치 x좌표
	private static int curY; // 전차의 현재 위치 y좌표
	private static int curDirection; // 전차의 현재 방향 0:상, 1:하, 2:좌, 3:우
	private static char[] dirCharacter = {'^', 'v', '<', '>'}; 

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			row = sc.nextInt();
			col = sc.nextInt();

			field = new char[row][col];

			boolean isInit = false;

			// 초기 필드상태 입력
			for (int i = 0; i < row; i++) {
				String str = sc.next();
				for (int j = 0; j < col; j++) {
					if(!isInit) {
						for(int k=0; k<4; k++) {
							if(str.charAt(j) == dirCharacter[k]) {
								curX = i;
								curY = j;
								curDirection = k;
								isInit = true;
							}
						}
					}
					field[i][j] = str.charAt(j);
				}
			}

			// 수행 갯수 입력
			commendCount = sc.nextInt();
			
			// 사용자 수행명령 입력
			command = sc.next();

			// 명령 수행
			for (int i = 0; i < commendCount; i++) {

				switch (command.charAt(i)) {
				case 'U': // Up
					move(0, curX - 1, curY);
					break;
				case 'D': // Down
					move(1, curX + 1, curY);
					break;
				case 'L': // Left
					move(2, curX, curY - 1);
					break;
				case 'R': // Right
					move(3, curX, curY + 1);
					break;
				case 'S': // Shoot
					shoot();
					break;
				default:
					break;
				}

			}
			
			for(int i=0; i<row; i++) {
				sb.append(String.valueOf(field[i])).append("\n");
			}

		}
		
		System.out.println(sb.toString());
	}

	// shoot method 구현
	private static void shoot() {
		
		int dx[] = {-1, 1, 0, 0};
		int dy[] = {0, 0, -1, 1};
		
		int size = curDirection < 2 ? row : col;
				
		for(int i=1; i<size; i++) {
			if(!shootAction(curX+(dx[curDirection]*i), curY+(dy[curDirection]*i))) break;
		}
	}
	
	// 벽에 부딪혔거나 field밖으로 나간경우 false, 다음 작업을 수행할 수 있는 경우 true
	private static boolean shootAction(int x, int y) {
		
		if(isArea(x, y)) {
			char fieldState = field[x][y];
			if(fieldState == '.' 
				|| fieldState == '-') return true; // 평지또는 물인 경우
			if(fieldState == '#') return false; // 강철 벽돌에 충돌한 경우
			if(fieldState == '*') {
				field[x][y] = '.';
				return false;
			}
			return false;
		}
		return false;
	}

	// move method 구현
	private static void move(int direction, int rx, int ry) {

		// 1. 방향전환
		curDirection = direction;

		// 2. 이동할수 있는 범위인지 확인
		if (isMove(rx, ry)) {
			field[curX][curY] = '.';
			curX = rx;
			curY = ry;
		}
		field[curX][curY] = dirCharacter[direction];
	}

	private static boolean isMove(int x, int y) { // 전차가 이동할 수 있는 범위인지 확인
		return (isArea(x, y) && (field[x][y] == '.')) ? true : false;
	}

	private static boolean isArea(int x, int y) { // field 내부인지 확인
		return (x >= 0 && x < row && y >= 0 && y < col) ? true : false;
	}
}