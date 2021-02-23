package programmers;

public class _124나라의숫자 {

	public static void main(String[] args) {
		_124나라의숫자 p = new _124나라의숫자();
		System.out.println(p.solution(1));
	}
	
	public String solution(int n) {
        
        int sum=0;
        int k=1;
        boolean isMultiple = false;
        
        while(n>k) {
        	isMultiple = true;
        	sum += k;
    		k*=3;
        }
        
        if(isMultiple) { 
        	k/=3;
        	sum -= k;
        }
        
        StringBuilder sb = new StringBuilder();
        while(n>0) {
        	// 나머지 자리수를 채울 수 없는 경우
        	if((n-k) < sum) {
        		k /= 3;
        		sum -= k;
        		continue;
        	}
        	
        	// 채울 수 있는 경우 -> 현재 자리수가 몇 인지 확인
        	int t = (n-sum)/k;
        	
        	if(t == 1) { sb.append(1);}
        	if(t == 2) { sb.append(2);}
        	if(t == 3) { sb.append(4);}
        	n -= (k*t);
        	k /= 3;
        	sum -= k;
        }
        
        return sb.toString();
    }

}
