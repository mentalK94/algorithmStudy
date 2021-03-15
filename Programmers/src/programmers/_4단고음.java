/**
 * programmers - 2017 카카오코드 예선. 4단 고음
 * _4단고음.java
 * @date 2021-03-16
 * @author hansolKim
 **/

package programmers;

public class _4단고음 {

	static int answer;
    public int solution(int n) {
        answer = 0;        
        getAnswer(n, 0);
        System.out.println(answer);
        return answer;
    }
    
    private static void getAnswer(int n, int p) {
        
        if(n == 1 && p == 0) { answer++; }
        if(n == 2 || Math.pow(3, p/2) > n) { return; }        
        
        if(n%3 == 0 && p>=2) {
            getAnswer(n/3, p-2);
        }
        getAnswer(n-1, p+1);
    }
}
