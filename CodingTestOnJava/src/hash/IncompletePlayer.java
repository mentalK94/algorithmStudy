package hash;

import java.util.Arrays;

public class IncompletePlayer {

	public static void main(String[] args) {
		IncompletePlayerSolution incompletePlayerSolution = new IncompletePlayerSolution();
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};		
		
		System.out.println(incompletePlayerSolution.solution(participant, completion));
	}
}

class IncompletePlayerSolution {
    public String solution(String[] participant, String[] completion) {
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<completion.length; i++) {
        	if(!participant[i].equals(completion[i]))
        		return participant[i];
        }
        
        return participant[participant.length-1];
    }
}