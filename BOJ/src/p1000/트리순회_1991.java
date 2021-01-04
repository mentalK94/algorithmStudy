/**
 * Backjoon - 1991. 트리 순회
 * 트리순회_1991.java
 * @date 2021-01-04
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 트리순회_1991 {
	
	private static class Node {
		char data;
		Node left;
		Node right;
		
		public Node(char data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public void setRight(Node node) {
			this.right = node;
		}
		
		public void setLeft(Node node) {
			this.left = node;
		}
	}

	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 노드의 개수
		
		Node root = new Node('A', null, null);
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			addChild(root, parent, left, right);
		}
		
		sb = new StringBuilder();
		
		// 전위순회(preOrder)
		preOrder(root);
		sb.append("\n");
		// 중위순회(inOrder)
		inOrder(root);
		sb.append("\n");
		// 후위순회(postOrder)
		postOrder(root);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void postOrder(Node node) {
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.data);
	}

	private static void inOrder(Node node) {
		if(node == null) return;
		
		inOrder(node.left);
		sb.append(node.data);
		inOrder(node.right);
	}

	private static void preOrder(Node node) {
		if(node == null) return;
		
		sb.append(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void addChild(Node node, char parent, char left, char right) {
		if(node == null) { return;}
		if(node.data == parent) { // 현재 찾는 데이터와 같으면
			if(left != '.') { node.setLeft(new Node(left, null, null)); } // 왼쪽 노드 생성
			if(right != '.') { node.setRight(new Node(right, null, null)); } // 오른쪽 노드 생성
			return;
		}
		
		addChild(node.left, parent, left, right);
		addChild(node.right, parent, left, right);
	}
}