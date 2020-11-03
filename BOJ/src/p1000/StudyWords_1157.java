/**
 * Backjoon - 1157. 단어 공부
 * StudyWords_1157.java
 * @date 2020-08-10
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudyWords_1157 {

	private static int[] memory;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		memory = new int[26];
		
		String input = br.readLine().toUpperCase();
		
		for(int i=0; i<input.length(); i++) {
			int index = input.charAt(i)-'A';
			
			memory[index]+=1;
		}
		
		int max = 0;
		int maxIndex = 0;;
		
		for(int i=0; i<memory.length; i++) {
			if(max < memory[i]) {
				max = memory[i];
				maxIndex = i;
				continue;
			}
			
			if(max == memory[i]) {
				maxIndex = -1;
			}
		}
		
		if(maxIndex == -1) {
			System.out.println("?");
		} else {
			System.out.println((char)(maxIndex+65));
		}
	}

}
