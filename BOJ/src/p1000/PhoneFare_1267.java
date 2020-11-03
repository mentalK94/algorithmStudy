/**
 * Backjoon - 1267. 핸드폰 요금
 * PhoneFare_1267.java
 * @date 2020-10-12
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PhoneFare_1267 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int y = 30;
		int yFare = 10; 
		int m = 60;
		int mFare = 15;
		
		int yy = 0;
		int mm = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int time = Integer.parseInt(st.nextToken());
			
			yy += yFare + (time/y)*yFare;
			mm += mFare + (time/m)*mFare;
		}
		
		if(yy < mm) {
			sb.append("Y").append(" ").append(yy);
		} else if(yy > mm) {
			sb.append("M").append(" ").append(mm);
		} else {
			sb.append("Y").append(" M ").append(mm);
		}
		
		System.out.println(sb);
	}

}
