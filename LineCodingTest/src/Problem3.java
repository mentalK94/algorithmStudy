
public class Problem3 {

	public static void main(String[] args) {
		Problem3 p3 = new Problem3();
		p3.solution(9);
	}
	
	public int[] solution(int n) {
        int[] answer = new int[2];
        
        int cnt = 0;
        int num = 0;
        int count = 0;
        
        while(n>0) {
        	count++;
        	cnt += n%10;
        	n/=10;
        }
        
        if(cnt >= 10) {
        	num += cnt%10;
        	cnt/=10;
        	num += cnt%10;
        } else {
        	num = cnt;
        }
        
        answer[0] = count-1;
        answer[1] = num;
        
        return answer;
    }

}
