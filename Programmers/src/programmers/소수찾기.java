package programmers;

import java.util.Arrays;
import java.util.HashSet;

public class 소수찾기 {

	public static void main(String[] args) {
		소수찾기 소수 = new 소수찾기();
		System.out.println(소수.solution("1231"));
	}
	
	static boolean[] visited;
	static int[] selected;
	static int answer, R;
	static String numberStr;
	static HashSet<Integer> set;
	
	public int solution(String numbers) {
		
		answer = 0;        
        numberStr = numbers;
        
        set = new HashSet<Integer>();
        for(int i=1; i<=numbers.length(); i++) {
        	R = i;
        	visited = new boolean[numbers.length()];
        	selected = new int[R];
        	permutation(0);
        }
        
        return answer;
    }

	private void permutation(int cnt) {
		if(cnt == R) {
			int base = 1;
			int num = 0;
			for(int i=0; i<R; i++) {
				num += ((numberStr.charAt(selected[i])-'0') * base);
				base *= 10;
			}
			
			if(set.contains(num)) { 
				return; 
			} // 이미 계산된 것
			
			// 해당 숫자가 소수인지 확인
			if(isPrime(num)) {
				answer++;
			}
			
			set.add(num);
			return;
		}
		
		for(int i=0; i<numberStr.length(); i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[cnt] = i;
			permutation(cnt+1);
			visited[i] = false;
		}
	}

	private boolean isPrime(int num) {
		
		if(num <= 1) { return false; }
		if(num == 2) { return true; }
		
		int x = num/2+1;
		boolean prime = true;
		while(x>1) {
			if(num%x == 0) { 
				prime = false;
				break;
			}
			
			x--;
		}
		
		return prime;
	}
}