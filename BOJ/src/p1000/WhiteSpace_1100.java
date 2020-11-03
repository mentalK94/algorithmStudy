/**
 * Backjoon - 1100. 하얀 칸
 * WhiteSpace_1100.java
 * @date 2020-10-12
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WhiteSpace_1100 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] map = new char[8][8];
		
		for(int i=0; i<map.length; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int answer = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(i%2==0 && j%2==0 && map[i][j] == 'F') { answer++; }
				if(i%2==1 && j%2==1 && map[i][j] == 'F') { answer++; }
			}
		}
		
		System.out.println(answer);
	}

}
