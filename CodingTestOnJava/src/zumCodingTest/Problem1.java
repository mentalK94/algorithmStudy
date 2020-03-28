package zumCodingTest;

import java.util.ArrayList;
import java.util.Collections;

public class Problem1 {
	public static void main(String[] args) {
		Problem1Solution solution = new Problem1Solution();
		
		int a[] = {3,1,4,1,5};
		
		System.out.println(solution.solution(a));
	}
}

class Problem1Solution {
	
	public int solution(int[] a) {
		
		int answer = 0, value=0, count=0;
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<a.length; i++) {
			list.add(a[i]);
		}
		
		Collections.sort(list, Collections.reverseOrder());
		
		for(int i=0; i<list.size(); i++) {
			
			if (i == 0) {
				value = list.get(i);
				count++;
			}			
			
			if(value == list.get(i)) {				
				count++;
				if(value == count) { return value; }
			} else {
				count = 1;
				value = list.get(i);
			}
			
		}
		
		return 0;
		
	}
}