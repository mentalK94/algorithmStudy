/**
 * Backjoon - 15961. 회전 초밥
 * RotateSushi_15961.java
 * @date 2020-08-28
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//최대로 먹는 경우 총 k+1개의 초밥을 먹는다.
public class RotateSushi_15961 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> sushiList = new ArrayList<>(); 
		
		int n = Integer.parseInt(st.nextToken()); // 초밥의 총 개수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 종류의 수
		int k = Integer.parseInt(st.nextToken()); // 연속적으로 먹을 초밥의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		int startIdx = 0;
		int finishIdx = 0;
		int answer = 0;
		boolean isEat = false;
		
		// 초밥을 리스트에 저장
		for(int i=0; i<n; i++) {
			sushiList.add(Integer.parseInt(br.readLine()));
		}
		
		Queue<Integer> eatList = new LinkedList<>(); // 먹은것에 대한 큐 생성
		
		while(startIdx <= n) {
			
			int sushi = sushiList.get(finishIdx);
			
			// 1. 현재 초밥이 내가 먹은리스트에 있는 지 확인한다. 단, 내가 먹은 초밥이 k개 이상이면 안된다.
			if(!eatList.contains(sushi) && eatList.size()<k) { // 1-1. (없음) 먹는다 ---> 큐에 넣는다.
				eatList.offer(sushi);
				finishIdx++;
				if(finishIdx == n) { finishIdx = 0; } // 원형이므로 				
				if(eatList.size() == k) { // 내가 연속적으로 먹은 초밥이 k개인 경우
					if(!eatList.contains(c)) { // 2-1. 쿠폰이 내가 먹은 초밥이 아닐 때 ---> 최대로 먹을 수 있는 경우
						answer = k+1;
						break;
					} else { // 2-2. 쿠폰이 이미 내가 먹었던 것인 경우
						eatList.poll();
						startIdx++;
						isEat = true;
					}
					
				}
				
				// 3. answer의 값을 갱신한다.
				if(isEat) {
					answer = Math.max(answer, eatList.size()+1);
					isEat = false;
				} else {
					answer = Math.max(answer, eatList.size());	
				}
				
			}  else { // 1-2. (있음) 전에 먹었던 것을 빼줌
				while(!eatList.isEmpty()) {
					int remove = eatList.poll();
					startIdx++; // 처음 먹었던것을 안먹었던것으로 하기때문에 idx 증가
					if(remove == sushi) { // 중복된 것을 찾은 경우
						break;
					}
				}
				
			}		
			
			
			
		}
		
		System.out.println(answer);
	}
}
