/**
 * programmers - JadenCase 문자열 만들기
 * JadenCase.java
 * @date 2021-03-06
 * @author hansolKim
 **/

package programmers;

public class JadenCase {

	public static void main(String[] args) {
		JadenCase jadenCase = new JadenCase();
		System.out.println(jadenCase.solution("a  b"));
	}
	
	public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean isFirst = true; // 대문자인지 확인
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if(isFirst && c != ' ') { // 첫 글자인 경우
        		isFirst = false;
        		if(c>=97 && c<=122) {
        			c-=32;
        		}
        	} else { // 첫 글자가 아닌 경우
        		// 공백인 경우
        		if(c == ' ') { isFirst = true;}
        		if(c>=65 && c<=90) { c+=32; }
        	}
        	sb.append(c);
        }
        
        return sb.toString();
    }

}
