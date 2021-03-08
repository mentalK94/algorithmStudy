package algorithms;

import java.util.ArrayList;

public class LowerBoundTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(4);
		list.add(6);
		
		int idx = lowerBound(list, 100);
		System.out.println(idx);
		int answer = list.size() - idx;
		System.out.println(answer);

	}

	private static int lowerBound(ArrayList<Integer> pointList, int point) {		
		int left = 0;
		int right = pointList.size()-1;
		
		if(pointList.get(right) < point) { return pointList.size(); }
		
		while(left<right) {
			int mid = (left+right)/2;
			
			if(pointList.get(mid) < point) {
				left = mid+1;
			} else {
				right = mid; 
			}
		}
				
		return right;
	}
}
