/**
 * programmers - 괄호_변환
 * 괄호_변환.java
 * @date 2021-03-11
 * @author hansolKim
 **/

package programmers;

import java.util.StringTokenizer;

public class 괄호_변환 {

	public static void main(String[] args) {
		괄호_변환 괄호_변환 = new 괄호_변환();
		괄호_변환.solution("()))())((())((");
	}
	
    static StringBuilder answer;
    public String solution(String p) {
        answer = new StringBuilder();
        
        StringBuilder sb = new StringBuilder();
                
        makeStr(p, sb, true);
        
        System.out.println(answer);
        return answer.toString();
    }
    
    private static String makeStr(String str, StringBuilder builder, boolean mode) {    	
        StringTokenizer st = new StringTokenizer(separateString(str), ":");        
        if(st.countTokens() == 0) { return ""; }
        String u = st.nextToken();
        String v = st.nextToken();
        
        v = v.equals("A") ? "" : v;
        
        if(isRight(u)) {
        	if(mode) {
        		answer.append(u);
        	}
            builder.append(u);
            makeStr(v, builder, true);
        } else { // u가 올바른 괄호 문자열이 아닌 경우
            String modify = modifyStr(u, v);
            if(mode) {
        		answer.append(modify);
        	}
            builder.append(modify);
        }
        
        return builder.toString();
    }
    
    private static String separateString(String str) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(str.equals("")) { return ""; }
        
        // 2. 균형잡힌 괄호 문자열 u, v로 분리합니다.
        StringBuilder sb = new StringBuilder();
        
        int openCnt = 0;
        int closeCnt = 0;
        int idx = 0;
        for(idx = 0; idx<str.length(); ++idx) {                        
            if(str.charAt(idx) == '(') { ++openCnt; }
            if(str.charAt(idx) == ')') { ++closeCnt; }            
            if(openCnt == closeCnt) { break; }
        }
        
        sb.append(str.substring(0, idx+1)); // u
        sb.append(":"); // 구분자
        if(idx+1 < str.length()) {
        	sb.append(str.substring(idx+1, str.length())); // v
        } else {
        	sb.append("A"); // v
        }
        
        return sb.toString();
    }
    
    // 올바른 문자열 확인 메서드
    private static boolean isRight(String str) {
        int openCnt = 0;
        int closeCnt = 0;
        for(int i=0; i<str.length(); ++i) {
            if(str.charAt(i) == '(') { ++openCnt; }
            if(str.charAt(i) == ')') { ++closeCnt; }            
            if(openCnt < closeCnt) { return false; }
        }
        
        return true;
    }
    
    // 올바른 문자열이 아닌 경우 수행
    private static String modifyStr(String u, String v) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append("(");
        sb.append(makeStr(v, sb2, false));
        sb.append(")");
        for(int i=0; i<u.length(); ++i) {
            if(i == 0 || i == u.length()-1) { continue; }
            if(u.charAt(i) == '(') {sb.append(")");}
            if(u.charAt(i) == ')') {sb.append("(");}
        }
        
        return sb.toString();
    }

}
