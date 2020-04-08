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
        StringBuilder stringbuilder = new StringBuilder();
        
        // 1. �� ���� ���ϱ�
        int length = number.length();
        char temp = 0;
        int idx = 0;
        boolean flag = false;

        for(int i=0; i<length && length-i>k; ) {
        	temp = number.charAt(i);
        	if(k>0) {
	        	for(int j=i+1; j<length && j<i+1+k; j++) {
	        		if(temp < number.charAt(j)) { // ū ���� ã�� ���
	            		temp = number.charAt(j); 
	            		idx = j; // �ش� �ε��� ����
	            		flag = true;
	            	}
	        	}
	        	if(flag) {
	        		k -= (idx-i); // �ش� �ε��� ũ�� ��ŭ ������ �� �ִ� k�� �谨
		        	i += (idx-i); // i�� �ε��� ũ�⸸ŭ �̵�
		        	flag = false; // flag �ʱ�ȭ
	        	}	        	  
        	} else {
        		stringbuilder.append(number.substring(i, number.length()));
        		break;
        	}        
        	
        	if(!flag) { i++; }
        	stringbuilder.append(temp);
        }                
        
        answer = stringbuilder.toString();
        return answer;
    }
}