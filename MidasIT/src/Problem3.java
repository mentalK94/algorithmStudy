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
//            			tempBoard[k][t] = board[k][t];  // tempBoard�� ����
//            		}
//        		}
//        		        	        		
//    			// �ش� ��ǥ���� ��ġ���
//        		tempBoard[i][j] = 0;
//    			tempPoint++;
//    			
//    			// ��ġ ����� ���� ������ ������ ������ �����ϴ� ���
//    			int tempX = i;
//    			while(tempX>0) {
//    				board[tempX][j] = tempBoard[tempX-1][j];
//    				tempX--;
//    			}
//    			
//    			// ĵ�� ���Ű��� ����
//        		for(int k=0; k<board.length; k++) {
//            		for(int t=0; t<board.length; t++) {
//            			int isHorizontalPoint = 1; 
//            			int isVerticalPoint = 1;
//            			int candyType = tempBoard[k][t];
//            			
//            			// ���� ��ǥ ĵ�𿡼� ���� ���ɿ��� �ľ� -> ����, ����
//            			
//            			// ���� �˻�
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
//		// ���� �˻�
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
//		// ���� �˻�
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