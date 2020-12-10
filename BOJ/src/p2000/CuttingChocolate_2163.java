/**
 * Backjoon - 2163. 초콜릿 자르기
 * CuttingChocolate_2163.java
 * @date 2020-12-10
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CuttingChocolate_2163 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		bw.write(N*M-1+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
