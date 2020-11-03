// DP

package algorithms;

import java.util.Scanner;


// 동전 단위 1, 4, 6: 배수의 성질이 만족하지 않은 경우
// 동전 개수에 제한이 없다.
public class MinCoinChangeTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt();
		int[] memory = new int[money+1]; // 각 금액의 최적 교환 동전 개수를 저장하는 동적테이블
		
		// 각 금액의 최적교환 동전개수를 구함.
		// 1원 시도했을 경우 최적 개수 : D[i-1]+1
		// 4원 시도했을 경우 최적 개수 : D[i-4]+1
		// 6원 시도했을 경우 최적 개수 : D[i-6]+1
		// 위 3가지 경우의 가장 최적값을 저장
		
		int min;
		for(int i=1; i<=money; i++) {
			min = Integer.MAX_VALUE;
			if(i>=1 && memory[i-1]+1<min) min = memory[i-1]+1;
			if(i>=4 && memory[i-4]+1<min) min = memory[i-4]+1;
			if(i>=6 && memory[i-6]+1<min) min = memory[i-6]+1;
			
			memory[i] = min;
		}
		System.out.println(memory[money]);
	}

}
