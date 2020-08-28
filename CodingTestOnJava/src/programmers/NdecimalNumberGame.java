/**
 * programmers - 2018 카카오 블라인드 채용. N진수 게임
 * NdecimalNumberGame.java
 * @date 2020-08-28
 * @author hansolKim
 **/

package programmers;

import java.util.ArrayList;

public class NdecimalNumberGame {

	public static void main(String[] args) {
		NdecimalNumberGame game = new NdecimalNumberGame();
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		game.solution(n, t, m, p);
	}
	
	public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        
        sb.append(0); // 0부터 말하기 때문에
        
        // 1. 1~t까지의 숫자를 n진수의 형태로 모두 만든 후 String으로 저장한다.
        for(int num=1; ; num++) {
        	int temp = num;
        	
        	// 1-1. n진수 만드는 방법 : 해당 숫자를 n으로 나누면서 나머지 값을 저장한다.
        	
        	if (n == 2) { // 2진수인 경우
        		sb.append(Integer.toBinaryString(num));
        	} else { // 2진수를 제외한 n진수인 경우
        		while(temp > 0) {
            		list.add(temp%n); // 나머지 저장
            		temp /= n;
            	}
            	
            	// 저장된 숫자들을 역순으로 하면 n진수 형태 완성
            	for(int i=list.size()-1; i>=0; i--) {
            		if(list.get(i) >= 10) {
            			sb.append((char)(55+list.get(i)));
            		} else {
            			sb.append(list.get(i));	
            		}
            	}
            	
            	list.clear();
        	}
        	
        	if(sb.length() >= m*t) { break;}
        }
        
        // System.out.println(sb);
        
        // 2. 순서를 돌면서 튜브차례의 숫자를 정답 스트링에 저장한다.
        if(m==p) { p=0;}
        
        for(int i=0; i<sb.length(); i++) {
        	if((i+1)%m == p) {
        		answer.append(sb.charAt(i));
        	}
        	if(answer.length() == t) {
        		break;
        	}
        }
        
        System.out.println(answer);
        return answer.toString();
    }

}
