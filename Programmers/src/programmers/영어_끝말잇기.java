/**
 * programmers - 영어 끝말잇기
 * 영어_끝말잇기.java
 * @date 2021-03-18
 * @author hansolKim
 **/

package programmers;

import java.util.*;

public class 영어_끝말잇기 {

	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];

		Set<String> set = new HashSet<>();

		String preWord = words[0];
		set.add(preWord);

		for (int i = 1; i < words.length; ++i) {
			String word = words[i];
			if (set.contains(word) || preWord.charAt(preWord.length() - 1) != word.charAt(0)) { // 이미 사용한 경우
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				break;
			}

			preWord = word;
			set.add(word);
		}

		return answer;
	}

}
