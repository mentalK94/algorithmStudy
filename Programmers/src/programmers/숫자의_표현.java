/**
 * programmers - 숫자의_표현
 * 숫자의_표현.java
 * @date 2021-03-09
 * @author hansolKim
 **/

package programmers;

public class 숫자의_표현 {

	public static void main(String[] args) {
		숫자의_표현 숫자의_표현 = new 숫자의_표현();
		숫자의_표현.solution(21);
	}

	public int solution(int n) {
        int answer = 0;
        
        int seed = 0;
        int sum = 0;
        while(sum < n) {
        	++seed;
        	sum += seed;        	
        }
        
        if(sum == n) { answer++;}
        
        while(--seed > 0) {
        	sum = 0;
        	for(int i=1; i<=seed; ++i) { sum += i; }
        	
        	while(sum < n) {
        		sum += seed;
        	}
        	
        	if(sum == n) { answer++; }        	
        }
        System.out.println(answer);        
        return answer;
    }
}
