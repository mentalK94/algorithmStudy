package programmers;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class 캐시 {

	public static void main(String[] args) {
		캐시 캐시 = new 캐시();
		String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		System.out.println(캐시.solution(3, cities));
	}
	
	static final int CACHE_HIT = 1;
	static final int CACHE_MISS = 5;
	
	public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Deque<String> dq = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        for(String city : cities) {
        	
        	city = city.toLowerCase();
        	// 캐시에 있는 경우
        	if(set.contains(city)) {
        		answer += CACHE_HIT;
        		Stack<String> st = new Stack<>();
        		while(!dq.peek().equals(city)) {
        			st.add(dq.pollFirst());
        		}
        		
        		dq.addLast(dq.poll()); // 해당 도시를 마지막에 넣기
        		
        		while(!st.isEmpty()) { // 기존에 뺏던 것들 다시 앞에서 부터 넣기
        			dq.addFirst(st.pop());
        		}
        		
        	} else { // 캐시에 없는 경우
        		answer += CACHE_MISS;        		
        		set.add(city);        		
        		dq.addLast(city);
        		if(dq.size() > cacheSize) {
        			String removeCity = dq.poll();
            		set.remove(removeCity);
        		}
        	}
        	
        }
        
        return answer;
    }

}
