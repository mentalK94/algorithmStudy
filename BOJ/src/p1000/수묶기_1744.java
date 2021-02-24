/**
 * Backjoon - 1744. 수 묶기
 * 수묶기_1744.java
 * @date 2021-02-24
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 수묶기_1744 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> rightPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> leftPQ = new PriorityQueue<Integer>();
		PriorityQueue<Integer> zeroPQ = new PriorityQueue<Integer>();
		
		while(N-->0) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > 0) {
				rightPQ.add(num);
			} else if(num == 0) {
				zeroPQ.add(num);
			} else {
				leftPQ.add(num);
			}
		}
		
		int answer = 0;
		
		// 양수부터 계산
		while(rightPQ.size() >= 2) {
			int num1 = rightPQ.poll();
			int num2 = rightPQ.poll();
			answer += (num1+num2) < (num1*num2) ? (num1*num2) : (num1+num2);
		}
		
		if(!rightPQ.isEmpty()) { answer += rightPQ.poll(); }
		
		// 음수의 경우 계산
		while(leftPQ.size() >= 2) {
			answer += (leftPQ.poll() * leftPQ.poll());
		}
		
		if(zeroPQ.size()==0 && leftPQ.size()>0) {
			answer += leftPQ.poll();
		}
		
		System.out.println(answer);
		br.close();
	}

}
