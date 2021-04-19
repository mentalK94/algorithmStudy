package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Heap {
	
	private static ArrayList<Integer> heap;
	
	public static void main(String[] args) throws Exception {
		heap = new ArrayList<>();
		heap.add(-1);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) {
			int val = Integer.parseInt(st.nextToken());
			insertMaxHeap(val);
			System.out.println(heap);
		}
		
		for(int i=0; i<N; ++i) {
			System.out.println(deleteMaxHeap());
		}
	}
	
	private static int deleteMaxHeap() {
		
		if(heap.size() <= 1) { return 0; }
		int val = heap.get(1);
		
		// 삭제된 루트노드에는 힙의 마지막 노드를 가져온다
		int end = heap.get(heap.size()-1);
		heap.set(1, end);
		
		// 마지막 노드 삭제
		heap.remove(heap.size()-1);
		
		// 힙 재구성
		int parent = 1;
		while(parent*2 < heap.size()) {
			
			int max = heap.get(parent*2);
			int idx = parent*2;
			// 왼쪽노드와 비교
			if(parent*2+1 < heap.size() && max < heap.get(parent*2+1)) {
				max = heap.get(parent*2+1);
				idx = parent*2+1;
			}
			
			if(heap.get(parent) > max) {
				break;
			}
			
			int temp = heap.get(parent);
			heap.set(parent, max);
			heap.set(idx, temp);
			parent = idx;
		}
		
		
		return val;
	}

	private static void insertMaxHeap(int val) {
		// 마지막 인덱스에 val값 추가
		heap.add(val);
		int idx = heap.size()-1;
		
		// 부모노드와 비교하면서 더 큰 경우 자리변경
		while(idx>1 && heap.get(idx/2)<val) {
			int temp = heap.get(idx/2);
			heap.set(idx/2, val);
			heap.set(idx, temp);		
			
			idx /= 2;
		}
		
	}
}
