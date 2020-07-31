package ssafy;

public class DebugTest {

	public static void main(String[] args) {	
		int total = 0;
		
		for(int i=0; i<=100; i++) {
			total += i;
			
			int re = go(i);
			System.out.println(re);
		}
		
		System.out.println(total);
		
	}

	private static int go(int i) {
		i++;
		return i;
	}
}
