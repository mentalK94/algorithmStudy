/**
 * Backjoon - 16235. 나무 재테크
 * 나무재테크_16235.java
 * @date 2020-12-22
 * @author hansolKim
 **/

package p16000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무재테크_16235 {
	
	static int N, M, K; // N:땅의 크기, M:심을 나무의 개수, K:K년 후
	static int[][] map, A; // 땅의 양분 정보, 겨울에 추가되는 양분정보
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	static LinkedList<int[]> trees;
	static Queue<int[]> deadTrees;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 겨울에 추가되는 양분정보 입력
		// 상도의 땅 기본 세팅
		A = new int[N][N];
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5; // 초기 양분의 값
			}
		}
		
		trees = new LinkedList<>();
		
		// 상도가 심은 나무정보
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1; // 나무의 x위치
			int y = Integer.parseInt(st.nextToken())-1; // 나무의 y위치
			int z = Integer.parseInt(st.nextToken()); // 나무의 나이
			
			trees.add(new int[] {x, y, z});
		}
		
		deadTrees = new LinkedList<>();
		
		trees.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		
		while(K-->0) {
			// 1. 봄 -> 자신의 나이만큼 양분을 먹고 나이 증가
			spring();
			
			// 2. 여름 -> 죽은 나무가 양분으로 변함
			summer();
			
			// 3. 가을 -> 나무 번식
			autumn();
			
			// 4. 겨울 -> 양분 추가
			winter();
		}
		
		System.out.println(trees.size());
		br.close();
	}

	private static void winter() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] += A[i][j];
			}
		}
	}

	private static void autumn() {
		
		Queue<int[]> temp = new LinkedList<>();
		int size = trees.size();
		
		for(int i=0; i<size; i++) {
			int x = trees.peek()[0];
			int y = trees.peek()[1];
			int z = trees.poll()[2];
			
			if(z%5 == 0) { // 5의 배수인 경우
				for(int j=0; j<8; j++) {
					int nx = x+dx[j];
					int ny = y+dy[j];
					
					if(nx<0 || nx>=N || ny<0 || ny>=N) continue; // 영역 밖을 벗어난 경우
					
					temp.add(new int[] {nx, ny, 1});
				}
				
			}
			trees.add(new int[] {x, y, z});
		}
		
		while(!temp.isEmpty()) { trees.addFirst(temp.poll()); }
	}

	private static void summer() {
		while(!deadTrees.isEmpty()) {
			int x = deadTrees.peek()[0];
			int y = deadTrees.peek()[1];
			int z = deadTrees.poll()[2];
			
			map[x][y] += (z/2);
		}
	}

	private static void spring() {
		
		int size = trees.size();
		
		for(int i=0; i<size; i++) {
			int x = trees.peek()[0];
			int y = trees.peek()[1];
			int z = trees.poll()[2];
			
			if(z<=map[x][y]) { // 먹을 수 있는 양분이 있는 경우
				map[x][y] -= z;
				trees.add(new int[] {x, y, z+1});
			} else { // 먹을 수 있는 양분이 없는 경우
				deadTrees.add(new int[] {x, y, z});
			}
		}
		
	}
}