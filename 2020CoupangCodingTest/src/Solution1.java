import java.util.ArrayList;

public class Solution1 {

	public static void main(String[] args) {
		Solution1 s1 = new Solution1();
		s1.soloution(14);
	}
	
	public int[] soloution(int N) {
		int[] answer = new int[2];
		int answerIdx = 0;
		int answerValue = 0;
		
		// 1. N값을 2~9진법으로 변환
		for(int i=2; i<=9; i++) {
			
			int temp = N;
			ArrayList<Integer> list = new ArrayList<>(); 
			
			while(temp>0) {
				list.add(temp%i);
				temp/=i;
			}
			
			int newN = 1;
			for(int j=0; j<list.size(); j++) {
				if(list.get(j) == 0) continue;
				newN *= list.get(j);
			}
			
			if(answerValue <= newN) {
				answerValue = newN;
				answerIdx = i;
			}
		}
		
		answer[0] = answerIdx;
		answer[1] = answerValue;
		System.out.println(answer[0] + " " + answer[1]);
		return answer;
	}

}
