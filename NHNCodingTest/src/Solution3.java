import java.util.ArrayList;
import java.util.Scanner;

class Solution3 {
	
	//static 
	private static void solution(int numOfOrder, String[] orderArr) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		StringBuilder answers = new StringBuilder();
		for (int tc = 0; tc < numOfOrder; tc++) {
			String str = orderArr[tc];

			ArrayList<String> list = new ArrayList<>();
			StringBuilder temp = new StringBuilder();
			StringBuilder answer = new StringBuilder();			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == '(') {
					list.add(temp.toString());
					temp.delete(0, temp.length());
				} else if(str.charAt(i) == ')') {
					String pre;  // 가장 최근에 저장된 문자열
					String curStr;
					list.remove(list.size()-1); // 현재 인덱스 문자열 제거
					if(temp.length() == 0) {
						curStr = list.get(list.size()-1);
						pre = list.get(list.size()-2);
					} else {
						curStr = temp.toString();
						pre = list.get(list.size()-1);
						temp.delete(0, temp.length());
					}
					 
					if(pre.charAt(pre.length()-1)-'0'>=1 && pre.charAt(pre.length()-1)-'0'<=9) { // 숫자인 경우						
						int n = pre.charAt(pre.length()-1)-'0';
						if(pre.length() > 1) {
							temp.append(pre.substring(0, pre.length()-2));
						}
						for(int j=0; j<n; j++) {
							temp.append(temp);
						}
					} else { // 문자열인 경우
						for(int j=0; j<curStr.length(); j++) {
							temp.append(pre);
							temp.append(curStr.charAt(j));
						}
					}
					list.add(temp.toString());
				} else {
					temp.append(str.charAt(i));
				}
			}
			
			String ans = list.get(0);
			for(int i=0; i<ans.length(); i++) {
				if(ans.charAt(i)-'0'>=1 && ans.charAt(i)-'0'<=9) {
					int n = ans.charAt(i)-'0';
					char next = ans.charAt(i+1);
					for(int j=0; j<n; j++) {
						answer.append(next);
					}
					i++;
				} else {
					answer.append(ans.charAt(i));
				}
			}
			
			answers.append(answer).append("\n");
		}
		System.out.println(answers);
	}

	private static class InputData {
		int numOfOrder;
		String[] orderArr;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.orderArr = new String[inputData.numOfOrder];
			for (int i = 0; i < inputData.numOfOrder; i++) {
				inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfOrder, inputData.orderArr);
	}
}