package monthCodeChallenge;

import java.util.Arrays;

public class Programming3 {

	public static void main(String[] args) {
		Programming3 p3 = new Programming3();
		int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		p3.solution(a);
	}

	public int solution(int[] a) {
        int answer = a.length;
        
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        int rightIdx = 0;
        
        // 좌우에 자기보다 작은 값이 있는 지 확인
        for(int i=0; i<a.length; i++) {
        	
        	int v = a[i];
        	boolean left = false;
        	boolean right = false;
        	
        	// 왼쪽 값중에 본인 값보다 작은 풍선이 있는 지 확인
        	if(leftMin > v) {
        		leftMin = v;
        	} else {
        		left = true;
        	}
        	
        	int idx = i;
        	
        	if(i < rightIdx && v > rightMin) {
        		right = true;
        	} else {
        		while(++idx<a.length) {
            		if(v > a[idx]) {
            			rightIdx = idx;
            			rightMin = a[idx];
            			right = true;
            			break;
            		}
            	}
        	}
        	
        	if(left && right) {
        		answer--;
        		while(++i <= a.length) {
        			if(v<a[i]) { answer--;}
        			else break;
        		}
        		i--;
        	}
        	
        }
        
        // System.out.println(answer);
        return answer;
    }
}
