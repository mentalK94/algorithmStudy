
public class Problem2 {

	public static void main(String[] args) {
		
		Problem2Solution problem2Solution = new Problem2Solution();
		int [][] target = {{0, 1}, {-1, 1}, {1, 0}, {-2, 2}};
		problem2Solution.solution(-1, 2, 2, 60, target);
	}

}

class Problem2Solution {
	int solution(int x, int y, int r, int d, int[][] target) {
		int answer = 0;
		double angle = ((Math.atan2(x, y)) * 180/Math.PI); // x, y값에 따른 각도
		double dist = Math.sqrt(x*x + y*y);
		double pointAngle = 0; 
		double pointDist = 0;
				
		for(int i=0; i<target.length; i++) {
			// 1. 거리 계산
			pointDist = Math.sqrt((target[i][0])*(target[i][0])
					+ (target[i][1])*(target[i][1]));
			
			if(dist < pointDist) {
				continue;
			}
			
			// 2. 각도 계산
			pointAngle = ((Math.atan2(target[i][0], target[i][1])) * 180/Math.PI);
			if(!(pointAngle <= (angle+d) && pointAngle >= (angle-d))) {
				continue;
			}
			answer++; // 거리와 각도 모두 만족
			System.out.println(target[i][0] + ", " + target[i][1]);
		}
		
		return answer;
	}
}