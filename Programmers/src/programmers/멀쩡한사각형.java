/**
 * programmers - 멀쩡한사각형
 * 멀쩡한사각형.java
 * @date 2021-03-09
 * @author hansolKim
 **/

package programmers;

public class 멀쩡한사각형 {

	public static void main(String[] args) {
		System.out.println(gcd(8, 12));

	}

	public long solution(int w, int h) {
        long answer = (long)w*h - (w+h-gcd(w, h));
        
        return answer;
    }

	private static long gcd(int w, int h) {
		
		while(h!=0) {
			int r = w%h;			
			w = h;
			h = r;
		}
		
		return w;
	}
}
