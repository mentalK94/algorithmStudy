/**
 * Backjoon - 2531. 회전 초밥
 * RotateSushi_2531.java
 * @date 2020-08-28
 * @author hansolKim
 **/

package p2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//최대로 먹는 경우 총 k+1개의 초밥을 먹는다.
public class RotateSushi_2531 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> sushiList = new ArrayList<>(); 
		
		int n = Integer.parseInt(st.nextToken()); // 초밥의 총 개수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 종류의 수
		int k = Integer.parseInt(st.nextToken()); // 연속적으로 먹을 초밥의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		int answer = 0;
		Set<Integer> set = new HashSet<>();
		
		// 초밥을 리스트에 저장
		for(int i=0; i<n; i++) {
			sushiList.add(Integer.parseInt(br.readLine()));
		}
		
		Queue<Integer> eatList = new LinkedList<>(); // 먹은것에 대한 큐 생성
		
		for(int i=0; i<k; i++) { // k개를 이미 먹었습니다.
			set.add(sushiList.get(i));
			eatList.offer(sushiList.get(i));
		}
		
		for(int idx = k; idx<=n+k-2; idx++) {
			
			// 1. k개 먹었으니 쿠폰 ---> 쿠폰 확인 후 count
			if(!set.contains(c)) { // 쿠폰이 내가 먹지 않은 종류인 경우
				answer = Math.max(answer, set.size()+1);
				if(answer == k+1) { break; } // 먹을 수 있는 최상의 것
			} else {
				answer = Math.max(answer, set.size());
			}
			
			// 2. 처음 먹은 것 안먹은 것으로
			int deleteSushi = eatList.remove();
			if(!eatList.contains(deleteSushi)) {
				set.remove(deleteSushi);
			}
			
			// 3. 앞에 먹을 것 추가
			int sushi = sushiList.get(idx%n);
			
			eatList.offer(sushi);
			set.add(sushi);
		}
		
		System.out.println(answer);
	}
}
