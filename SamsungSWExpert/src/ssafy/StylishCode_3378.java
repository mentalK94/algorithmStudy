/**
 * swexpert - 3378. 스타일리쉬 들여쓰기
 * StylishCode_3378.java
 * @date 2020-08-31
 * @author hansolKim
 **/

/** 
 * 중복순열 구현 
 * */

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StylishCode_3378 {

	private static int[][] masterData, myData;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" 0 ");

			StringTokenizer init = new StringTokenizer(br.readLine());
			int masterline = Integer.parseInt(init.nextToken()); // 마스터한 사람의 코드 줄 수
			int myline = Integer.parseInt(init.nextToken()); // 당신의 코드 줄 수

			masterData = new int[masterline][4]; // 소스코드 한줄 | [0]들여쓰기, [1]소괄호, [2]중괄호, [3]대괄호

			// RCS 모든 순열을 구해서, 스타일리쉬 코드에 답으로 사용할 수 있는 지 확인 후 내 코드에 적용

			/* line 분석 */
			for (int i = 0; i < masterline; i++) {
				String masterCode = br.readLine();
				
				int idx = 0;
				
				if (masterCode.charAt(idx) == '.') {
					while (masterCode.charAt(idx) == '.') {
						idx++;
					}
					masterData[i][0] = idx;
				}

				if (i > 0) { // 이전 데이터를 가져옴
					masterData[i][1] = masterData[i - 1][1];
					masterData[i][2] = masterData[i - 1][2];
					masterData[i][3] = masterData[i - 1][3];
				}
				
				for (int j = idx; j < masterCode.length(); j++) {
					switch (masterCode.charAt(j)) {
					case '(':
						masterData[i][1]++;
						break;
					case '{':
						masterData[i][2]++;
						break;
					case '[':
						masterData[i][3]++;
						break;
					case ')':
						masterData[i][1]--;
						break;
					case '}':
						masterData[i][2]--;
						break;
					case ']':
						masterData[i][3]--;
						break;

					}

				}
				
			
				//sb.append(indentCount).append(" ");
			}
			
			myData = new int[myline][4];
			for(int i=0; i<myline; i++) {
				String myCode = br.readLine();
				int idx = 0;
				
				// .의 개수는 없는 상태입
				if(i>0) {
					myData[i][1] = myData[i-1][1];
					myData[i][2] = myData[i-1][2];
					myData[i][3] = myData[i-1][3];
				}
				
				for (int j = idx; j < myCode.length(); j++) {
					switch (myCode.charAt(j)) {
					case '(':
						myData[i][1]++;
						break;
					case '{':
						myData[i][2]++;
						break;
					case '[':
						myData[i][3]++;
						break;
					case ')':
						myData[i][1]--;
						break;
					case '}':
						myData[i][2]--;
						break;
					case ']':
						myData[i][3]--;
						break;

					}

				}
			}
			
			// 들여쓰기 .의 개수를 기록하자 : 초기값을 사용하지 않는 숫자로 넣기 -2, 들여쓰기의 답이 유일하지 않으면 -1
			for(int i=0; i<myline; i++) {
				myData[i][0] = -2;	
			}
			
			for (int R = 1; R <= 20; R++) {
				for (int C = 1; C <= 20; C++) {
					for (int S = 1; S <= 20; S++) {
						// R, C, S의 중복순열 쌍이 마스터 코드에 답이 될 수 있는지 확인
						if(check(R, C, S)) { // R, C, S의 중복순열 쌍이 마스터 코드에 답으로 쓸 수 있는지 체크
							cal(R, C, S); // 내 소스코드의 들여쓰기를 계산해보자
						}
						
					}
				}
			}
			
			for (int i = 1; i < myData.length; i++) {
				sb.append(' ').append(myData[i][0]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void cal(int R, int C, int S) {
		for(int i=1; i<myData.length; i++) {
			int x = masterData[i-1][1] * R + masterData[i-1][2] * C + masterData[i-1][3] * S;
			if(myData[i][0] == -2) { // 답을 구한적이 없으면, 바로 저장
				myData[i][0] = x;
			} else if(myData[i][0] != -2) { // 답을 구한적이 이쓴ㄴ데, 기존의 구했던 답과 다르면 -1
				myData[i][0] = -1;
			}
		}
	}

	private static boolean check(int R, int C, int S) {
		for(int i=1; i<masterData.length; i++) {
			if(masterData[i][0] != masterData[i-1][1] * R + masterData[i-1][2] * C + masterData[i-1][3] * S) {
				return false;
			}
 		}
		return true;
	}

}
