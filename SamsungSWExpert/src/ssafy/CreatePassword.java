package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CreatePassword {
	
	private static int tc;
	private static final int SIZE = 8;
	private static final int CYCLE = 5;
	private static LinkedList<Integer> passwords;
	private static int idx;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=1;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			tc = Integer.parseInt(br.readLine()); // 테스트케이스 번호 입력
			
			String numList = br.readLine();
			StringTokenizer st = new StringTokenizer(numList);
			
			passwords = new LinkedList<Integer>();
			for(int i=0; i<SIZE; i++) {
				passwords.add(Integer.parseInt(st.nextToken()));
			}
			
			idx = 0;
			
			while(true) {
				// 1. 해당 인덱스의 값을 pop
				// 2. 값에서 idx+1을 차감 후 0인지 확인
				// 2-1. 0이면 리턴
				int password = passwords.poll();
				
				if(password - (idx%CYCLE+1) <= 0) {
					passwords.add(0);
					break;
				}
				
				passwords.add(password-(idx%CYCLE+1));
				idx++;
			}
			
			System.out.print("#"+test_case+ " ");
			for(int i=0; i<SIZE; i++) {
				System.out.print(passwords.get(i) + " ");
			}
			System.out.println();
			
		}
	}
}
