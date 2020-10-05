package bingo;

public class BingGame {

	public static void main(String[] args) {
		subset(4);
	}
	
	public static void subset(int n) {
		for (int i = 0; i < (1<<n); i++) {
			for(int j=0; j<n; j++) {
				if((i & (1<<j)) != 0) {
					 System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}
}