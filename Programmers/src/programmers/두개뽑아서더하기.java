package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class 두개뽑아서더하기 {

	public static void main(String[] args) {
		두개뽑아서더하기 두개뽑아서더하기 = new 두개뽑아서더하기();
		int[] numbers = {5,0,2,7};
		System.out.println(Arrays.toString(두개뽑아서더하기.solution(numbers)));
	}
	
	public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0; i<numbers.length; i++) {
        	for(int j=0; j<numbers.length; j++) {
        		if(i!=j) {
        			int num = numbers[i] + numbers[j];
        			if(!set.contains(num)) {
        				set.add(num);
        				pq.add(num);
        			}
        		}
        	}
        }
        
        int[] answer = new int[set.size()];
        int idx=0;
        while(!pq.isEmpty()) {
        	answer[idx++] = pq.poll();
        }
        
        return answer;
    }

}
