/**
 * Backjoon - 18512. 점프점프
 * JumpJump_18512.java
 * @date 2020-09-01
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpJump_18512 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader 생성

		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력받은 라인을 " "으로 토큰 생성
		int x = Integer.parseInt(st.nextToken()); // 김싸피 뛸 때 이동하는 x미터 입력
		int y = Integer.parseInt(st.nextToken()); // 박싸피 뛸 때 이동하는 y미터 입력
		int h1 = Integer.parseInt(st.nextToken()); // 김싸피 출발 지점 입력
		int h2 = Integer.parseInt(st.nextToken()); // 박싸피 출발 지점 입력
		int answer = 0;
		
		while(h1 < 10000 && h2 < 10000) {
			if(h1>h2) {
				h2+=y;
			} else if(h1<h2){
				h1+=x;
			} else {
				answer = h1;
				break;
			}
			
		}

		if (answer == 0) { // 만나는 지점을 찾지 못한 경우
			System.out.println(-1);
		} else { // 만나는 지점을 찾은 경우
			System.out.println(answer);
		}

	}

}
