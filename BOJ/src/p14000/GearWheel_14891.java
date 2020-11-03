package p14000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GearWheel_14891 {

	static int[][] gears, gearIdx;
	static final int GEAR_CNT=4;
	static final int WHEEL_CNT=8;
	static int[] point = {1,2,4,8};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		gears = new int[GEAR_CNT][WHEEL_CNT];
		gearIdx = new int[GEAR_CNT][3]; // 각 톱니바퀴의 12시방향 인덱스, 맞닿아 있는 부분(왼쪽), 맞닿아 있는 부분(오른쪽)
		
		for(int i=0; i<GEAR_CNT; i++) {
			String info = br.readLine();
			for(int j=0; j<info.length(); j++) {
				gears[i][j] = info.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<GEAR_CNT; i++) {
			gearIdx[i][0] = 0; // 12시방향 인덱스
			gearIdx[i][1] = 6; // 왼쪽 톱니 인덱스
			gearIdx[i][2] = 2; // 오른쪽 톱니 인덱스
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gearNum = Integer.parseInt(st.nextToken())-1; // 회전시킬 톱니바퀴
			int rotateType = Integer.parseInt(st.nextToken()); // 회전방향
			
			// 양쪽방향 톱니바퀴 회전
			// 왼쪽방향
			int curNum = gearNum;
			int leftNum = gearNum-1;
			int lType = rotateType*(-1);
			ArrayList<int[]> rotateList = new ArrayList<>();
			rotateList.add(new int[] {gearNum, rotateType});
			while(leftNum>=0) {
				// 현재 톱니바퀴의 왼쪽과 왼쪽톱니바퀴의 오른쪽 비교 -> 같은 극이면 회전하지 않으므로 나머지도 마찬가지로 회전 X
				if(gears[curNum][gearIdx[curNum][1]] == gears[leftNum][gearIdx[leftNum][2]]) { break;}
				
				// 회전하는 경우
				rotateList.add(new int[] {leftNum, lType});
				curNum = leftNum;
				leftNum = curNum-1;
				lType *= (-1);
			}
			
			// 오른쪽방향
			curNum = gearNum;
			int rightNum = gearNum+1;
			int rType = rotateType*(-1);
			
			while(rightNum<GEAR_CNT) {
				// 현재 톱니바퀴의 오른쪽과 오른쪽톱니바퀴의 왼쪽 비교 -> 같은 극이면 회전하지 않으므로 나머지도 마찬가지로 회전 X
				if(gears[curNum][gearIdx[curNum][2]] == gears[rightNum][gearIdx[rightNum][1]]) { break;}
				
				// 회전하는 경우
				rotateList.add(new int[] {rightNum, rType});
				curNum = rightNum;
				rightNum = curNum+1;
				rType *= (-1);
			}
			
			// 현재 해당되는 톱니바퀴 회전
			for(int j=0; j<rotateList.size(); j++) {
				rotate(rotateList.get(j)[0], rotateList.get(j)[1]);
			}
		}
		
		int answer = 0;
		for(int i=0; i<4; i++) {
			if(gears[i][gearIdx[i][0]] == 1) {
				answer += point[i];
			}
		}
		
		System.out.println(answer);
		br.close();
	}

	private static void rotate(int gn, int type) {
		if(type == 1) { // 시계방향
			gearIdx[gn][0] = gearIdx[gn][0]-1 < 0 ? WHEEL_CNT-1 : gearIdx[gn][0]-1;
			gearIdx[gn][1] = gearIdx[gn][1]-1 < 0 ? WHEEL_CNT-1 : gearIdx[gn][1]-1;
			gearIdx[gn][2] = gearIdx[gn][2]-1 < 0 ? WHEEL_CNT-1 : gearIdx[gn][2]-1;
		} else { // 반시계방향
			gearIdx[gn][0] = gearIdx[gn][0]+1 == WHEEL_CNT ? 0 : gearIdx[gn][0]+1;
			gearIdx[gn][1] = gearIdx[gn][1]+1 == WHEEL_CNT ? 0 : gearIdx[gn][1]+1;
			gearIdx[gn][2] = gearIdx[gn][2]+1 == WHEEL_CNT ? 0 : gearIdx[gn][2]+1;
		}
	}

}
