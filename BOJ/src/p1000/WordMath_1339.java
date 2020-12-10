/**
 * Backjoon - 1339. 단어 수학
 * WordMath_1339.java
 * @date 2020-12-10
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class WordMath_1339 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] alpha = new int[26]; // A:0 ... Z:25
		
		ArrayList<String> words = new ArrayList<>();
		for(int i=0; i<N; i++) {
			words.add(br.readLine());
			
			String str = words.get(i);
			int base = 1;
			
			for(int j=str.length()-1; j>=0; j--) {
				alpha[str.charAt(j)-65] += base;
				base *= 10;
			}
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>(
			new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o2[1], o1[1]);
				}
			}
		);
		
		for(int i=0; i<alpha.length; i++) {
			if(alpha[i] != 0) {
				q.add(new int[] {i, alpha[i]});
			}
		}
		
		int number = 9;
		int answer = 0;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int idx = info[0];
			int value = info[1];
			
			alpha[idx] = number--;
			answer += (alpha[idx]*value);
		}
		
		System.out.println(answer);
		br.close();
	}
}