import java.util.StringTokenizer;

public class Problem1 {

	public static void main(String[] args) {
		Problem1 p1 = new Problem1();
		//p1.solution("...!@BaT#*..y.abcdefghijklm");
		// p1.solution("z-+.^.");
		p1.solution("z-+.^.");
		//p1.solution("123_.def");
		// p1.solution("....................1");
	}

	private static final int MIN_LIMIT = 3;
	private static final int MAX_LIMIT = 15;
	
	public String solution(String new_id) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		
		// 1단계 : 대문자 -> 소문자 치환
		sb.append(new_id.toLowerCase());
		
		// 2단계 : .-_ 소문자 숫자 제외 모든문자 제거
		StringTokenizer st = new StringTokenizer(sb.toString(), "/~!@#$%^&*()=+[{]}:?,<>");
		sb.setLength(0);
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken());
		}
		
		// 3단계 : 연속된 마침표 한개로 사용
		for(int i=0; i<sb.length()-1; i++) {
			// 만약 현재 문자가 .이라면
			if(sb.charAt(i) == '.' && sb.charAt(i+1) == '.') {
				sb.replace(i, i+1, "");
				i--;
			}
		}
		
		
		// 4단계 : 처음과 끝에 .(마침표가 있다면 제거)
		if(sb.length() > 0 && sb.charAt(0) == '.') {
			sb.replace(0, 1, "");
		}

		if(sb.length() > 0 && sb.charAt(sb.length()-1) == '.') {
			sb.replace(sb.length()-1, sb.length(), "");
		}

		// 5단계 : 빈 문자열인 경우 a로 채움
		if(sb.length() == 0) {
			sb.append("a");
		}
		
		// 6단계 : 16자 이상인 경우 15자 까지 만들고 제거
		if(sb.length() > MAX_LIMIT) {
			sb.replace(MAX_LIMIT, sb.length(), "");
			if(sb.charAt(MAX_LIMIT-1) == '.') {
				sb.replace(MAX_LIMIT-1, MAX_LIMIT, "");
			}
		}
		
		// 7단계 : 아이디의 길이가 2자 이하이면 마지막 글자를 이용해서 3자 채움
		if(sb.length() < MIN_LIMIT) {
			char lastChar = sb.charAt(sb.length()-1);
			while(sb.length() < MIN_LIMIT) {
				sb.append(lastChar);
			}
		}
		
		answer = sb.toString();
		System.out.println(answer);		
		return answer;
	}
}
