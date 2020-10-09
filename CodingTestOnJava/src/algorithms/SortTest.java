package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Student implements Comparable<Student>{
	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Student o) {
		return o.name.compareTo(this.name);
	}

	
}

public class SortTest {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("김한솔", 90));
		students.add(new Student("박권용", 92));
		students.add(new Student("노형래", 88));
		Collections.sort(students);
		
		for(int i=0; i<students.size(); i++) {
			System.out.println(students.get(i).score + " " +students.get(i).name);
		}
	}

}
