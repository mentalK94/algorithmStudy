import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Solution2 {

	public static void main(String[] args) {
		Solution2 s2 = new Solution2();
		String str = "ZzZz9Z824&*****";
		s2.solution(str );
	}
	
	final static int LEN = 127;
	
	public int[] solution(String inp_str) {
        ArrayList<Integer> answerList = new ArrayList<>();
        
        Stack<Character> st = new Stack<>();
        st.add('.');
        
        // 1. password길이 검사
        if(inp_str.length() < 8 || inp_str.length() > 15) { answerList.add(1); }
        int[] cnt = new int[LEN];
        boolean[] group = new boolean[4]; // 4개의 그룹 확인
        boolean check_2 = false;
        boolean check_4 = false;
        
        for(int i=0; i<inp_str.length(); ++i) {
        	char c = inp_str.charAt(i);
        	
        	if(c>=48 && c<=57) { // 대문자
        		group[0] = true;
        	} else if(c>=65 && c<=90) { // 소문자
        		group[1] = true; 
        	} else if(c>=97 && c<=122) { // 숫자
        		group[2] = true; 
        	} else if(c>=33 && c<=38 || c==42 || c==64 || c==94 || c==126) { // 특수문자
        		group[3] = true; 
        	} else { // 2. 허용문자가 아닌 문자가 있는 경우
        		if(!check_2) {
        			check_2 = true;
        			answerList.add(2);
        		}
        	}
        	
        	cnt[c]++;
        	
        	if(!check_4) {
        		if(st.peek() == c) {
        			st.push(c);
        			if(st.size() >= 4) { // 4개 이상 연속된 경우
        				check_4 = true;
        				answerList.add(4);
        				st.clear();
        			}
        		} else {
        			st.clear(); // 이전 것들 전부 비움
        			st.push(c); // 현재 문자 삽입
        		}
        	}
        }
        
        // 3. 3종류 이상을 포함하고 있는지 확인
        int groupCnt = 0;
        for(int i=0; i<4; ++i) {
        	groupCnt += (group[i] ? 1 : 0);
        }
        
        if(groupCnt < 3) { answerList.add(3); } 
        
        // 5. 같은 문자가 5개 이상 포함되어 있는 지 확인
        for(int i=0; i<LEN; ++i) { 
        	if(cnt[i]>=5) {
        		answerList.add(5);
        		break;
        	}
        }
        
        int[] answer;
        if(answerList.size() > 0) {
        	Collections.sort(answerList);
            answer = new int[answerList.size()];
            int idx = 0;
            for(int ans : answerList) {
            	answer[idx++] = ans; 
            }
        } else {
        	answer = new int[1];
        	answer[0] = 0;
        }
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
