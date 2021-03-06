/**
 * Backjoon - 15686. 치킨 배달
 * ChickenDelivery_15686.java
 * @date 2020-08-25
 * @author hansolKim
 **/

package p15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Address {
	int x;
	int y;

	public Address(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class ChickenDelivery_15686 {

	private static int answer = Integer.MAX_VALUE;
	private static int N, M; // N: 배열의 크기, M: 운영할 치킨집의 갯수
	private static ArrayList<Address> chickens = new ArrayList<>(); // 치킨집 좌표 리스트
	private static ArrayList<Address> homes = new ArrayList<>(); // 일반집 좌표 리스트
	private static int[] numbers; // 운영한 치킨집의 인덱스 리스트

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer init = new StringTokenizer(br.readLine());
		N = Integer.parseInt(init.nextToken());
		M = Integer.parseInt(init.nextToken());

		/** data삽입 */
		for (int i = 0; i < N; i++) {

			String[] data = br.readLine().split(" ");

			for (int j = 0; j < N; j++) {
				if (data[j].equals("1")) { // 일반 집인 경우
					homes.add(new Address(i, j));
				} else if (data[j].equals("2")) { // 치킨 집인 경우
					chickens.add(new Address(i, j));
				}
			}
		}

		numbers = new int[M];

		/** 조합함수 호출 */
		combination(0, 0);

		System.out.println(answer);
	}

	private static void combination(int cnt, int start) {
		if (cnt == M) {
			int distance = 0;
			
			/* 일반 집 탐색해서 운영하고 있는 치킨집과의 거리 중 최소값 계산  */
			for(int i=0; i<homes.size(); i++) {
				int homeX = homes.get(i).x;
				int homeY = homes.get(i).y;
				int dist = Integer.MAX_VALUE;
				
				for(int j=0; j<M; j++) { // 운영하고 있는 치킨집 -> numbers배열 인덱스 이용
					int chickenX = chickens.get(numbers[j]).x;
					int chickenY = chickens.get(numbers[j]).y;
					dist = Math.min(dist,
							getDistance(homeX, homeY, chickenX, chickenY));
				}
				distance += dist;
			}
			answer = Math.min(answer, distance);
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}

	}
	
	/** 좌표값 거리계산 */
	private static int getDistance(int a, int b, int x, int y) {
		return Math.abs(a-x) + Math.abs(b-y);
	}
}
