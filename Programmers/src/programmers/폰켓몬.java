/**
 * programmers - 찾아라 프로그래밍 마에스터. 폰켓몬
 * 폰켓몬.java
 * @date 2021-03-06
 * @author hansolKim
 **/

package programmers;

import java.util.HashSet;

public class 폰켓몬 {

	public static void main(String[] args) {
		폰켓몬 폰켓몬 = new 폰켓몬();
		int[] nums = {3,3,3,2,2,2};
		폰켓몬.solution(nums);
	}
	
	public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>(); 
        for(int num : nums) {
        	set.add(num);
        }
        
        answer = nums.length/2 < set.size() ? nums.length/2 : set.size();
        System.out.println(answer);
        return answer;
    }
}
