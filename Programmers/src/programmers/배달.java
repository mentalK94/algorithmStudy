/**
 * programmers - 배달
 * 배달.java
 * @date 2021-03-18
 * @author hansolKim
 **/

package programmers;

public class 배달 {

	static int[][] g;
    static int[] dists;
    static boolean[] visited;
    final static int INF = 10000000;
    static int size;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        size = N;

        g = new int[N+1][N+1];
        
        for(int i=1; i<=N; ++i) {
            for(int j=1; j<=N; ++j) {
                g[i][j] = INF;
            }
        }
        
        for(int i=0; i<road.length; ++i) {
            int x = road[i][0];
            int y = road[i][1];
            int dist = g[x][y] < road[i][2] ? g[x][y] : road[i][2];
            
            g[x][y] = dist;
            g[y][x] = dist;
        }
        
        dists = new int[N+1];
        int start = 1;
        
        for(int i=1; i<=N; ++i) {
            dists[i] = g[start][i];
        }
               
        visited = new boolean[N+1];        
        
        dists[start] = 0;
        
        for(int i=0; i<N-1; ++i) {
            int idx = getMinIdx(); // 최소 idx            
            visited[idx] = true;
            for(int j=1; j<=N; ++j) {
                if(!visited[j]) {
                    if(dists[idx] + g[idx][j] < dists[j]) {
                        dists[j] = dists[idx] + g[idx][j];
                    }
                }                
            }

        }
        
        for(int i=1; i<=N; ++i) {
            if(dists[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static int getMinIdx() {
        int dist = INF;
        int idx = 0;
        for(int i=1; i<=size; ++i) {            
            if(!visited[i] && dists[i] < dist) {
                dist = dists[i];
                idx = i;
            }
        }
        
        return idx;
    }

}
