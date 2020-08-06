/**
 * Backjoon - 10814. 나이순 정렬
 * SortingByAge_10814.java
 * @date 2020-08-05
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SortingByAge_10814 {
	
	static class Member implements Comparable<Member>{
		int age;
		String name;
		
		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Member o) {
			// 회원을 나이순, 나이가 같으면 가입순
			return Integer.compare(this.age, o.age);
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Member> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<N; i++) {
			System.out.println(list.get(i).age + " " + list.get(i).name);
		}
		
	}

}
