import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {
		
	}

	public int solution(int[] A) {
		Arrays.sort(A);
		
		int answer = 0;
		for(int i=0; i<A.length; i++) {
			answer += (Math.abs(A[i]-(i+1)));
		}
		
		return answer;
	}
}
