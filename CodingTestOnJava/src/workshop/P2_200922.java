package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2_200922 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(getWay(num));
	}

	private static int getWay(int num) {
		if(num == 1) {return 2;}
		if(num%2==0) { // 짝수인 경우
			return 2*getWay(num-1)+1;
		} else {
			return 2*getWay(num-1);
		}
	}
}
