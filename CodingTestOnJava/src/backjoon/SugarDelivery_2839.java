/**
 * Backjoon - 2839. 설탕 배달
 * SugarDelivery_2839.java
 * @date 2020-08-12
 * @author hansolKim
 **/

package backjoon;

import java.util.Scanner;

public class SugarDelivery_2839 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int temp = N;
		int a = N/5;
		int b = 0;
		
		while(true) {
			temp = N;
			temp -= (a*5);
			if(temp%3==0) {
				b = temp/3;
				break;
			}
			
			a--;
			if(a<0) {break;}
		}
		
		if(a<=0 && b==0) {
			System.out.println(-1);
		} else {
			System.out.println(a+b);
		}
	}

}
