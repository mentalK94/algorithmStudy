package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Truck {

	public static void main(String[] args) {
		TruckSolution truckSolution = new TruckSolution();
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };
		System.out.println(truckSolution.solution(bridge_length, weight, truck_weights));

	}

}

class TruckSolution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int curWeight = 0;  // ���� �ٸ����� ���ߵǾ� �ִ� ����
		int i = 0; // 		
		LinkedList<Integer> trucks = new LinkedList<>();		
		
		while(true) {
						
			// 1. �ٸ����� �������� Ʈ��
			if(trucks.size() == bridge_length) {
				curWeight -= trucks.pollFirst();
			}
			
			// 2. Ʈ���� �߰��� �� �ִ� ���̽�
			if(i < truck_weights.length && curWeight + truck_weights[i] <= weight) {
				trucks.add(truck_weights[i]);
				curWeight += truck_weights[i++];
			}
			
			else {
				trucks.add(0);
			}
			
			answer++;
			if(curWeight == 0) {break;}
		}
				
		return answer;
	}
}