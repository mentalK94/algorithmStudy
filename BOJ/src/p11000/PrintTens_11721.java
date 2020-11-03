/**
 * Backjoon - 11721. 열개 씩 끊어 출력하기
 * PrintTens_11721.java
 * @date 2020-08-12
 * @author hansolKim
 **/

package p11000;

import java.util.Scanner;

public class PrintTens_11721 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		
		int r = str.length()/10;
		int idx = 0;
		for(idx=0; idx<r; idx++) { // 0 10 11 
			System.out.println(str.substring(idx*10, (idx*10)+10));
		}
		System.out.println(str.substring(idx*10, str.length()));
	}

}
