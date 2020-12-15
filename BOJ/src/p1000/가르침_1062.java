/**
 * Backjoon - 1062. 가르침
 * 가르침_1062.java
 * @date 2020-12-15
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침_1062 {
	
	static boolean[] isLearnAlpha;
	static int N, K, answer;
	static String[] data;
	static char[] needAlpha = {'a', 'c', 'i', 't', 'n'};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		isLearnAlpha = new boolean[26];
		data = new String[N];
		
		for(int i=0; i<N; i++) {
			data[i] = br.readLine();
		}
		
		for(int i=0; i<needAlpha.length; i++) {
			isLearnAlpha[needAlpha[i]-97] = true;
			K--;
		}
		
		answer = 0;
		if(K >= 0) { comb(0, 0);} 
		
		System.out.println(answer);
		br.close();
	}

	private static void comb(int start, int cnt) {
		if(cnt == K) {
			int wordCnt = 0;
			for(int i=0; i<N; i++) {
				boolean isLearn = true;
				for(int j=4; j<data[i].length()-4; j++) {
					if(!isLearnAlpha[data[i].charAt(j)-97]) {
						isLearn = false;
						break;
					}
				}
				
				if(isLearn) {
					wordCnt++;
				}
			}
			
			if(answer < wordCnt) { answer = wordCnt;}
			return;
		}
		
		for(int i=start; i<26; i++) {
			if(isLearnAlpha[i]) continue; // 사용되지 않는 알파벳 패스
			isLearnAlpha[i] = true;
			comb(i+1, cnt+1);
			isLearnAlpha[i] = false;
		}
	}
}