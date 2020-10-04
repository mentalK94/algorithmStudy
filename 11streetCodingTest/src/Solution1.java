public class Solution1 {

	public static void main(String[] args) {
		Solution1 s1 = new Solution1();
		System.out.println(s1.solution("aaa"));
	}

	
	public int solution(String S) {
		
		int aCnt = 0;
		int answer = 0;
		
		for(int i=0; i<S.length(); i++) {
			// a인 경우
			if(S.charAt(i) == 'a') {
				aCnt++;
				if(aCnt >= 3) { // a가 연속 3개 이상인 경우
					return -1;
				}
			} else { // a가 아닌 경우
				answer += (2-aCnt);
				aCnt = 0;
			}
		}
		
		if(S.charAt(S.length()-1) != 'a') {
			answer += 2;
		}
		
		return answer;
	}
}