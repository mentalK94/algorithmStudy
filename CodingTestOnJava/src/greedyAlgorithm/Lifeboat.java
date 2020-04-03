package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Lifeboat {

	public static void main(String[] args) {
		LifeboatSolution lifeboatSolution = new LifeboatSolution();
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println(lifeboatSolution.solution(people, limit));
	}
}

class LifeboatSolution {
	public int solution(int[] people, int limit) {
		int answer = 0;		
		int minValue;
		ArrayList<Integer> peopleWeights = new ArrayList<>();
		
		for(int i=0; i<people.length; i++) {
			
			peopleWeights.add(people[i]);
		}
		
		Collections.sort(peopleWeights);
		
		while(true) {
			
			if(peopleWeights.size() == 0) {break;}
			if(peopleWeights.size() == 1) {answer++; break;}
						 		
			minValue = peopleWeights.get(0);
			int remainSpace = limit-minValue;
			
			if(remainSpace < peopleWeights.get(1)) {
				System.out.println("호출1");
				peopleWeights.remove(0);
				answer++; 
			}
			else {
				while(true) {
					for(int i=peopleWeights.size()-1; i>=0; i--) {
						if(remainSpace>=peopleWeights.get(i)) {
							System.out.println("호출2 : " + peopleWeights.get(i));
							peopleWeights.remove(i);
							break;
						}
					}
					
					if(peopleWeights.size() == 0) {break;}
					
					if(remainSpace < peopleWeights.get(0)) {break;}
					
					for(int i=0; i<peopleWeights.size(); i++) {
						System.out.println("호출3 : " + peopleWeights.get(i));
						if(remainSpace>=peopleWeights.get(i)) {
							peopleWeights.remove(i);
							break;
						}
					}
										
				}
				answer++;
			}
			
		}
		
		
		return answer;
	}

}