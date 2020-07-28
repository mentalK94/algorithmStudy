package programmers;

import java.util.Arrays;

public class LargestSquare {
	static int width;
    static int height;
    
    public int solution(int [][]board)
	    {
	        int answer = 0;

	        int dx[] = {-1, -1, 0};	        
	        int dy[] = {-1, 0, -1};
            int[] minArr = new int[3];
            height = board.length;
            width = board[0].length;
	        	        
	        for(int x=0; x<height; x++) {
	        	for(int y=0; y<width; y++) {
		        	
	        		if(board[x][y] != 0) {
                        for(int i=0; i<3; i++) {
	        			
                            int rx = x+dx[i];
                            int ry = y+dy[i];	        			

                            if(isInArr(rx, ry)) {
                                minArr[i] = board[rx][ry];
                            } else {
                                minArr[i] = 0;
                            }

                        }
	        		
                        Arrays.sort(minArr);

                        board[x][y] = minArr[0]+1;
                        answer = Math.max(answer, minArr[0]+1);
                    }
		        }
	        }

	        return answer*answer;
	    }

	private boolean isInArr(int rx, int ry) {
		return (rx>=0 && rx<height && ry>=0 && ry<width) ? true: false;
	}
}
