/**
 * Backjoon - 1032. 명령 프롬프트
 * CommandPrompt_1032.java
 * @date 2020-09-19
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandPrompt_1032 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] files = new String[N];
		for(int i=0; i<N; i++) {
			files[i] = br.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for(int i=0; i<files[0].length(); i++) {
			flag = true;
			for(int j=0; j<N-1; j++) {
				if(files[j].charAt(i) != files[j+1].charAt(i)) {
					flag = false;
					break;
				}						
			}
			
			if(flag) {
				sb.append(files[0].charAt(i));
			} else {
				sb.append('?');
			}
		}
		
		System.out.println(sb);
	}

}
