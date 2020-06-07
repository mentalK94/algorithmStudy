/*
** programmers-2020 īī�� ����ε� ä��_��հ� �� ��ġ.cpp
** 2020-05-19
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int poll[102][102]; // ��� 
int bo[102][102]; // �� 
int build[102][102];

// �������� x, y, ��� �Ǵ� �� ������� �������� ������ �϶�� �ߴ�. vector�� �������� �䱸�Ѵ�� �������� �����ϱ� ���� compare �Լ�
bool compare(vector<int> &a, vector<int> &b){
    if(a[0] != b[0]) return a[0] < b[0];
    else if(a[0] == b[0] && a[1] != b[1]) return a[1] < b[1];
    else return a[2] < b[2];
}

// �� �Ǵ� ����� ������ �� �ִ��� üũ�ϴ� �Լ�
bool isBuilt(int x, int y, int type){
    
    // ����� ���
    if(type == 0){
        // �ٴڿ� ��ġ �ϰų� || �Ʒ��� ����� �����ϰų� ((y - 1)�̹Ƿ� y >= 1�̾���Ѵ�) || �ؿ� ���������� ���� ���� �ְų� || �ؿ� �������� ����
        // ���� ������ true, ������ false
        if(y == 0 || (y >= 1 && poll[y - 1][x] == 1) || bo[y][x] == 1 || (x >= 1 && bo[y][x - 1] == 1)){
            return true;
        }
        else return false;
    }
    // ���� ���
    else{
        // ���� �𼭸��� ����� ��ġ�� �ְų� || ������ �Ʒ��� ����� ��ġ�� �ְų� || �� ���� ���� ������ true, ������ false
        if((y >= 1 && (poll[y - 1][x] == 1 || poll[y - 1][x + 1] == 1)) || (x >= 1 && bo[y][x - 1] == 1 && bo[y][x + 1] == 1)){
            return true;
        }
        else return false;
    }
}



vector<vector<int> > solution(int n, vector<vector<int> > build_frame) {
    vector<vector<int> > answer;
    
    // ��ü �� �迭�� ���, ���� �ϳ��� ���� ���·� �ʱ�ȭ. build �迭�� ���� ���� ���� ���� �ӽ� ���� �迭. build�� 1�̸� ��ո� �ִ� ���, 2�̸� ����
    // �ִ� ���, 3�̸� �� �� �ִ� ����̴�.
    for(int i = 0; i <= 101; i++){
        for(int j = 0; j <= 101; j++){
            build[i][j] = 0;
            poll[i][j] = 0;
            bo[i][j] = 0;
        }
    }
    
    for(int i = 0; i < build_frame.size(); i++){
        
        int x = build_frame[i][0];
        int y = build_frame[i][1];
        int type = build_frame[i][2];
        int isBuild = build_frame[i][3];
        // ������ ���
        if(isBuild == 1){
            // �����ϰ��� �ϴ� ������Ʈ�� ����� ���
            if(type == 0){
                //����� ������ �� �ִ� ��ġ�̸�
                if(isBuilt(x, y, type)){
                    // ����̹Ƿ� 1����
                    build[y][x] += 1;
                    // �ش� ��ġ�� ��� �迭�� ����� �����ϰ� �ǹǷ� 1�� �������
                    poll[y][x] = 1;
                }
            }
            // �����ϰ��� �ϴ� ������Ʈ�� ���� ���
            else if(type == 1){
                // �Ȱ��� ó���� ���ش�.
                if(isBuilt(x, y, type)){
                    // ���̹Ƿ� 2 ����
                    build[y][x] += 2;
                    bo[y][x] = 1;
                }
            }
        }
        // ������ ���
        else if(isBuild == 0){
            // �����ϰ��� �ϴ� ������Ʈ�� ����� ���
            if(type == 0){
                // �ϴ� ����� ���� �� �ִٰ� ��������
                poll[y][x] = 0;
                // ����� �����µ� ���� �ٷ� ���� �ٸ� ����� ������, �� ����� ������ �� ���� ������,
                if(poll[y + 1][x] == 1 && !isBuilt(x, y + 1, 0)){
                    // �ٽ� ����� ���ΰ� ������ ���ϴϱ� �׳� �۾��� �����Ѵ�.
                    poll[y][x] = 1;
                }
                // ���� �������� ���� ���� �ְ� �� ���� ������ �� ���ٸ�,
                else if(x >= 1 && bo[y + 1][x - 1] == 1 && !isBuilt(x - 1, y + 1, 1)){
                    // ���� �ٽ� �ǵ���
                    poll[y][x] = 1;
                }
                // ���� ���������� ���� ���� �ִ� ���
                else if(bo[y + 1][x] == 1 && !isBuilt(x, y + 1, 1)){
                    poll[y][x] = 1;
                }
                // ���� ���̽��� �ش���� ������ ���� �� �ִ�. ����̹Ƿ� -1 ������.
                else build[y][x] -= 1;
            }
            // �����ϰ��� �ϴ� ������Ʈ�� ���� ���
            else if(type == 1){
                // ���� �ϴ� ���� ���� �� �ִٰ� ��������
                bo[y][x] = 0;
                // ���� �𼭸� ���� ����� ���� ���
                if(poll[y][x] == 1 && !isBuilt(x, y, 0)){
                    bo[y][x] = 1;
                }
                // ������ �𼭸��� ����� ���� ���
                else if(poll[y][x + 1] == 1 && !isBuilt(x + 1, y, 0)){
                    bo[y][x] = 1;
                }
                // ���ʿ� ���� ���� ���
                else if(x >= 1 && bo[y][x - 1] == 1 && !isBuilt(x - 1, y, 1)){
                    bo[y][x] = 1;
                }
                // �����ʿ� ���� ���� ���
                else if(bo[y][x + 1] == 1 && !isBuilt(x + 1, y, 1)){
                    bo[y][x] = 1;
                }
                // �ش����� ������ ����. ���̹Ƿ� -2 ������.
                else build[y][x] -= 2;
            }
        }
    }

    // answer�� �ִ� ����
    for(int y = 0; y <= n; y++){
        for(int x = 0; x <= n; x++){
            //build�� 0�� �ƴ�, �� ���� ����̵� ���� ������ ���
            if(build[y][x] != 0){
                // ��ո� ���� ��� ���� answer�� ���� ��ǥ�� (x, y, 0)�� �־�����
                if(build[y][x] == 1){
                    vector<int> tmp;
                    tmp.push_back(x);
                    tmp.push_back(y);
                    tmp.push_back(0);
                    answer.push_back(tmp);
                }
                // ���� ���� ��� ���� answer�� ���� ��ǥ�� (x, y, 1)�� �־�����
                else if(build[y][x] == 2){
                    vector<int> tmp;
                    tmp.push_back(x);
                    tmp.push_back(y);
                    tmp.push_back(1);
                    answer.push_back(tmp);
                }
                // ���, �� �� �� ���� ��� ���� answer�� ���� ��ǥ�� (x, y, 0)�� (x, y, 1)�� �־�����
                else if(build[y][x] == 3){
                    vector<int> tmp;
                    tmp.push_back(x);
                    tmp.push_back(y);
                    tmp.push_back(0);
                    answer.push_back(tmp);
                    
                    vector<int> tmp2;
                    tmp2.push_back(x);
                    tmp2.push_back(y);
                    tmp2.push_back(1);
                    answer.push_back(tmp2);
                }
            }
        }
    }
    // �������� ����
    sort(answer.begin(), answer.end(), compare);
    
    return answer;
}
