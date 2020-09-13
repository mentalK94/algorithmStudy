
public class Problem1 {

	public static void main(String[] args) {
		Problem1 p1 = new Problem1();
		int[][] boxes = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
		p1.solution(boxes);
	}
	
	public int solution(int[][] boxes) {
        int answer = boxes.length;
        int[][] productCnt = new int[1001][1001];
        
        // 1. boxes배열을 검사하여  counting
        for(int i=0; i<boxes.length; i++) {
        	for(int j=0; j<2; j++) {
        		int product = boxes[i][j];
        		if(product>1000) {
        			productCnt[product/1000][product%1000]++;
        		} else {
        			productCnt[0][product]++;
        		}
        	}
        }
        
        for(int i=0; i<1001; i++) {
        	for(int j=0; j<1001; j++) {
            	if(productCnt[i][j] == 2) {
            		answer--;
            	}
            }	
        }
        
        System.out.println(answer);
        return answer;
    }

}
