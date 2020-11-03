/**
 * Backjoon - 2798. 블랙잭
 * BlackJack_2798.java
 * @date 2020-08-27
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BlackJack_2798 {

	private static int N, M;
	private static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer data = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		N = Integer.parseInt(data.nextToken());
		M = Integer.parseInt(data.nextToken());
		
		data = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(data.nextToken()));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<N-2; i++) {
			int card1 = list.get(i);
			for(int j=i+1; j<N-1; j++) {
				int card2 = list.get(j);
				if(card1+card2>M) { break;}
				for(int k=j+1; k<N; k++) {
					int sum = list.get(i) + list.get(j) + list.get(k);
					if(sum <= M) {
						answer = Math.max(answer, sum);	
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
}
