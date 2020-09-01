package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_서울_6반_김한솔 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader 생성

		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력받은 라인을 " "으로 토큰 생성
		int x = Integer.parseInt(st.nextToken()); // 김싸피 뛸 때 이동하는 x미터 입력
		int y = Integer.parseInt(st.nextToken()); // 박싸피 뛸 때 이동하는 y미터 입력
		int h1 = Integer.parseInt(st.nextToken()); // 김싸피 출발 지점 입력
		int h2 = Integer.parseInt(st.nextToken()); // 박싸피 출발 지점 입력

		int bigH = 0; // 출발 지점이 더 큰 것
		int bigZ = 0; // 출발 지점이 더 큰 사람의 이동크기
		int smallH = 0; // 출발 지점이 더 느린 것
		int smallZ = 0; // 출발 지점이 더 느린 사람의 이동크기
		int answer = 0; // 만나는 지점

		if (h1 > h2) { // 김싸피가 더 앞 지점에 있을 때 ---> 김싸피를 기준으로 한다
			bigH = h1; // 기준 지점
			bigZ = x; // 기준이 되는 사람의 이동 크기
			smallH = h2;
			smallZ = y;
		} else { // 박싸피가 더 앞 지점에 있을 때 ---> 박싸피를 기준으로 한다
			bigH = h2; // 기준 지점
			bigZ = y; // 기준이 되는 사람의 이동 크기
			smallH = h2;
			smallZ = x;
		}

		for (int i = 0; bigH + (bigZ * i) < 10000; i++) { // 10000이하의 지점까지 탐색 ---> 기준이 되는 사람의 위치를 증가 시키면서 만날 수 있는 지점 탐색
			int num = bigH + (bigZ * i); // 기준이 되는 사람의 현재 위치

			if ((num - smallH) % smallZ == 0) { // 만나는 지점을 찾은 경우
				answer = num; // 해당위치 삽입
				break;
			}

		}

		if (answer == 0) { // 만나는 지점을 찾지 못한 경우
			System.out.println(-1);
		} else { // 만나는 지점을 찾은 경우
			System.out.println(answer);
		}

	}

}
