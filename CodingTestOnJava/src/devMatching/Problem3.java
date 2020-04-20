package devMatching;

public class Problem3 {

	public static void main(String[] args) {
		Problem3Solution problem3Solution = new Problem3Solution();

		int [] numbers = { 3,7,2,8,6,4,5,1 };

		int K = 3;
		System.out.println(problem3Solution.solution(numbers, K));
	}
}

class Problem3Solution {
	public int solution(int[] numbers, int K) {
		int answer = 0;
		int min = 100;
		int temp;
		boolean flag = false;
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] >= numbers[j]) {
					temp = numbers[i] - numbers[j];
				} else {
					temp = numbers[j] - numbers[i];
				}
				if (min > temp) {
					min = temp;
				}
			}
		}

		if (min > K) {
			return -1;
		}

		for (int i = 0; i < numbers.length - 1; i++) {
			
			for(int k=0; k<numbers.length; k++) {
				System.out.print(numbers[k]+" ");
			}
			System.out.println();

			if (isSuccess(numbers, i, K)) { // 이상 없는 경우
				continue;
			} else { // 이상 있는 경우

				for (int j = 0; j < numbers.length; j++) {
					if (i == j) {
						continue;
					}
					swapNumber(numbers, i, j);
					if (isSuccess(numbers, i, K) && isSuccess(numbers, j, K)) {
						answer++;
						flag = true;
						break;
					}
					swapNumber(numbers, i, j);
				}
				if(flag) {continue;}
				
				if (i != 0) {
					for (int j = 0; j < numbers.length; j++) {
						if (i - 1 == j) {
							continue;
						}
						swapNumber(numbers, i-1, j);
						if (isSuccess(numbers, i - 1, K) && isSuccess(numbers, j, K)) {
							answer++;
							flag = true;
							break;
						}
						swapNumber(numbers, j, i-1);
					}
				}				
				
				if(flag) {continue;}
				if (i != numbers.length - 1) {
					for (int j = 0; j < numbers.length; j++) {
						if (i + 1 == j) {
							continue;
						}
						swapNumber(numbers, i+1, j);
						if (isSuccess(numbers, i + 1, K) && isSuccess(numbers, j, K)) {
							answer++;
							break;
						}
						swapNumber(numbers, j, i+1);
					}
				}

			}
		}

		return answer;
	}

	public void swapNumber(int[] numbers, int a, int b) {
		int temp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = temp;
	}

	public boolean isSuccess(int[] numbers, int idx, int K) {

		int number = 0;
		int number2 = 0;
		if (idx == 0) {
			if (numbers[idx] >= numbers[idx + 1]) {
				number = numbers[idx] - numbers[idx + 1];
			} else {
				number = numbers[idx + 1] - numbers[idx];
			}
			// System.out.println(number + "," + K);
			if (number > K) {
				return false;
			}
			return true;
		}

		if (idx == numbers.length - 1) {
			if (numbers[idx] >= numbers[idx - 1]) {
				number = numbers[idx] - numbers[idx - 1];
			} else {
				number = numbers[idx - 1] - numbers[idx];
			}
			if (number > K) {
				return false;
			}
			return true;
		}

		if (numbers[idx] >= numbers[idx - 1]) {
			number = numbers[idx] - numbers[idx - 1];
		} else {
			number = numbers[idx - 1] - numbers[idx];
		}
		if (numbers[idx] >= numbers[idx + 1]) {
			number2 = numbers[idx] - numbers[idx + 1];
		} else {
			number2 = numbers[idx + 1] - numbers[idx];
		}

		if (number <= K && number2 <= K) {
			return true;
		}
		return false;
	}
}
