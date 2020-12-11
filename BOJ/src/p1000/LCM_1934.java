/**
 * Backjoon - 1934. 최소공배수
 * LCM_1934.java
 * @date 2020-12-11
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LCM_1934 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int bigNum = A >= B ? A:B;
			int smallNum = A < B ? A:B;
			
			for(int i=1; bigNum*i<=bigNum*smallNum; i++) {
				if((bigNum*i)%smallNum == 0) {
					sb.append(bigNum*i).append("\n");
					break;
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
