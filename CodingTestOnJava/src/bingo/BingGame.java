package bingo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BingGame {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int n1 = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		System.out.println(x*n1 + y*n2);
	}
	
	public static void subset(int n) {
		for (int i = 0; i < (1<<n); i++) {
			for(int j=0; j<n; j++) {
				if((i & (1<<j)) != 0) {
					 System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}
}