package greedyAlgorithm;

public class LargeNumber {

	public static void main(String[] args) {
		LargeNumberSolution largeNumberSolution = new LargeNumberSolution();
		String number = "777777";
		int k = 4;
		System.out.println(largeNumberSolution.solution(number, k));

	}
}

class LargeNumberSolution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuffer stringBuffer = new StringBuffer();
        
        // 1. 총 길이 구하기
        int length = number.length();
        char temp = 0;
        int idx = 0;
        boolean flag = false;
        
        for(int i=0; i<length; ) {
        	temp = number.charAt(i);
        	if(k>0) {
	        	for(int j=i+1; j<length && j<i+1+k; j++) {
	        		if(temp < number.charAt(j)) {
	            		temp = number.charAt(j); 
	            		idx = j;
	            		flag = true;
	            	}
	        	}
	        	if(flag) {
	        		k -= (idx-i);
		        	i += (idx-i);
		        	flag = false;		        	
	        	}	        	  
        	}        	      	
        	
        	if(!flag) { i++; }
        	stringBuffer.append(temp);        	        	
        }
                
        if(k>0) {
        	return stringBuffer.substring(0, number.length()-k);
        }
        
        answer = stringBuffer.toString();
        return answer;
    }
}