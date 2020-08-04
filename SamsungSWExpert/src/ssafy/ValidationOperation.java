package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * [0803 과제] swexpert-1123.사칙 유효성 검사
 * keyPoint : 말단 노드에는 숫자만 와야하고 부모노드에는 사칙연산만 와야한다.
 * */
public class ValidationOperation {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#"+test_case+" ");
			int size = Integer.parseInt(br.readLine()); // size 입력
			int answer = 1; // 사칙연산 가능
			
			for(int i=0; i<size; i++) {
				
				String str = br.readLine();
				String[] splitStr = str.split(" ");
					
										
				if(splitStr.length == 4) { // 부모노드인데 숫자가 온 경우
					if(!splitStr[1].equals("+") && !splitStr[1].equals("-")
							&& !splitStr[1].equals("*") && !splitStr[1].equals("/")) {
						answer = 0;
					}
				}
				
				if(splitStr.length == 2) { // 말단노드인데 사칙연산이 온 경우
					if(splitStr[1].equals("+") || splitStr[1].equals("-")
							||splitStr[1].equals("/") || splitStr[1].equals("*")) {
						answer = 0;
					}
				}
			}
			
			sb.append(answer + "\n");
			
		}
		
		System.out.println(sb.toString());
	}

}
