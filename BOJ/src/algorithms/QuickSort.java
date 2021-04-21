package algorithms;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] list = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		quickSort(list, 0, list.length - 1);

		System.out.println(Arrays.toString(list));
	}

	private static void quickSort(int[] list, int left, int right) {

		if (left < right) {
			int pivot = partition(list, left, right);

			quickSort(list, left, pivot - 1);
			quickSort(list, pivot + 1, right);
		}
	}

	private static int partition(int[] list, int left, int right) {

		System.out.println(left + " " + right);
		// 가장 왼쪽데이터를 피벗으로 선택
		int pivot = list[left];
		int lIdx = left;
		int rIdx = right + 1;

		do {
			/* list[low]가 피벗보다 작으면 계속 low를 증가 */
			do {
				lIdx++; // low는 left+1 에서 시작
			} while (lIdx <= right && list[lIdx] < pivot);

			/* list[high]가 피벗보다 크면 계속 high를 감소 */
			do {
				rIdx--; // high는 right 에서 시작
			} while (rIdx >= left && list[rIdx] > pivot);

			// 만약 low와 high가 교차하지 않았으면 list[low]를 list[high] 교환
			if (lIdx < rIdx) {
				int temp = list[lIdx];
				list[lIdx] = list[rIdx];
				list[rIdx] = temp;
			}
		} while (lIdx < rIdx);

		// low와 high가 교차했으면 반복문을 빠져나와 list[left]와 list[high]를 교환
		int temp = list[left];
		list[left] = list[rIdx];
		list[rIdx] = temp;
		// 피벗의 위치인 high를 반환
		System.out.println(Arrays.toString(list));
		return rIdx;
	}
}