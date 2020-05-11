/*
** programmers-ũ���� �����̱� ����.cpp
** 2020-05-11
*/

#include <vector>
#include <iostream>
#include <cstring>

using namespace std;

int basket[900] = {0,}; 
int position_cache[30]; // ������ -1

int solution(vector<vector<int> > board, vector<int> moves) {
    int answer = 0;
    int basket_idx = 0;
    int basket_cnt = 0; // ���� �ٱ��Ͽ� �����ϴ� ���� ���� 
    int moves_idx = 0;
    int board_idx = 0;
    int size = board.size(); // board ũ��
    
    memset(basket, -1, sizeof(basket));
    
    for(int i=0; i<size; i++) {
    	for(int j=0; j<size; j++) {
    		if(board[j][i] != 0) { // ������ �����ϴ� ��� 
				position_cache[i] = j; // ������ �����ϴ� ��ġ ���� 
				break;
			}
		}		
	}

	while(moves_idx < moves.size()) {
		
		int move_number = moves[moves_idx]-1;
		
		if(position_cache[move_number] == -1) { // ������ �������� �ʴ� ��� 
			moves_idx++;
			continue;
		}
		
		// ������ �ٱ��Ͽ� ����
		basket[basket_idx] = board[position_cache[move_number]][move_number];
		basket_cnt++;
		
		// position_cache ����
		if(position_cache[move_number] + 1 != size) { // ���� �����ε����� �̵� 
			position_cache[move_number]++;
		} else { // ������ ��� ������ ��� 
			position_cache[move_number] = -1;
		}
		
		if(basket_cnt > 1) { // �ٱ��Ͽ� �����ϴ� ���� ������ 2�� �̻��� ��� 
			if(basket[basket_idx] == basket[basket_idx-1]) { // ���� ������ �����ϴ� ��� 
				basket[basket_idx] = 0;
				basket[basket_idx-1] = 0;
				basket_idx -= 2;
				basket_cnt -= 2;
				answer+=2;	
			}			
		}
		
		basket_idx++; 
		moves_idx++;
	}
    return answer;
}
