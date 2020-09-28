import java.util.Arrays;

public class Solution2 {

	public static void main(String[] args) {
		Solution2 s2 = new Solution2();
		int[][] blocks = {{0, 50}, {0, 22}, {2, 10}, {1, 4}, {4, -13}};
		System.out.println(Arrays.toString(s2.solution(blocks)));
	}
	
	public int[] solution(int[][] blocks) {
		
		int[][] map = new int[blocks.length][];
		
		for(int i=1; i<=blocks.length; i++) {
			map[i-1] = new int[i];
		}
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				map[i][j] = 101;
			}
		}
		
		for(int i=0; i<blocks.length; i++) {
			map[i][blocks[i][0]] = blocks[i][1];
		}
		
		
		for(int i=1; i<map.length; i++) {
			// 유효숫자 찾기
			int idx = 0;
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] != 101) {
					idx = j;
				}
			}
			
			// 유효숫자를 기준으로 좌우로 채워넣기
			// 왼쪽 탐색
			while(idx>0) {
				idx--;
				map[i][idx] = map[i-1][idx]-map[i][idx+1];
			}
			
			// 오른쪽 탐색
			while(idx<map[i].length-1) {
				idx++;
				map[i][idx] = map[i-1][idx-1]-map[i][idx-1];
			}
		}
		
		int[] answer = new int[(blocks.length*(blocks.length+1))/2];
		
		int answerIdx = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				answer[answerIdx++] = map[i][j];
			}
		}
		return answer;
	}

}
