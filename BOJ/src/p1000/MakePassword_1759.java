/**
 * Backjoon - 1759. 암호 만들기
 * MakePassword_1759.java
 * @date 2020-10-29
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class MakePassword_1759 {

	static int N, R;
	static char[] input, selected;
	static char[] mos = {'a', 'e', 'i', 'o', 'u'};
	static ArrayList<String> temp;
	static ArrayList<String> answers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		input = new char[N];
		selected = new char[R];
		temp = new ArrayList<>();
		answers = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		
		combination(0, 0);
		for(int i=0; i<temp.size(); i++) {
			String str = temp.get(i);
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<ch.length; j++) {
				sb.append(ch[j]);
			}
			answers.add(sb.toString());
		}
		
		Collections.sort(answers);
		
		for(int i=0; i<answers.size(); i++) {
			System.out.println(answers.get(i));
		}
	}

	private static void combination(int start, int cnt) {
		if(cnt == R) {
			
			int mo = 0; // 모음
			int ja = 0; // 자음
			
			for(int i=0; i<R; i++) {
				boolean isMo = false;
				for(int j=0; j<mos.length; j++) {
					if(selected[i] == mos[j]) {
						isMo = true;
						break;
					}
				}
				
				if(isMo) {mo++;}
				else {ja++;}
			}
			
			if(mo<1 || ja<2) return;
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<R; i++) {
				sb.append(selected[i]);
			}
			temp.add(sb.toString());
			return;
		}
		
		for(int i=start; i<N; i++) {
			selected[cnt] = input[i];
			combination(i+1, cnt+1);
		}
	}

}
