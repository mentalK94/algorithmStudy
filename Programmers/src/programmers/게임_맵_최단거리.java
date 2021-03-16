/**
 * programmers - 게임 맵 최단거리
 * 게임_맵_최단거리.java
 * @date 2021-03-16
 * @author hansolKim
 **/

package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

	static int N, M, answer;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        answer = -1;
        
        N = maps.length;
        M = maps[0].length;
        
        map = new int[N][M];
        for(int i=0; i<N; ++i) {
            map[i] = maps[i].clone();
        }
        
        bfs();
        return answer;
    }
    
    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();        
        q.add(new int[] {0,0,1});
        
        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int cnt = q.poll()[2];
            
            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny] == 0)  { continue; }
                
                if(nx == N-1 && ny == M-1) { 
                    answer = cnt+1;
                    return;
                }
                
                map[nx][ny] = 0;
                q.add(new int[] {nx, ny, cnt+1});
            }
        }
    }
}
