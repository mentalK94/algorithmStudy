/**
 * Backjoon - 3954. Brainf**k 인터프리터
 * Brainfk인터프리터_3954.java
 * @date 2021-01-02
 * @author hansolKim
 **/

package p3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Brainfk인터프리터_3954 {
	
	static final int LIMIT = 50000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int memorySize = Integer.parseInt(st.nextToken()); // 메모리 크기
			int codeSize = Integer.parseInt(st.nextToken()); // 코드 크기
			int inputSize = Integer.parseInt(st.nextToken()); // 입력 크기

			int[] mem = new int[memorySize]; // 메모리 배열
			int pointer = 0; // 포인터가 가리키는 칸

			String code = br.readLine(); // 명령어 코드
			String input = br.readLine(); // 입력한 문자열
			int inputIdx = 0;
			int loopCount = 0; // 명령어 수행 횟수
			int loopEnd = 0;
			boolean isInfinite = false;
			
			HashMap<Integer, Integer> loopMap = new HashMap<>();
			Stack<Integer> loopOpen = new Stack<>(); // 여는괄호 저장 스택
			// 루프 쌍 인덱스 저장
			for (int i = 0; i < codeSize; i++) {
				if(code.charAt(i) == '[') { loopOpen.add(i); }
				if(code.charAt(i) == ']') { 
					loopMap.put(i, loopOpen.peek());
					loopMap.put(loopOpen.pop(), i);
				}
			}
			
			int idx = 0;
			
			for (idx = 0; idx < codeSize; idx++) {				
				if(loopCount++>=LIMIT) { isInfinite = true; }				
				
				switch (code.charAt(idx)) {
				case '-':
					mem[pointer] = mem[pointer]==0 ? 255 : mem[pointer]-1;					
					break;
				case '+':
					mem[pointer] = mem[pointer]==255 ? 0 : mem[pointer]+1;
					break;
				case '<':
					pointer = pointer-1==-1 ? memorySize-1 : pointer-1;
					break;
				case '>':
					pointer = pointer+1==memorySize ? 0:pointer+1;
					break;
				case '[':
					if(mem[pointer] == 0) {
						idx = loopMap.get(idx);
					} 
					break;
				case ']':
					int startIdx = loopMap.get(idx);
					if(mem[pointer] != 0) { // 루프가 도는 것						
						if(isInfinite) {
							loopEnd = loopEnd < idx ? idx : loopEnd;
						}
						idx = startIdx;
					}
					break;
				case '.':
					break;
				case ',':
					mem[pointer] = inputIdx < inputSize ? input.charAt(inputIdx) : 255;
					inputIdx++;
					break;
				}
				
				if(loopCount == 2*LIMIT) { break; }
			}
		
			if(isInfinite) {
				int loopStart = loopMap.get(loopEnd);
				sb.append("Loops ").append(loopStart).append(" ").append(loopEnd);
			} else {
				sb.append("Terminates");
			}
			sb.append("\n");			
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}