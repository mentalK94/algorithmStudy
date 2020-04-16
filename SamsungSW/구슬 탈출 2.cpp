/*
** ���� Ż�� 2.cpp
** 2020-04-16
*/

/*
########
##.#.#.#
#...O#.#
#.#..###
#B#R#..#
########
*/

#include <iostream>

using namespace std;

char board[10][10];
int count = 0;
int minCount = 11;
int direction; // 0 : ������, 1 : ����, 2 : �Ʒ�, 3 : ��
int rx[4] = {0, 0, 1, -1};
int ry[4] = {1, -1, 0, 0};
bool isNext = false;

void tilt(char board[][10], int count, int direction, int redX, int redY, int blueX, int blueY) {
	
	// Ƚ������ 
	count++;
	
	int tempBlueX = blueX;
	int tempBlueY = blueY;
	
	// �Ķ����� �̵�
	while(true) {

		blueX = blueX + rx[direction];
		blueY = blueY + ry[direction];
		
		if(board[blueX][blueY] == 'O')  { // ������ ���
			return;
		}
		
		if(board[blueX][blueY] == '#')  { // �� �� ���� �����ΰ��
		
			// �� �� �������Ƿ� �̵� ��ȯ 
			blueX = blueX - rx[direction];
			blueY = blueY - ry[direction];
			
			board[tempBlueX][tempBlueY] = '.';
			board[blueX][blueY] = 'B';
			
			break; 
		}
	}
	
	// �Ķ������� ���������� �������� Ȯ��
	if(board[tempBlueX+rx[direction]][tempBlueY+ry[direction]] == 'R') {
		isNext = true;
		board[tempBlueX][tempBlueY] = 'B';
		board[blueX][blueY] = '.';
	}
		
	int tempRedX = redX;
	int tempRedY = redY;
	
	// �������� �̵�
	while(true) {
		
		redX = redX + rx[direction];
		redY = redY + ry[direction];
		
		if(board[redX][redY] == 'O' && count > 0)  { // ������ ���
			minCount = min(minCount, count);
			return;
		}
		
		if(board[redX][redY] != '.' && (direction == 0 || direction == 1))  { // �� �� ���� �����̰� �¿�θ� �̵��Ѱ�� -> ���Ϸ� �̵��غ�����
		
			// �� �� �������Ƿ� �̵� ��ȯ  
			redX = redX - rx[direction];
			redY = redY - ry[direction];
			
			// �Ķ����� ���̵�
			if(isNext) {
				blueX = redX - rx[direction];
				blueY = redY - rx[direction];
				board[tempBlueX][tempBlueY] = '.';
				board[blueX][blueY] = 'B';
			}
			
			board[tempRedX][tempRedY] = '.';
			board[redX][redY] = 'R';
			
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					cout << board[i][j];
				}
				cout << endl;
			}
			cout << endl;
			
			if(board[redX+1][redY] != '#')
				tilt(board, count, 2, redX, redY, blueX, blueY);
			if(board[redX-1][redY] != '#')
				tilt(board, count, 3, redX, redY, blueX, blueY);
			break; 
		}
		
		if(board[redX][redY] != '.' && (direction == 2 || direction == 3))  { // �� �� ���� �����̰� ���Ϸθ� �̵��Ѱ�� -> �¿�� �̵��غ�����
		
			// �� �� �������Ƿ� �̵� ��ȯ  
			redX = redX - rx[direction];
			redY = redY - ry[direction];
			
			// �Ķ����� ���̵�
			if(isNext) {
				blueX = redX - rx[direction];
				blueY = redY - rx[direction];
				board[tempBlueX][tempBlueY] = '.';
				board[blueX][blueY] = 'B';
			}
			
			board[tempRedX][tempRedY] = '.';
			board[redX][redY] = 'R';
			
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					cout << board[i][j];
				}
				cout << endl;
			}
			cout << endl;
			
			if(board[redX][redY+1] != '#')
				tilt(board, count, 0, redX, redY, blueX, blueY);
			if(board[redX][redY-1] != '#')
				tilt(board, count, 1, redX, redY, blueX, blueY);
			break;
		}
	}

	
	// ���ۿ� ������ Ȯ�� 
	
	// ���⼳�� 
}

int main(void) {
	
	int n, m, redX, redY, blueX, blueY;
	cin >> n >> m;
	
	for(int i=0; i<n; i++)  {
		for(int j=0; j<m; j++)  {
			cin >> board[i][j];
			if(board[i][j] == 'R'){
				redX = i;
				redY = j;
			}
			
			if(board[i][j] == 'B'){
				blueX = i;
				blueY = j;
			}
		}	
	}
	
	if(board[redX][redY+1] != '#') {
		tilt(board, count, 0, redX, redY, blueX, blueY);
	}
		
	if(board[redX][redY-1] != '#') {
		tilt(board, count, 1, redX, redY, blueX, blueY);
	}
		
	
	if(board[redX+1][redY] != '#')	{
		tilt(board, count, 2, redX, redY, blueX, blueY);
	}
		
	if(board[redX-1][redY] != '#') {
		tilt(board, count, 3, redX, redY, blueX, blueY);
	}
		
	
	if(minCount == 11) {
		minCount = -1;
	}
	
	cout << minCount << endl;
	
	return 0;
}


