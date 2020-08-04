package kakao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Problem3 {

	public static void main(String[] args) {
		Problem3Solution problem3Solution = new Problem3Solution();
		String[] gems = {"zzz", "yyy", "nnnn", "yyy", "bbb"};		
		problem3Solution.solution(gems);
	}
}

class Problem3Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        int answerCnt = 0; 
        int cnt = 0;
        int minCnt = Integer.MAX_VALUE;
        int startIdx = 0;
        int endIdx = 0;
        boolean flag = false;
        
        Map<String, Integer> buyMap = new HashMap<>();
        HashSet<String> gemList = new HashSet<>(); 
        answer = new int[2];
        
        for(String gem : gems){
            gemList.add(gem);
        }
        
        answerCnt = gemList.size();

        for(int i=0; i<gems.length; i++) {
         	cnt = 0;      	
        	
        	if(buyMap.containsKey(gems[i])) { 
        		if(buyMap.get(gems[i]) >= 2) { 
        			buyMap.put(gems[i], buyMap.get(gems[i])-1);
        			continue;
        		}
        	}
        	
        	if(gems.length-i >= answerCnt) {
        		buyMap.clear();
	        	for(int j=i; j<gems.length; j++) {
	        		
	        		if(cnt >= minCnt) {
	        			flag = false;
	        			break;
	        		}
	        		
	        		if(!buyMap.containsKey(gems[j])) { 
	        			buyMap.put(gems[j], 1); 
	        		} else { 
	        			int v = buyMap.get(gems[j]);
	        			buyMap.put(gems[j], v+1);
	        		}
	            	cnt++; 	            	
	            	if(buyMap.size() == answerCnt) {
	            		startIdx = i;
	            		endIdx = j;
	            		flag = true;
	            		break;
	            	}        		
	            }
        	}
        	if(!flag) {
        		continue;
        	}
        	
        	if(cnt != 0 && minCnt > cnt && flag) {
        		minCnt = cnt;
        		answer[0] = startIdx+1;
        		answer[1] = endIdx+1;
        	}
        }
        
        return answer;
    }
}