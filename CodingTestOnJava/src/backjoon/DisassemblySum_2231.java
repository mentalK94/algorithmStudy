/**
 * Backjoon - 2231. 분해합
 * DisassemblySum_2231.java
 * @date 2020-08-31
 * @author hansolKim
 **/

package backjoon;

import java.util.Scanner;

public class DisassemblySum_2231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;
		int temp = N;
		int answer = 0;
		
		while(temp > 0) {
			temp/=10;
			count++;
		}
		
		for(int i=N-(count*9); i<N; i++) {
			int num = i;
			temp = i;
			
			while(temp > 0) {
				num += temp%10;
				temp/=10;
			}
			
			if(num == N) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
