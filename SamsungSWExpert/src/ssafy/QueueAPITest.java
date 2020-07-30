package ssafy;

import java.util.LinkedList;

public class QueueAPITest {

	public static void main(String[] args) {
		
		LinkedList<String> queue = new LinkedList<>();
		System.out.println(queue.size() + " " + queue.isEmpty());
		queue.offer("김한솔");
		queue.offerFirst("김성재");
		queue.offer("우재민");
		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

}
