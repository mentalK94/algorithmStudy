/**
 * Backjoon - 7568. 덩치
 * BigSize_7568.java
 * @date 2020-08-31
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
	int weight;
	int height;
	int rank;
	int idx;

	public Person(int weight, int height, int idx) {
		this.weight = weight;
		this.height = height;
		this.idx = idx;
		this.rank = 0;
	}

	@Override
	/* 몸무게 순으로 정렬 */
	public int compareTo(Person o) {
		return Integer.compare(o.weight, this.weight);
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getIdx() {
		return idx;
	}

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
	}

	public int getRank() {
		return rank;
	}
}

public class BigSize_7568 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Person> personList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			personList.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
		}

		Collections.sort(personList);

		int count = 1;
		personList.get(0).setRank(1);

		/* rank 셋팅 */
		for (int i = 0; i < N; i++) {
		
			for (int j = 1; j < N; j++) {

				if (personList.get(i).getWeight() == personList.get(j).getWeight()) { // 기준인 사람과 몸무게가 같으면 같은 순위
					if(personList.get(j).getRank() == 0) {
						count++;
					}
					personList.get(j).setRank(personList.get(i).getRank());
					continue;
				} 
				
				System.out.println(personList.get(i).getHeight() + " " + personList.get(j).getHeight());
				if (personList.get(i).getHeight() <= personList.get(j).getHeight()) { // 기준인 사람보다 키가 크거나 같으면
					if(personList.get(j).getRank() == 0) {
						count++;
					}
					personList.get(j).setRank(personList.get(i).getRank());
				} else {
					personList.get(j).setRank(personList.get(i).getRank()+1);
				}
			}
		}

		Collections.sort(personList, (Person p1, Person p2) -> Integer.compare(p1.getIdx(), p2.getIdx()));

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(personList.get(i).getRank()).append(" ");
		}

		System.out.println(sb);
	}

}
