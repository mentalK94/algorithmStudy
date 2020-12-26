package algorithms;

public class BitMask {

	public static void main(String[] args) {
		int a = 0;
		a+=(1<<3);
		// a+=(1<<2);
		a+=(1<<0);
		System.out.println(a); // 1101
		
		// 1. 2번째 숫자가 있는지 여부 확인
		System.out.println(a & 1<<0);
		
	}

}
