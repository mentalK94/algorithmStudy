
public class Solution1 {

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		String m = "acbbcdc";
		String k = "abc";
		System.out.println(solution1.solution(m, k));
	}

	public String solution(String m, String k) {
		
		StringBuilder sb = new StringBuilder();
		
		int keyIdx = 0;
		
		for(int i=0; i<m.length(); i++) {
			
			// 두개의 문자가 같은 경우
			if(keyIdx < k.length() && k.charAt(keyIdx) == m.charAt(i)) {
				keyIdx++;
				continue;
			}
			sb.append(m.charAt(i));
		}
		
		return sb.toString();
	}
}
