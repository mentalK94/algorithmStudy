package level;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution2 {

	public static void main(String[] args) {
		Solution2 s2 = new Solution2();
		String program = "line";
		String[] flag_rules = {"-s STRINGS", "-n NUMBERS", "-e NULL"};
		String[] commands = {"line -n 100 102 -s hi -e", "line -n id pwd -n 100"};
		s2.solution(program, flag_rules, commands);
	}
	
	public boolean[] solution(String program, String[] flag_rules, String[] commands) {

		// commands의 길이만큼 결과 배열을 생성한다.
		boolean[] answer = new boolean[commands.length];

		// flag_rules를 저장할 해시맵 생성한다.
		HashMap<String, String> ruleMap = new HashMap<>();

		// flag_rules를 파싱하여 ruleMap에 저장한다.
		for (int i = 0; i < flag_rules.length; ++i) {
			// 각 rule들을 (" ")공백문자로 나누어 token으로 저장한다.
			StringTokenizer st = new StringTokenizer(flag_rules[i]);

			String flagStr = st.nextToken();
			String flagArgType = st.nextToken();

			// "-flag"를 ("-")dash로 분리한다.
			st = new StringTokenizer(flagStr, "-");
			String flagName = st.nextToken();
			ruleMap.put(flagName, flagArgType);
		}

		// 해당 commands를 파싱하여 올바른 명령어인지 확인한다.
		for (int i = 0; i < commands.length; ++i) {
			StringTokenizer st = new StringTokenizer(commands[i], "-");
			String prog = st.nextToken().trim(); // 입력받은 program 공백 제거

			// 1. 입력받은 프로그램이 올바른지 확인합니다.
			// 올바르지 않다면 'False'값을 answer배열에 넣어줍니다.
			if (!program.equals(prog)) {
				answer[i] = false;
				continue;
			}

			// 2. 입력한 명령어들이 flag_rule을 지키고 있는지 확인합니다.
			int size = st.countTokens();
			boolean check = false;
			
			for (int j = 0; j < size; ++j) {
				StringTokenizer commandToken = new StringTokenizer(st.nextToken());
				String flagName = commandToken.nextToken();
				String flagArg = "";

				// argument가 존재하는 경우 flagArg에 저장합니다.
				while (commandToken.countTokens() > 0) {
					flagArg += commandToken.nextToken();
					if(commandToken.countTokens() > 0) {
						flagArg += " ";
					}					
				}

				// 입력받은 flagName이 ruleMap에 있는 지 확인 후 type변수에 저장합니다.				
				if (ruleMap.containsKey(flagName)) {
					String type = ruleMap.get(flagName);
					switch (type) {
					case "NULL":
						check = isNull(flagArg);
						break;
					case "NUMBER":
						check = isNumber(flagArg);
						break;
					case "STRING":
						check = isString(flagArg);
						break;
					case "NUMBERS":
						check = isNumbers(flagArg);
						break;
					case "STRINGS":
						check = isStrings(flagArg);
						break;							
					default:						
						break;
					}
				}
								
				// flag rule에 어긋나므로 나머지 arg를 확인할 필요없이 false를 저장합니다.
				if(!check) {
					answer[i] = check;
					break;
				}
			}

			answer[i] = check;
		}

		System.out.println(Arrays.toString(answer));
		return answer;
	}
	
	/**
	 * arg값이 1개 이상의 STRI로 이루어져 있는 지 확인하는 메서드
	 * */
	private boolean isStrings(String args) {
		StringTokenizer st = new StringTokenizer(args);
		int size = st.countTokens();
		for(int i=0; i<size; ++i) {
			String arg = st.nextToken();
			if(isString(arg)) { // 하나의 arg가 STRING type인 경우
				return true;
			}
		}
		return false;
	}

	/**
	 * arg값이 1개 이상의 NUMBER로 이루어져 있는 지 확인하는 메서드
	 * */
	private boolean isNumbers(String args) {
		// System.out.println(args);
		StringTokenizer st = new StringTokenizer(args);
		int size = st.countTokens();
		for(int i=0; i<size; ++i) {
			String arg = st.nextToken();
			if(isNumber(arg)) { // 하나의 arg가 NUMBER type인 경우
				return true;
			}
		}
		return false;
	}

	/**
	 * arg값이 STRING인지 확인하는 메서드
	 * */
	private static boolean isString(String arg) {		
		for(int i=0; i<arg.length(); ++i) {
			
			// 대문자 확인
			if(arg.charAt(i) >= 65 && arg.charAt(i) <= 90) continue;
			// 소문자 확인
			if(arg.charAt(i) >= 97 && arg.charAt(i) <= 122) continue;
			
			// 대문자 또는 소문자가 아닌 경우 false를 리턴합니다.
			return false;
		}
		
		// 모든 문자가 대문자 또는 소문자로 이루어져 있음을 확인하여 true를 반환합니다.
		return true;
	}

	/**
	 * arg값이 NUMBER인지 확인하는 메서드
	 * */
	private static boolean isNumber(String arg) {
		for(int i=0; i<arg.length(); ++i) {
			// i번째 문자가 숫자의 타입이 아닌 경우 false를 반환합니다.
			if(arg.charAt(i)<47 || arg.charAt(i)>58) {
				return false;
			}
		}
		// 모든 문자가 숫자로 이루어져 있음을 확인하여 true를 반환합니다.
		return true;
	}

	/**
	 * arg값이 NULL인지 확인하는 메서드
	 * */
	private static boolean isNull(String arg) {
		// 빈 문자열인지 확인합니다.
		return arg.equals("") ? true : false;
	}

}
