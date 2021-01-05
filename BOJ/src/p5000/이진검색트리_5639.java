/**
 * Backjoon - 5639. 이진 검색 트리
 * 이진검색트리_5639.java
 * @date 2021-01-05
 * @author hansolKim
 **/

package p5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 이진검색트리_5639 {

	static class Node {
		Node left;
		Node right;
		int value;
		
		public Node(int value) {
			this.value = value;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}
		
		public void setRight(Node right) {
			this.right = right;
		}
	}
	
	static Node node;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		node = new Node(Integer.parseInt(br.readLine())); // 루트노드 생성
		String input = "";
		
		while((input=br.readLine())!=null) {
			int value = Integer.parseInt(input);
			setNode(node, value);
		}
		
		sb = new StringBuilder();
		postOrder(node);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void postOrder(Node node) {
		if(node == null) {
			return; 
		}
		
		// 왼쪽노드 탐색
		postOrder(node.left);
		// 오른쪽 노드 탐색
		postOrder(node.right);
		// 현재노드 저장
		sb.append(node.value).append("\n");
	}

	private static void setNode(Node node, int value) {
		
		if(value < node.value) { 
			if(node.left == null) { node.setLeft(new Node(value)); }
			else { setNode(node.left, value); } 
		}
		else {
			if(node.right == null) { node.setRight(new Node(value)); }
			else { setNode(node.right, value); }
		}
	}
}