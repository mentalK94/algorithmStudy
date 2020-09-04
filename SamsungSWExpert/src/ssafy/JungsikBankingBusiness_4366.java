package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JungsikBankingBusiness_4366 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

		for (int test_case = 1; test_case <= T; test_case++) {
			
			sb.append("#").append(test_case).append(" ");
			
			String binaryStr = br.readLine();
			String threeStr = br.readLine();
			
			// 2진수 숫자 길이만큼 배열 생성
			int[] binary2Tens = new int[binaryStr.length()];
			int[] three2Tens = new int[threeStr.length()*2];
			int binaryIdx = 0;
			int threeIdx = 0;
			int binaryNum = 0;
			int threeNum = 0;
			
			int m = 1;
			// 입력받은 2진수 binaryArr에 삽입
			for(int i=binaryStr.length()-1; i>=0; i--) {				
				binaryNum += (binaryStr.charAt(i) - '0')*m;
				m*=2;
			}
			
			m = 1;
			for(int i=threeStr.length()-1; i>=0; i--) {
				threeNum += (threeStr.charAt(i) - '0')*m;
				m*=3;
			}
			
			m = 1;
			for(int i=binaryStr.length()-1; i>=0; i--) {				
				if((binaryStr.charAt(i) - '0') == 0) { // 0인 경우 ---> 1로 변경 
					binary2Tens[binaryIdx++] = binaryNum+m;
				} else { // 1인 경우 0으로 변경
					binary2Tens[binaryIdx++] = binaryNum-m;
				}
				m*=2;
			}
			
			m = 1;
			for(int i=threeStr.length()-1; i>=0; i--) {
				if((threeStr.charAt(i) - '0') == 0) { // 0인 경우 ---> 1, 2로 변경 
					three2Tens[threeIdx++] = threeNum+m;
					three2Tens[threeIdx++] = threeNum+(2*m);
				} else if((threeStr.charAt(i) - '0') == 1){ // 1인 경우 0, 2로 변경
					three2Tens[threeIdx++] = threeNum-m;
					three2Tens[threeIdx++] = threeNum+m;
				} else { // 2인 경우 0, 1로 변경
					three2Tens[threeIdx++] = threeNum-m;
					three2Tens[threeIdx++] = threeNum-(2*m);
				}
				m*=3;
			}
			
//			System.out.println(Arrays.toString(binary2Tens));
//			System.out.println(Arrays.toString(three2Tens));
//			System.out.println(binaryNum);
//			System.out.println(threeNum);
			
			int result = 0;
			
			main:for(int i=0; i<binary2Tens.length; i++) {
				for(int j=0; j<three2Tens.length; j++) {
					if(binary2Tens[i] == three2Tens[j]) {
						result = binary2Tens[i];
						break main;
					}
				}
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
