/**
 * Backjoon - 2257. 화학식량
 * 화학식량_2257.java
 * @date 2020-12-30
 * @author hansolKim
 **/

package p17000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 이차원배열의연산_17140 {

	static int r, c, k;
	static int[][] map;
	static int rowCnt, colCnt; // 행의 개수, 열의 개수
	static HashMap<Integer, Integer> hmap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[100][100];

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rowCnt = 3;
		colCnt = 3;		

		int time = 0;

		hmap = new HashMap<>();
		while (true) {
			if(map[r][c] == k || ++time>100) { break; }

			if (rowCnt >= colCnt) { // R연산
				R();
			} else { // C연산
				C();
			}
			
		}

		time = time > 100 ? -1 : time;
		System.out.println(time);
		br.close();
	}

	private static void R() {
		for (int i = 0; i < rowCnt; i++) {
			for (int j = 0; j < colCnt; j++) {
				if (map[i][j] == 0)
					continue;
				int cnt = 1;
				if (hmap.containsKey(map[i][j])) {
					cnt = hmap.get(map[i][j]) + 1;
				}

				hmap.put(map[i][j], cnt);
			}

			int[][] data = new int[hmap.size()][2]; // 수, 등장횟수
			int idx = 0;
			for (int key : hmap.keySet()) {
				data[idx][0] = key;
				data[idx++][1] = hmap.get(key);
			}

			Arrays.sort(data, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) { // 등장횟수가 같을 때
						return Integer.compare(o1[0], o2[0]);
					}
					return Integer.compare(o1[1], o2[1]); // 등장횟수 오름차순
				}
			});

			for (int j = 0; j < colCnt; j++) {
				map[i][j] = 0;
			}

			int tempCnt = 0;
			
			for (int j = 0; j < data.length && 2 * j + 1 < 100; j++) {
				map[i][2 * j] = data[j][0];
				map[i][2 * j + 1] = data[j][1];
				tempCnt+=2;
			}

			colCnt = colCnt < tempCnt? tempCnt : colCnt;
			hmap.clear();
		}
	}
	
	private static void C() {
		for (int i = 0; i < colCnt; i++) {
			for (int j = 0; j < rowCnt; j++) {
				if (map[j][i] == 0)
					continue;
				int cnt = 1;
				if (hmap.containsKey(map[j][i])) {
					cnt = hmap.get(map[j][i]) + 1;
				}

				hmap.put(map[j][i], cnt);
			}

			int[][] data = new int[hmap.size()][2]; // 수, 등장횟수
			int idx = 0;
			for (int key : hmap.keySet()) {
				data[idx][0] = key;
				data[idx++][1] = hmap.get(key);
			}

			Arrays.sort(data, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) { // 등장횟수가 같을 때
						return Integer.compare(o1[0], o2[0]);
					}
					return Integer.compare(o1[1], o2[1]); // 등장횟수 오름차순
				}
			});

			for (int j = 0; j < rowCnt; j++) {
				map[j][i] = 0;
			}

			int tempCnt = 0;
			
			for (int j = 0; j < data.length && 2 * j + 1 < 100; j++) {
				map[2*j][i] = data[j][0];
				map[2*j+1][i] = data[j][1];
				tempCnt+=2;
			}

			rowCnt = rowCnt < tempCnt? tempCnt : rowCnt;
			hmap.clear();
		}

	}
}
