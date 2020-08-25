/**
 * 
 * @Date 2020-08-25
 * @author hansol kim
 * @class BinarySearchTest.java
 * @with ssafy
 * 
 * */

package algorithms;

import java.util.Arrays;

public class BinarySearchTest {
	

	private static int[] val= {3, 11, 15, 20, 21, 29, 45, 59, 65, 72};
	
	public static void main(String[] args) {
		System.out.println(binarySearch(46, 0, val.length-1));
		System.out.println(Arrays.binarySearch(val, 46));
	}

	private static int binarySearch(int target, int start, int end) {
		
		if(start<=end) {
			int mid = (start+end)/2;
			
			if(val[mid] == target) return mid;
			if(val[mid] < target) {
				return binarySearch(target, mid+1, end);
			} else {
				return binarySearch(target, start, mid-1);
			}
		}
		
		return -1;
	}

}
