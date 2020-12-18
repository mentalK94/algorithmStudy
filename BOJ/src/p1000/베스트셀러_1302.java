/**
 * Backjoon - 1302. 베스트셀러
 * 베스트셀러_1302.java
 * @date 2020-12-18
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

class Book implements Comparable<Book> {
	String name; // 책 이름
	int cnt; // 판매권수
	
	public Book(String name, int cnt) {
		this.name = name;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Book o) {
		if(this.cnt == o.cnt) {
			return this.name.compareTo(o.name);
		}
		return Integer.compare(o.cnt, this.cnt);
	}
}
public class 베스트셀러_1302 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 팔린 책 개수 입력
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			String book = br.readLine();
			int sellCnt = 0;
			if(map.containsKey(book)) { 
				sellCnt = map.get(book);
			}
			
			map.put(book, sellCnt+1);
		}
		
		PriorityQueue<Book> pq = new PriorityQueue<>();
		for(String key : map.keySet()) {
			int cnt = map.get(key);
			pq.add(new Book(key, cnt));
		}
		
		String answer = pq.poll().name;
		System.out.println(answer);
		br.close();
	}
}