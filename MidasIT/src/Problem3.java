//
//public class Problem3 {
//
//	public static void main(String[] args) {
//		
//		
//	}
//
//}
//
//class Problem3Solution {
//	static int point = 0;
//	
//	public int solution(int[][] board) {
//        int answer = 0;
//        int tempPoint = 0;
//        int tempBoard[][] = new int[board.length][board.length];
//		int dx[] = {-1, 1, 0, 0};
//		int dy[] = {0, 0, 1, -1};
//                                
//        for(int i=0; i<board.length; i++) {
//        	for(int j=0; j<board[i].length; j++) {
//        		
//        		tempPoint = 0;
//        		for(int k=0; k<board.length; k++) {
//            		for(int t=0; t<board.length; t++) {
//            			tempBoard[k][t] = board[k][t];  // tempBoard로 복사
//            		}
//        		}
//        		        	        		
//    			// 해당 좌표에서 망치사용
//        		tempBoard[i][j] = 0;
//    			tempPoint++;
//    			
//    			// 망치 사용한 곳에 위에서 떨어질 사탕이 존재하는 경우
//    			int tempX = i;
//    			while(tempX>0) {
//    				board[tempX][j] = tempBoard[tempX-1][j];
//    				tempX--;
//    			}
//    			
//    			// 캔디 제거과정 진행
//        		for(int k=0; k<board.length; k++) {
//            		for(int t=0; t<board.length; t++) {
//            			int isHorizontalPoint = 1; 
//            			int isVerticalPoint = 1;
//            			int candyType = tempBoard[k][t];
//            			
//            			// 현재 좌표 캔디에서 삭제 가능여부 파악 -> 가로, 세로
//            			
//            			// 세로 검사
//            			for(int n=0; n<2; n++) {
//            					
//            			}
//            			
//            		}
//        		}
//        	}
//        }
//        
//        
//		return answer;
//	}
//	
//	public int usingHammer(int x, int y, int [][] board) {
//		
//		int point = 0;
//		
//		
//		
//		
//		return point;
//	}
//	
//	public int breakCandy(int x, int y, int [][] board) {
//		int point = 0;
//		int candyType = board[x][y];
//		int dx[] = {-1, 1, 0, 0};
//		int dy[] = {0, 0, 1, -1};
//		boolean isPoint = false;
//		
//		// 세로 검사
//		for(int i=0; i<2; i++) {
//			int rx = x+dx[i];
//			int ry = y+dy[i];
//			
//			if(rx>=0 && ry<board.length && ry>=0 && ry < board.length) {
//				if(board[rx][ry] == candyType) {
//					if(i == 1) { isPoint = true; }
//				} else {
//					break;
//				}
//			} else { break;}
//		}
//		
//		
//		
//		// 가로 검사
//		for(int i=2; i<4; i++) {
//			int rx = x+dx[i];
//			int ry = y+dy[i];
//			
//			if(rx>=0 && ry<board.length && ry>=0 && ry < board.length) {
//				if(board[])
//			} else { break;}
//		}
//		
//		return point;
//	}
//	
//	
//	
//}