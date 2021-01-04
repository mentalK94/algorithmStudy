/**
 * Backjoon - 1068. 트리
 * 트리_1068.java
 * @date 2021-01-04
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 트리_1068 {

	static LinkedList<Integer>[] tree;
	static int[] leafNodeCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		tree = new LinkedList[N+1];
		
		for(int i=0; i<=N; i++) { tree[i] = new LinkedList<>();}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> parents = new HashMap<>();
		for(int i=1; i<=N; i++) {
			int parent = Integer.parseInt(st.nextToken())+1;
			tree[parent].add(i);
			parents.put(i, parent);
		}
		
		int root = tree[0].get(0);
		int removeNode = Integer.parseInt(br.readLine())+1;
		
		leafNodeCnt = new int[N+1];
		
		int removeParentNode = parents.get(removeNode);
		for(int i=0; i<tree[removeParentNode].size(); i++) {
			if(tree[removeParentNode].get(i) == removeNode) {
				tree[removeParentNode].remove(i);
				break;
			}
		}
		getLeafNodeCnt(root);
		
		System.out.println(leafNodeCnt[root]-leafNodeCnt[removeNode]);
		br.close();
	}

	private static int getLeafNodeCnt(int node) {
		if(tree[node].size() == 0) { // 자식노드가 없는 경우
			return leafNodeCnt[node] = 1;
		}
		
		int leafCnt = 0;
		for(int childNode : tree[node]) {
			leafCnt += getLeafNodeCnt(childNode); // 해당 자식노드의 리프노드 모두 더하기
		}
		
		return leafNodeCnt[node] = leafCnt;		
	}

}
