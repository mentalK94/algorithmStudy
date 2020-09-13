package monthCodeChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Programming1 {

	public static void main(String[] args) {
		Programming1 p1 = new Programming1();
		int[] numbers = {5,0,2,7};
		p1.solution(numbers );
	}

	public int[] solution(int[] numbers) {
		int[] answer = {};
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<numbers.length-1; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				int num = numbers[i] + numbers[j];
				set.add(num);
			}
		}
		
		answer = new int[set.size()];
		int idx = 0;
		for(int value : set) {
			answer[idx++] = value;
		}
		
		Arrays.sort(answer);
		
		return answer;
	}
}
