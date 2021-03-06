/**
 * programmers - 월간 코드 챌린지 시즌 1. 삼각달팽이
 * 삼각달팽이.java
 * @date 2021-03-06
 * @author hansolKim
 **/

package programmers;

import java.util.Arrays;

public class 삼각달팽이 {

	public static void main(String[] args) {
		삼각달팽이 삼각달팽이 = new 삼각달팽이();
		삼각달팽이.solution(6);
	}
	
	public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        int dir = 0;
        int cnt = 0;
        int x = 0;
        int y = 0;
        while(++cnt <= n*(n+1)/2) {
        	
        	arr[x][y] = cnt;
        	
        	x += dx[dir];
        	y += dy[dir];
        	// 해당 위치가 방문한 곳이거나 범위를 넘었다면
        	if(x<0 || x>=n || y<0 || y>=n || arr[x][y] != 0) {
        		x -= dx[dir];
            	y -= dy[dir];
        		dir = (dir+1)%3;
        		x += dx[dir];
            	y += dy[dir];
        	}        	
        }
        
        int[] answer = new int[n*(n+1)/2];
        int idx = 0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<i+1; j++) {
        		answer[idx++] = arr[i][j];
        	}        	
        }
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }

}
