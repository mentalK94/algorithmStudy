package programmers;

public class 자물쇠와열쇠 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean answer = false;
	int[][] skey, slock;
	
	public boolean solution(int[][] key, int[][] lock) {
        
        int T = 4;
        
        skey = new int[key.length][key[0].length];
        for(int i=0; i<key.length; i++) {
        	skey[i] = key[i].clone();
        }
        
        slock = new int[lock.length][lock[0].length];
        for(int i=0; i<lock.length; i++) {
        	slock[i] = lock[i].clone();
        }
        
        while(T-->0) {
        	
        	// 
        	
        	// key 회전시키기
        }
        
        return answer;
    }

}
