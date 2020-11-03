package programmers;

public class Level2_ex1 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int equalsCount = 0;
        
        int dx[] = {0, 1, 1};
        int dy[] = {1, 0, 1};
        
        boolean isChecked[][] = null;
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
            	isChecked[i][j] = false;
            }
        }
         
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                
                char block = board[i].charAt(j);
                
                for(int k=0; k<3; k++) {
                    
                    int rx = i+dx[k];
                    int ry = j+dy[k];
                    
                    if(rx < m && ry < n) {
                    	if(block == board[rx].charAt(ry)) {
                    		equalsCount++;
                    	}
                    }
                }
                
                if(equalsCount == 3) {
                	isChecked[i][j] = true;
                }
                
                equalsCount = 0;
            }
        }
        return answer;
    }
}
