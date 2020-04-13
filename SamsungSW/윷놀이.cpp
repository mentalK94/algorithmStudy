#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <algorithm>
#include <vector>
using namespace std;
int dice[11];
struct info {
   int pos, score, f;
};
int maxres = 0;
int route[4][52] = {
   { 0, 2, 4, 6, 8, 10, 13, 16, 19, 25,
30,35,40,0,0 ,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0}
,{ 0,2,4,6,8, 10,12,14,16,18,
20,22,24,25,30, 35,40,0,0,0 ,0,0,0,0,0 ,0,0,0,0,0 , 0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0}
,{ 0,2,4,6,8, 10,12,14,16,18,
20,22,24,26,28, 30,28,27,26,25, 30,35,40,0,0, 0,0,0,0,0 , 0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0}
,{ 0,2,4,6,8, 10,12,14,16,18,
20,22,24,26,28, 30,32,34,36,38, 40,0,0,0,0 ,0,0,0,0,0 , 0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0}
} ;

vector<info> v;

int check[11];

int cntScore() {
   int cnt = 0;
   for (int i = 0; i < 4; i++)
      cnt += v[i].score;
   return cnt;
}

void dfs(int cnt,int pos[4],int flag[4],int score) {
   if (cnt >= 10) {
      maxres = max(score, maxres);
      return;
   }
   int tomove = dice[cnt];  // 1, 2, 3, 4, 1 ...
   cout << endl << cnt << endl; // cnt : 0, 1, 2 ... 
   for (int i = 0; i < 4; i++)
   {
      bool isOk = true;
      int nextPos = pos[i] + tomove;
      int nflag = flag[i];
      cout << i<< endl;
      if (route[nflag][nextPos] == 0) continue;
      
      if (flag[i] == 3) {
         if (nextPos == 5) {
            nflag = 0;
         }
         else if (nextPos == 10) {
            nflag = 1;
         }
         else if (nextPos == 15) {
            nflag = 2;
         }
      }
      //겹치는 말 검사
      for (int j = 0; j < 4; j++)
      {
         if (i == j) continue;
         if (nflag==flag[j] && nextPos == pos[j])
         {
            isOk = false;
            break;
         }
      }

      if (isOk) {
         //cout << i << ' ' << pos[i] << ' ' << flag[i] << ' ' << score << endl;
         flag[i] = nflag;
         pos[i] = nextPos;
         dfs(cnt + 1, pos, flag, score += route[flag[i]][nextPos]);
      }
      
   }
}


int main() {
   for (int i = 0; i < 10; i++)
      cin >> dice[i];
   int ary[4] = { 0,0,0,0 };
   int flag[4] = { 3,3,3,3 };
   dfs(0,ary,flag,0);
   cout << maxres;
   while (1);
   return 0;
}
