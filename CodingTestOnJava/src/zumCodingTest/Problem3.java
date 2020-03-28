package zumCodingTest;

public class Problem3 {
	public static void main(String[] args) {
		Problem3Solution solution = new Problem3Solution();
		
		int a[] = {3, 4, 5, 6, 7};
		
		System.out.println(solution.solution(a));
	}
}

class Problem3Solution {
    public int solution(int[] a){
		
    	int answer = 0;
    	int value = a[0];
    	boolean flag = false; // ���� ������ ���� �� true, ���� �� false    
    	boolean isPerfect = true;
    	
    	
    	for(int i=1; i<a.length; i++) {
    		
    		if(i==1) { // �ʱ⼳��
    			if(value < a[i]) {
    				value = a[i];
    				flag = true;    				
    			}
    			else if(value > a[i]) {
    				value = a[i];
    				flag = false;
    			}
    			else break;
    		}
    		
    		if(!flag && value < a[i]) { // ���� ������ ���� �� 
    			value = a[i];
    			flag = true;
    			continue;
    		} else if(flag && value > a[i]) { // ���� ������ ���� ��
    			value = a[i];
    			flag = false;
    			continue;
    		}
    		else {
    			isPerfect = false;
    			break;
    		}
    		
    	}
    	
    	if(isPerfect) return answer;    	
    	
    	for(int i=0; i<a.length; i++) {
    		
    		isPerfect = true;
    		if(i == 0) value = a[1];
    		if(i == 1) value = a[0];
    		
    		for(int j=0; j<a.length; j++) {
    			
    			if(i==j) continue;
    			
    			if((i==0 && j==1) || (i==1 && j==0)) { // �ʱ⼳��
        			if(value < a[j]) {
        				value = a[j];
        				flag = true;
        			}
        			else if(value > a[j]) {
        				value = a[j];
        				flag = false;
        			}
        			else break;
        		}
    			
    			if(!flag && value < a[j]) { // ���� ������ ���� �� 
        			value = a[j];
        			flag = true;
        			continue;
        		} else if(flag && value > a[j]) { // ���� ������ ���� ��
        			value = a[j];
        			flag = false;
        			continue;
        		}
        		else {
        			isPerfect = false;
        			break;
        		}
        	}
    		
    		
    		if(isPerfect) {
    			System.out.println("i : " + i);
    			answer++;
    		}
    	}
    	
    	if(answer == 0) return -1;
    	
    	return answer;
    }
}