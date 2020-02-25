#include <stdio.h>

int main()
{

	int count, x, y;
	int baduk[20][20]={};
	
	for(int i=1; i<=19; i++) //한 줄씩 바둑판 상황 입력 받기
  		for(int j=1; j<=19; j++)
    		scanf("%d", &baduk[i][j]);
	
	
	scanf("%d", &count);
	
	for(int i=0; i<count; i++) {
		scanf("%d %d", &x, &y);
		
		for(int j=1; j<=19; j++) {
			if(baduk[x][j]==0) {
				baduk[x][j] = 1;
			} else {
				baduk[x][j] = 0;
			}
		}
		
		for(int k=1; k<=19; k++) {
			if(baduk[k][y]==0) {
				baduk[k][y] = 1;
			} else {
				baduk[k][y] = 0;
			}
		}
	}
	
	for(int i=1; i<=19; i++)  {//한 줄씩 바둑판 상황 입력 받기
  		for(int j=1; j<=19; j++) {
  			printf("%d ", baduk[i][j]);
		}
		printf("\n");
	}
	
	return 0;	
}

