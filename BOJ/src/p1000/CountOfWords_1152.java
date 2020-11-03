/**
 * Backjoon - 1152. 단어의 갯수
 * CountOfWords_1152.java
 * @date 2020-08-10
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountOfWords_1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		System.out.println(st.countTokens());
	}
}
