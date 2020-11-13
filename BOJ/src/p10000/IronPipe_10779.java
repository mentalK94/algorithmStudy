/**
 * Backjoon - 10779. 쇠막대기
 * IronPipe_10779.java
 * @date 2020-11-13
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IronPipe_10779 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		
		int answer = 0;
		int pipe = 0;
		for(int i=0; i<data.length(); i++) {

			if(data.charAt(i) == '(') {
				// 1. 레이저인지 확인
				if(i+1<data.length() && data.charAt(i+1)==')') {
					i++;
					answer += pipe;
				} else { // 2. 쇠막대기 추가
					pipe++;
				}
			} else { // 파이프가 끝난 경우
				answer += 1;
				pipe--;
			}
		}
		
		System.out.println(answer);
		br.close();
	}

}
