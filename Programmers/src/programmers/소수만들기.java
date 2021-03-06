/**
 * programmers - Summer/Winter Coding(~2018). 소수만들기
 * 폰소수만들기켓몬.java
 * @date 2021-03-06
 * @author hansolKim
 **/

package programmers;

public class 소수만들기 {

	public static void main(String[] args) {
		소수만들기 소수만들기 = new 소수만들기();
		int[] nums = {1,2,7,6,4};
		소수만들기.solution(nums);
	}
	
	public int solution(int[] nums) {
        
        int cnt = 0;

        for(int i=0; i<nums.length; i++) {
        	for(int j=i+1; j<nums.length; j++) {
        		if(i == j) continue;
        		for(int k=j+1; k<nums.length; k++) {
                	if(i == k || j == k) continue;
                	int num = nums[i] + nums[j] + nums[k];
                	if(isPrime(num)) {
                		cnt++;
                	}
                }
            }        	
        }
                
        return cnt;
    }

	private boolean isPrime(int num) {
		
		int end = (int) Math.sqrt(num)+1;
		
		for(int i=2; i<=end; i++) {
			if(num % i==0) return false;
		}

		return true;
	}

}
