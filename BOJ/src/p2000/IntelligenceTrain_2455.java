/**
 * Backjoon - 2455. 지능형 기차
 * IntelligenceTrain_2455.java
 * @date 2020-12-10
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IntelligenceTrain_2455 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int answer = 0;
		int cur = 0;
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			
			cur -= out;
			cur += in;
			
			if(cur > answer) { answer = cur; }
		}
		
		bw.write(answer+"");
		bw.flush();
		bw.close();
		br.close();
	}
}