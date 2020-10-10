import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Car implements Comparable<Car>{
	String name;
	int vote;
	
	public Car() {}
	
	public Car(String name, int vote) {
		this.name = name;
		this.vote = vote;
	}

	@Override
	public int compareTo(Car c) {
		// 1. 득표가 낮은 순(오름차순)
		if(this.vote == c.vote) {
			return c.name.compareTo(this.name);
		} else {
			return Integer.compare(this.vote, c.vote);
		}
	}

}

public class Solution4 {
	public static void main(String[] args) {
		
		Solution4 s4 = new Solution4();
		String[] votes = {"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"};
		String[] votes2 = {"AAD", "AAA", "AAC", "AAB"};
		int k = 4;
		s4.solution(votes2, k);
	}

	public String solution(String[] votes, int k) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        // 1. 
        for(int i=0; i<votes.length; i++) {
        	if(map.containsKey(votes[i])) {
        		map.put(votes[i], map.get(votes[i])+1);
        	} else {
        		map.put(votes[i], 1);
        	}
        }
        
        PriorityQueue<Car> pq = new PriorityQueue<>();
        ArrayList<Car> cars = new ArrayList<>();
        for(String key : map.keySet()) {
        	cars.add(new Car(key, map.get(key)));
        	pq.add(new Car(key, map.get(key)));
        }
        
        // k개만큼의 상위 득표 수 구하기
        int voteCnt = 0;
        Collections.sort(cars, new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {
				return Integer.compare(o2.vote, o1.vote);
			}
		});
        
        for(int i=0; i<k; i++) {
        	voteCnt += cars.get(i).vote;
        }                
        
        // voteCnt보다 적은 표수만큼 탈락시키기
        int dropVote = 0;
        Car c = new Car();
        while(true) {
        	c = pq.poll();;
        	dropVote += c.vote;
        	if(dropVote < voteCnt) { // 가능한 경우
        		answer = c.name;
        	} else { // 가능하지 않은 경우
        		break;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
}