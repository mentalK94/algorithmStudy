package greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class GymSuit {

	public static void main(String[] args) {
		GymSuitSolution gymSuitSolution = new GymSuitSolution();
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 1, 3, 5 };
		System.out.println(gymSuitSolution.solution(n, lost, reserve));

	}
}

class GymSuitSolution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;		
		List<Integer> lostList = new ArrayList<>();  // �Ҿ���� �л� ���
		List<Integer> reserveList = new ArrayList<>();  // ���� ü������ �ִ� �л� ���

		for (int i = 0; i < lost.length; i++) {
			lostList.add(lost[i]);
		}

		for (int i = 0; i < reserve.length; i++) {
			reserveList.add(reserve[i]);
		}
				
		for (int i = 0; i < lostList.size(); i++) {
			for (int j = 0; j < reserveList.size(); j++) {
				if(isMine(lostList.get(i), reserveList.get(j))) { // ü������ ������ �л��� �Ҿ���� ���					
					lostList.remove(i);
					reserveList.remove(j);
					i--;
					break;
				}
			}
		}
	
		for (int i = 0; i < lostList.size(); i++) {
			for (int j = 0; j < reserveList.size(); j++) {
				if(isBorrow(lostList.get(i), reserveList.get(j))) { // ü������ ���� �� �ִ� �� Ȯ��					
					lostList.remove(i);
					reserveList.remove(j);
					i--;
					break;
				}
			}
		}

		answer = n-lostList.size();
		return answer;
	}

	public boolean isBorrow(int a, int b) { // ���� �� �ִ��� ���� �Ǵ��ϴ� �޼ҵ�
		if(a==b-1 || a==b+1) return true;		
		return false;
	}
	
	public boolean isMine(int a, int b) { // �Ҿ���� �л� �� ������ ���� �ִ� �� Ȯ���ϴ� �޼ҵ�
		if(a==b) return true;		
		return false;
	}
}
