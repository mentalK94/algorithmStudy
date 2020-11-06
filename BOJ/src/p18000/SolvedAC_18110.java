/**
 * Backjoon - 18110. solved.ac
 * SolvedAC_18110.java
 * @date 2020-11-06
 * @author hansolKim
 **/

package p18000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SolvedAC_18110 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			list.add(num);
		}
		
		double deletePer = 0.15;
		int delete = (int) Math.round(deletePer * N); 
		int answer = 0;
		
		Collections.sort(list);
		for(int i=delete; i<N-delete; i++) {
			answer+=list.get(i);
		}
		
		System.out.println((int)Math.round((double)answer/(N-(delete*2))));
	}

}
