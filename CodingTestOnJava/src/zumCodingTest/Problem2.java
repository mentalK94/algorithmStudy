package zumCodingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Problem2 {
	public static void main(String[] args) {
		Problem2Solution solution = new Problem2Solution();
		
		int a[] = {42, 33, 60};
		
		System.out.println(solution.solution(a));
	}
}

class Problem2Solution {
	
	public int solution(int[] a) {
		
		int answer = -1, k = 0;		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> answerList = new ArrayList<>();
		
		for(int i=0; i<a.length; i++) {
			k = digitsPlus(a[i]);		
			ArrayList<Integer> valueList = new ArrayList<>();			
			
			if(map.containsKey(k)) {
				valueList = map.get(k);
			}
			valueList.add(a[i]);
			map.put(k, valueList);
		}
				
		for(int key : map.keySet()) {
			Collections.sort(map.get(key), Collections.reverseOrder());
			
			if(map.get(key).size() >= 2) {
				answerList.add(map.get(key).get(0)+map.get(key).get(1));			
			}
		}
		
		if(answerList.size() == 0)
			return -1;
		
		Collections.sort(answerList, Collections.reverseOrder());
		answer = answerList.get(0);
		
		return answer;
		
	}
	
	public int digitsPlus(int number) {
		int n=0;
		
		while(number>0) {
			n+=number%10;
			number/=10;
		}
		
		return n;
	}
}