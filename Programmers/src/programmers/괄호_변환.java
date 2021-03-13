/**
 * programmers - 괄호_변환
 * 괄호_변환.java
 * @date 2021-03-13
 * @author hansolKim
 **/

package programmers;

public class 괄호_변환 {

	public static void main(String[] args) {
		괄호_변환 괄호_변환 = new 괄호_변환();		
		System.out.println(괄호_변환.solution(")("));
	}
	
	static int pos;

	public String solution(String p) {

		if (p.isEmpty()) {
			return p;
		}

		StringBuilder answer = new StringBuilder();
		boolean isCorrect = separate(p);
		String u = p.substring(0, pos);
		String v = p.substring(pos, p.length());

		if (isCorrect) {
			answer.append(u).append(solution(v));
			return answer.toString();
		}

		answer.append("(").append(solution(v)).append(")");
		for (int i = 1; i < u.length() - 1; ++i) {
			if (u.charAt(i) == '(') {
				answer.append(")");
			}
			if (u.charAt(i) == ')') {
				answer.append("(");
			}
		}
		return answer.toString();
	}

	// 올바른 문자열 확인 메서드
	private static boolean separate(String str) {
		int openCnt = 0;
		int closeCnt = 0;
		boolean result = true;
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == '(') {
				++openCnt;
			}
			if (str.charAt(i) == ')') {
				++closeCnt;
			}
			if (openCnt < closeCnt) {
				result = false;
			}
			if (openCnt == closeCnt) {
				pos = i + 1;
				return result;
			}
		}

		return result;
	}   
}