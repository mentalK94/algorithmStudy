package kakao;
/**
 * ���� ����
kakao_road1.png

�Ǽ�ȸ���� ������� �Ҹ���� ����κ��� �ڵ��� ���ַ� �Ǽ��� �ʿ��� ������ �Ƿڹ޾ҽ��ϴ�.
������ ���ַ� ���� ���鿡 ������ ���ַ� ������ N x N ũ���� ���簢�� ���� �����̸� �� ���ڴ� 1 x 1 ũ���Դϴ�.
���� ���鿡�� �� ������ ĭ�� 0 �Ǵ� 1 �� ä���� ������, 0�� ĭ�� ��� ������ 1�� �ش� ĭ�� ������ ä���� ������ ��Ÿ���ϴ�.
���ַ��� ������� (0, 0) ĭ(���� ���)�̸�, �������� (N-1, N-1) ĭ(���� �ϴ�)�Դϴ�. �Ҹ���� ������� (0, 0) ĭ���� ����� �ڵ����� �������� (N-1, N-1) ĭ���� ������ ������ �� �ְ� �߰��� ������ �ʵ��� ���ַθ� �Ǽ��ؾ� �մϴ�.
���ַδ� ��, ��, ��, ��� ������ �� �� ĭ�� �����Ͽ� �Ǽ��� �� ������, ���� �ִ� ĭ���� ���ַθ� �Ǽ��� �� �����ϴ�.
�̶�, ������ �� �� ĭ�� ���� �Ǵ� �¿�� ������ ���ַθ� ���� ���� ��� �մϴ�.
���� �� ���� ���ΰ� ���� �������� ������ ������ �ڳ� ��� �θ��ϴ�.
�Ǽ� ����� ����� ���� ���� ���� �ϳ��� ���� ���� 100���� �ҿ�Ǹ�, �ڳʸ� �ϳ� ���� ���� 500���� �߰��� ��ϴ�.
�Ҹ���� ������ �ۼ��� ���� ���ַθ� �Ǽ��ϴ� �� �ʿ��� �ּ� ����� ����ؾ� �մϴ�.

���� ���, �Ʒ� �׸��� ���� ���� 6���� �ڳ� 4���� ������ ������ ���ַ� �����̸�, �Ǽ� ����� 6 x 100 + 4 x 500 = 2600�� �Դϴ�.

kakao_road2.png

�� �ٸ� ����, �Ʒ� �׸��� ���� ���� 4���� �ڳ� 1���� ������ ���ַ��̸�, �Ǽ� ����� 4 x 100 + 1 x 500 = 900�� �Դϴ�.

kakao_road3.png

������ ����(0�� ��� ����, 1�� ��)�� ��Ÿ���� 2���� �迭 board�� �Ű������� �־��� ��, ���ַθ� �Ǽ��ϴµ� �ʿ��� �ּ� ����� return �ϵ��� solution �Լ��� �ϼ����ּ���.

[���ѻ���]
board�� 2���� ���簢 �迭�� �迭�� ũ��� 3 �̻� 25 �����Դϴ�.
board �迭�� �� ������ ���� 0 �Ǵ� 1 �Դϴ�.
������ ���� ���� ��� ��ǥ�� (0, 0)�̸�, ���� ���� �ϴ� ��ǥ�� (N-1, N-1) �Դϴ�.
������ �� 0�� ĭ�� ��� �־� ���� ������ �������� 1�� ĭ�� ������ ä���� �־� ���� ������ �Ұ������� ��Ÿ���ϴ�.
board�� �׻� ��������� ���������� ���ַθ� �Ǽ��� �� �ִ� ���·� �־����ϴ�.
������� ������ ĭ�� ������ ���� �׻� 0���� �־����ϴ�.
����� ��
board	result
[[0,0,0],[0,0,0],[0,0,0]]	900
[[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]]	3800
[[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]	2100
[[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[0,1,0,0,0,1],[0,0,0,0,0,0]]	3200
����� ���� ���� ����
����� �� #1

������ ���ÿ� �����ϴ�.

����� �� #2

kakao_road4.png

���� ���� ���ַθ� �Ǽ��ϸ� ���� ���� 18��, �ڳ� 4���� �� 3800���� ��ϴ�.

����� �� #3

kakao_road5.png

���� ���� ���ַθ� �Ǽ��ϸ� ���� ���� 6��, �ڳ� 3���� �� 2100���� ��ϴ�.

����� �� #4

kakao_road6.png

������ ��ο� ���� ���ַθ� �Ǽ��ϸ� ���� ���� 12��, �ڳ� 4���� �� 3200���� ��ϴ�.
����, �Ķ��� ��ο� ���� ���ַθ� �Ǽ��Ѵٸ� ���� ���� 10��, �ڳ� 5���� �� 3500���� ���, �� ���� ����� ��ϴ�.
 
 * 
 * 
 * */
public class Problem4 {

	public static void main(String[] args) {
		Problem4Solution problem4Solution = new Problem4Solution();
		
		int [][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},
				{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		
		problem4Solution.solution(board);
	}

}


class Problem4Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int [][] cost = new int [board.length][board.length];
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
            	cost[i][j] = 100000000;
            }
        }
        
        cost[0][0] = 0;
        
        dfs(0, 0, 0, cost, board);
        dfs(0, 0, 1, cost, board);
        
//        for(int i=0; i<board.length; i++) {
//            for(int j=0; j<board.length; j++) {
//            	System.out.printf("%-11d", cost[i][j]);
//            }
//            System.out.println();
//        }
//        
        
        answer = cost[board.length-1][board.length-1];
       
        
        return answer;
    }
    
    
    public void dfs(int x, int y, int direction, int[][] cost, int[][] board) { // direction 0:���ι���, 1:���ι���
    	
    	int dx[] = {0, 1, 0, -1};
    	int dy[] = {1, 0, -1, 0};
    	
    	// 1. ������ �����Ѱ��
    	if(x == cost.length-1 && y == cost.length-1) {
    		return;
    	}
    	
    	for(int i=0; i<4; i++) { // i�� 0�̸� ���� i�� 1�̸� ����
    		
    		int rx = x+dx[i];
    		int ry = y+dy[i];
    		
    		// System.out.println(i+" : "+rx +", " + ry + " / " + direction);
    		
    		if(rx < board.length && ry < board.length && rx >= 0 && ry >= 0) { // ���ַθ� ����� �ʴ� ���
    			if(board[rx][ry] == 0) { // ���� �ƴ� ���
    				if(i%2 == direction) { // ���� �����ΰ��
    					
    					int a = cost[rx][ry];
    					int b = cost[x][y]+100;
    					if(a >= b) {
    						cost[rx][ry] = b;
    						dfs(rx, ry, i%2, cost, board);
    					}
    					
    				} else { // �ڳ��� ���
    					
    					int a = cost[rx][ry];
    					int b = cost[x][y]+600;
    					if(a >= b) {
    						cost[rx][ry] = b;
    						dfs(rx, ry, i%2, cost, board);
    					}
    				}
    			}
    		}
    	}

    }
}