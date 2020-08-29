package day0829;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	private static int count = 0;
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int num = 18;
		int[] cards = { 1, 2, 5 };
		s.solution(num, cards);
	}

	private static int answer = Integer.MAX_VALUE;
	private static List<Integer> cardList;

	public int solution(int num, int[] cards) {

		cardList = new ArrayList<>();

		for (int i = 0; i < cards.length; i++) {
			cardList.add(cards[i]);
		}

		Collections.sort(cardList, Collections.reverseOrder());

		selectCard(0, num, 0);

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
			return -1;
		} else {
			System.out.println(answer);
			return answer;
		}

	}

	private void selectCard(int idx, int value, int step) { // idx : 현재카드 인덱스, step : 카드를 사용한 횟수
        System.out.println(++count);
        if(value == 0) { // 성공한 경우
            answer = Math.min(answer, step);
            return;
        }

        if(value-cardList.get(idx) >= 0 && step+1 < answer) {
            selectCard(idx, value-cardList.get(idx), step+1); // 현재카드를 사용한 경우
        }

        if(idx+1 < cardList.size() && value/cardList.get(idx) < answer) {
            selectCard(idx+1, value, step); // 현재카드를 사용하지 않은 경우
        }
    }

}
