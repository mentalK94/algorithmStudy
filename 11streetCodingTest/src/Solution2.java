
public class Solution2 {

	public static void main(String[] args) {

	}
	
	public int[] solution(String[] S) {
		int[] answer = {};
		
		int M = S[0].length(); // 문자열의 길이
		int N = S.length; // 문자열의 개수
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N-1; j++) {
				for(int k=j+1; k<N; k++) {
					if(S[j].charAt(i) == S[k].charAt(i)) {
						answer = new int[3];
						answer[0] = j;
						answer[1] = k;
						answer[2] = i;
						break;
					}
				}
			}
		}
		
		return answer;
	}

}