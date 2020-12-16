/**
 * Backjoon - 10825. 국영수
 * 국영수_10825.java
 * @date 2020-12-16
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Student implements Comparable<Student>{

	String name;
	int korean; // 국어
	int english; // 영어
	int math; // 수학
	
	public Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	@Override
	public int compareTo(Student o) {
		if(o.korean == this.korean) { // 국어 점수가 같은 경우
			if(this.english == o.english) { // 영어점수가 같은 경우
				if(o.math == this.math) { // 수학점수가 같은 경우
					return this.name.compareTo(o.name); // 이름 증가순으로 정렬
				}
				return Integer.compare(o.math, this.math);
			}
			return Integer.compare(this.english, o.english);
		}
		return Integer.compare(o.korean, this.korean);
	}
	
}

public class 국영수_10825 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Student> students = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			students.add(new Student(name, korean, english, math));
		}
		
		Collections.sort(students);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<students.size(); i++) {
			sb.append(students.get(i).name).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}