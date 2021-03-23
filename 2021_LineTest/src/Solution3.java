import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {
		Solution3 s3 = new Solution3();
		int[] enter = {1,3,2};
		int[] leave = {1,2,3};
		s3.solution(enter, leave);
	}
	
	public int[] solution(int[] enter, int[] leave) {        
        
        // leave배열의 위치값 기억
        int[] loc = new int[leave.length+1];
        
        for(int i=0; i<leave.length; i++) {
        	loc[leave[i]] = i;
        }
        
        int[] cnt = new int[enter.length+1]; 
        for(int i=0; i<enter.length; ++i) {
        	int num = enter[i];
        	
        	for(int j=enter.length-1; j>i; --j) {
        		if(loc[num]>loc[enter[j]]) {        			
        			while(j>i) {
        				System.out.println(num + " " + enter[j]);
        				cnt[num]++;
        				cnt[enter[j]]++;
        				j--;
        			}
        		}
        	}
        }
        
        int[] answer = new int[cnt.length-1];
        for(int i=1; i<cnt.length; ++i) {
        	answer[i-1] = cnt[i];
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
