package boostcamp;

import java.util.ArrayList;
import java.util.Collections;

public class Ex2 {
	public static void main(String[] args) {
		int[] arrayA = {2,3,4,3,5};
		int[] arrayB = {1,6,7};
		solution(arrayA, arrayB);
	}
	
	public static int[] solution(int[] arrayA, int[] arrayB) {
		int[] answer = new int[5];
		
		ArrayList<Integer> listA = new ArrayList<>();
		ArrayList<Integer> listB = new ArrayList<>();
		ArrayList<Integer> listSum = new ArrayList<>();
		ArrayList<Integer> listComplement = new ArrayList<>();
		ArrayList<Integer> listIntersect = new ArrayList<>();
		boolean isEqual = false;
		
		// array to arraylist
		for(int i=0; i<arrayA.length; i++) {listA.add(arrayA[i]);}		
		for(int i=0; i<arrayB.length; i++) {listB.add(arrayB[i]);}
				
		// ����
		Collections.sort(listA);
		Collections.sort(listB);
		
		// �ߺ����� �۾�
		for(int i=0; i<listA.size()-1; i++) {
			if(listA.get(i) == listA.get(i+1)) {
				listA.remove(i+1);
				i--;
			}
		}
		
		for(int i=0; i<listB.size()-1; i++) {
			if(listB.get(i) == listB.get(i+1)) {
				listB.remove(i+1);
				i--;
			}
		}
		
		// A���� -> ���������� ���� ���� 
		for(int i=0; i<listA.size(); i++) {
			listSum.add(listA.get(i));
		}
		
		// B���հ� ���Ͽ� ���� ���� ����
		for(int i=0; i<listB.size(); i++) {
			
			int num = listB.get(i);
			
			for(int j=0; j<listSum.size(); j++) {
				if(listSum.get(j) == num) { // ���� ���Ұ� A���տ� �ִ� ���
					isEqual = true;
					break;
				}
			}
			
			if(!isEqual) {
				listSum.add(num);
			}
			
			isEqual = false;
		}
		
		// ������ ���� : ������ - B
		for(int i=0; i<listSum.size(); i++) {
			listComplement.add(listSum.get(i));
		}
		
		for(int i=0; i<listB.size(); i++) {
			listComplement.remove(listB.get(i));
		}
		
		
		// ������ ���� : A - ������
		for(int i=0; i<listA.size(); i++) {
			listIntersect.add(listA.get(i));
		}
		
		for(int i=0; i<listComplement.size(); i++) {
			listIntersect.remove(listComplement.get(i));
		}
		
		answer[0] = listA.size();
		answer[1] = listB.size();
		answer[2] = listSum.size();
		answer[3] = listComplement.size();
		answer[4] = listIntersect.size();
		
		return answer;
	}
}
