/**
 * Backjoon - 2605. 줄 세우기
 * Lineup_2605.java
 * @date 2020-09-19 
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lineup_2605 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] students = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> line = new ArrayList<>();
		line.add(1);
		for(int i=2; i<=N; i++) {
			line.add(line.size()-students[i-1], i);
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(line.get(i)+" ");
		}
	}

}
