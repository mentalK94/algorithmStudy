/**
 * Backjoon - 10775. 공항
 * 공항_10775.java
 * @date 2020-12-17
 * @author hansolKim
 **/

package p10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 공항_10775 {

	static int[] parents;
	static int G, P, answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(br.readLine()); // 공항
		P = Integer.parseInt(br.readLine()); // 비행기 수
		
		init(); // parents배열 초기화
		
		answer = 0;
		for(int i=0; i<P; i++) {
			int planeNum = Integer.parseInt(br.readLine()); // 비행기 번호
			int gate = getParents(planeNum);
			if(gate == -1) { // 도킹할 수 없는 경우 -> 공항폐쇄
				break;
			}
			
			docking(gate); // 해당 idx게이트에 도킹
		}
		
		System.out.println(answer);
		br.close();
	}

	private static void docking(int gate) {
		answer++; // 도킹한 비행기 수 증가
		if(gate == 1) { parents[gate] = -1; }
		else {
			int nextGate = getParents(gate-1);
			parents[gate] = nextGate;
		}
	}

	private static int getParents(int num) {
		if(num == -1) return num;
		if(parents[num] == num) return num;
		return parents[num] = getParents(parents[num]);
	}

	private static void init() {
		parents = new int[G+1];
		for(int i=1; i<=G; i++) {
			parents[i] = i;
		}
	}
}