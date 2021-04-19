package algorithms;

import java.util.Arrays;

public class MergeSort {

	static int[] sorted;
	
	public static void main(String[] args) {
		int[] list = {1,5,3,2,8,4,9,6,7,6,4};
		
		sorted = new int[list.length];
		mergeSort(list, 0, list.length-1);
		
		System.out.println(Arrays.toString(sorted));
	}

	private static void mergeSort(int[] list, int left, int right) {
		int mid = (left+right)/2;
		
		if(left < right) {
			mergeSort(list, left, mid);
			mergeSort(list, mid+1, right);
			merge(list, left, mid, right);
		}
	}

	private static void merge(int[] list, int left, int mid, int right) {
		int i = left;
		int j = mid+1;
		int k = left;
		
		while(i<=mid && j<=right) {
			if(list[i] <= list[j]) {
				sorted[k++] = list[i++];
			} else {
				sorted[k++] = list[j++];
			}
		}
		  
		if(i>mid) {
			for(int idx=j; idx<=right; ++idx) { sorted[k++] = list[idx]; }
		} else {
			for(int idx=i; idx<=mid; ++idx) { sorted[k++] = list[idx]; }
		}				
		
		for(int idx=left; idx<=right; ++idx) {
			list[idx] = sorted[idx];
		}
	}	
}