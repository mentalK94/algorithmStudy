/**
 * DigitTest1.java
 * 2020-07-21
 * author : hansol kim 
 **/

import java.util.Scanner;

public class DigitTest1 {
	public static void main(String[] args) {
		
		int[] digits = new int[10]; // 0~9
		
		Scanner sc = new Scanner(System.in);
		
		// digits 배열 초기화
		for(int i=0; i<digits.length; i++) {
			digits[i] = 0;
		}
		
		while(true) {
			int num = sc.nextInt(); // 숫자 입력	
			// 출력
			if(num == 0) {
				
				// digits 배열 출력
				for(int i=0; i<digits.length; i++) {
					if(digits[i] != 0)
						System.out.println(i + " : " + digits[i] + "개");
				}
				
				break; // while문 탈출
			}
			
			// 십의 자리 숫자 count
			digits[num/10]++;
		}
		
	}
}
