package ssafy;

import java.util.Scanner;

public class BattleField {

	private static char[][] field; // 필드
	private static int row; // 행 갯수
	private static int col; // 열 갯수
	private static int commendCount; // 수행할 명령갯수 입력
	private static String command; // 수행할 사용자 입력
	private static StringBuilder sb;
	private static int curX = 0; // 전차의 현재 위치 x좌표
	private static int curY = 0; // 전차의 현재 위치 y좌표
	private static int curDirection = 0; // 전차의 현재 방향 0:상, 1:하, 2:좌, 3:우

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
					if (!isInit && str.charAt(j) == '^') {
						curX = i;
						curY = j;
						curDirection = 0;
						isInit = true;
					}
					if (!isInit && str.charAt(j) == 'v') {
						curX = i;
						curY = j;
						curDirection = 1;
						isInit = true;
					}
					if (!isInit && str.charAt(j) == '<') {
						curX = i;
						curY = j;
						curDirection = 2;
						isInit = true;
					}
					if (!isInit && str.charAt(j) == '>') {
						curX = i;
						curY = j;
						curDirection = 3;
						isInit = true;
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
					move(0, curX - 1, curY, '^');
					break;
				case 'D': // Down
					move(1, curX + 1, curY, 'v');
					break;
				case 'L': // Left
					move(2, curX, curY - 1, '<');
					break;
				case 'R': // Right
					move(3, curX, curY + 1, '>');
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
		int x = curX;
		int y = curY;
		char fieldState;
		
		// 바라보고 있는 방향으로 포탄 발사
		if(curDirection == 0) { // 윗쪽인 경우
			for(int i=curX-1; i>=0; i--) {
				if(isArea(i, curY)) { // 필드 내부인 경우
					fieldState = field[i][curY];
					if(fieldState == '.' 
						|| fieldState == '-') continue; // 평지인 경우
					if(fieldState == '#') break; // 강철 벽돌에 충돌한 경우
					if(fieldState == '*') {
						field[i][curY] = '.';
					}
				}
			}
		}
		
		if(curDirection == 1) { // 아랫인 경우
			for(int i=curX+1; i<row; i++) {
				if(isArea(i, curY)) { // 필드 내부인 경우
					fieldState = field[i][curY];
					if(fieldState == '.' 
						|| fieldState == '-') continue; // 평지인 경우
					if(fieldState == '#') break; // 강철 벽돌에 충돌한 경우
					if(fieldState == '*') {
						field[i][curY] = '.';
						break;
					}
				}
			}
		}
		
		if(curDirection == 2) { // 왼쪽인 경우
			for(int i=curY-1; i>=0; i--) {
				if(isArea(curX, i)) { // 필드 내부인 경우
					fieldState = field[curX][i];
					if(fieldState == '.' 
						|| fieldState == '-') continue; // 평지인 경우
					if(fieldState == '#') break; // 강철 벽돌에 충돌한 경우
					if(fieldState == '*') {
						field[curX][i] = '.';
					}
				}
			}
		}
		
		if(curDirection == 3) { // 오른쪽인 경우
			for(int i=curY+1; i<col; i++) {
				if(isArea(curX, i)) { // 필드 내부인 경우
					fieldState = field[curX][i];
					if(fieldState == '.' 
						|| fieldState == '-') continue; // 평지인 경우
					if(fieldState == '#') break; // 강철 벽돌에 충돌한 경우
					if(fieldState == '*') {
						field[curX][i] = '.';
					}
				}
			}
		}
	}

	// move method 구현
	private static void move(int direction, int rx, int ry, char c) {

		// 1. 방향전환
		curDirection = direction;

		// 2. 이동할수 있는 범위인지 확인
		if (isMove(rx, ry)) {
			field[curX][curY] = '.';
			curX = rx;
			curY = ry;
		}
		field[curX][curY] = c;
	}

	private static boolean isMove(int x, int y) { // 전차가 이동할 수 있는 범위인지 확인
		return (isArea(x, y) && (field[x][y] == '.')) ? true : false;
	}

	private static boolean isArea(int x, int y) { // field 내부인지 확인
		return (x >= 0 && x < row && y >= 0 && y < col) ? true : false;
	}

}
