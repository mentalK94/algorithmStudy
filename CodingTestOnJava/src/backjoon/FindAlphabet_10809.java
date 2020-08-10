/**
 * Backjoon - 10809. 알파벳 찾기
 * FindAlphabet_10809.java
 * @date 2020-08-10
 * @author hansolKim
 **/

package backjoon;

import java.util.Scanner;

public class FindAlphabet_10809 {

	private static int[] memory;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		memory = new int[26];
		
		for(int i=0; i<memory.length; i++) {
			memory[i] = -1;
		}
		
		for(int i=0; i<str.length(); i++) {
			int index = str.charAt(i)-'a';
			if(memory[index] == -1) {
				memory[index] = i;
			}
		}
		
		for(int i=0; i<memory.length; i++) {
			System.out.print(memory[i] + " ");
		}
		
	}

}
