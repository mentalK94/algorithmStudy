import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {

	public static void main(String[] args) {
		Problem2 p2 = new Problem2();
		int[] ball = {1,2,3,4,5,6};
		int[] ball2 = {11, 2, 9, 13, 24};
		int[] order = {6,2,5,1,4,3};
		int[] order2 = {9, 2, 13, 24, 11};
		p2.solution(ball2, order2);
	}
	
	public int[] solution(int[] ball, int[] order) {
        int[] answer = new int[ball.length];
        int answerIdx = 0;
        int leftIdx = 0;
        int rightIdx = ball.length-1;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<order.length; i++) {
        	
        	// 1. 공을 뺄 수 있는지 없는 지 양 끝 조사 -> 뺄 수 있다면 answer에 값 삽입 후 idx변경  -> 빼고나서 해당 위치 값이 큐에 존재한다면 진행
        	if(order[i] == ball[leftIdx]) {
        		
        		answer[answerIdx++] = ball[leftIdx];
        		leftIdx++;
        		
        		if(!q.isEmpty()) {
        			while(q.contains(ball[leftIdx])) { // 대기 큐에 존재한다면
            			answer[answerIdx++] = ball[leftIdx];
            			q.remove(ball[leftIdx]);
            			leftIdx++;
            		}
        		}
        		
        	} else if(order[i] == ball[rightIdx]) {
        		answer[answerIdx++] = ball[rightIdx];
        		rightIdx--;
        		
        		if(!q.isEmpty()) {
        			while(q.contains(ball[rightIdx])) { // 대기 큐에 존재한다면
            			answer[answerIdx++] = ball[rightIdx];
            			q.remove(ball[rightIdx]);
            			rightIdx--;
            		}
        		}	        		
        	} else { // 2. 뺄 수 없다면 대기queue에 삽입
        		q.offer(order[i]);
        	}
     	
        }
        
        return answer;
    }

}
