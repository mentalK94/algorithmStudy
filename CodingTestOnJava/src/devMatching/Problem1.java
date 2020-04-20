package devMatching;

public class Problem1 {

	public static void main(String[] args) {
		
		Problem1Solution problem1Solution = new Problem1Solution();
		String p="82195";
		String s="64723";
		System.out.println(problem1Solution.solution(p, s));

	}

}

class Problem1Solution {

	public int solution(String p, String s) {
		int answer = 0;
		int startLength = p.length();
		int idx = 0;
		char start, end;
		int k, t;
		
		
		while(idx < startLength) {			
			start = p.charAt(idx);
			end = s.charAt(idx);
			
			idx++;
			
			// 숫자가 같은경우
			if(start == end) {continue;}
			
			// 숫자가 다른경우 -> 정방향, 역방향 확인
			k = start-end;
			if(k<0) k*=-1;
			t = 10-k;
			if(t<0) t*=-1;
			answer += Math.min(k, t);
		}
		
		return answer;
	}
}