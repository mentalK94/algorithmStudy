package programmers;

public class JadenCase {

	public static void main(String[] args) {
		JadenCase jadenCase = new JadenCase();
		System.out.println(jadenCase.solution("       3peon 6ple  unFollowed me  "));
	}
	
	public String solution(String s) {
        
		StringBuilder sb = new StringBuilder();
		
		boolean isFirst = true;
		for(int i=0; i<s.length(); i++) {
			String now = s.charAt(i) + "";
			
			if(now.contains(" ")) { // 빈 공백 문자인 경우
				isFirst = true;
				sb.append(now);
			} else { // 일반 문자인 경우
				if(isFirst) { // 첫 글자인 경우
					sb.append(now.toUpperCase());
					isFirst = false;
				} else { // 두번째 이상의 글자인 경우
					sb.append(now.toLowerCase());
				}
			}
		}
        
        return sb.toString();
    }

}
