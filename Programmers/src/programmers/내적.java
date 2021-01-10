package programmers;

public class 내적 {

	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		
		내적 내적 = new 내적();
		System.out.println(내적.solution(a, b));
	}
	
	public int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i=0; i<a.length; i++) {
        	answer += (a[i]*b[i]);
        }
        
        return answer;
    }

}
