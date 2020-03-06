package programmers;

import java.util.HashMap;
import java.util.Set;

public class Camouflage {
	
	public static void main(String[] args) {
		SolutionCamouflage s = new SolutionCamouflage();
		
		String[][] clothes = {{"yellow_hat", "headgear"}, 
							  {"blue_sunglasses", "eyewear"},
							  {"green_turban", "headgear"}};
		int k = s.solution(clothes);
		System.out.println(k);
	}
	
}

class SolutionCamouflage {
    public int solution(String[][] clothes) {
    	
        int answer=1;
        HashMap<String, Integer> clothMap = new HashMap<>();                     
        
        for(int i=0; i<clothes.length; i++) {         	
        	if(clothMap.containsKey(clothes[i][1])) { // 해당 키가 해시에 존재하면
        		int clothCount = clothMap.get(clothes[i][1]);
        		clothMap.put(clothes[i][1], ++clothCount);
        	} else {
        		clothMap.put(clothes[i][1], 1);
        	}
        }     
        
        Set<String> keys = clothMap.keySet();
        
        for(String key:keys) {        	
        	answer *= (clothMap.get(key)+1); 
        }
        
        answer--;
        return answer;
    }
}