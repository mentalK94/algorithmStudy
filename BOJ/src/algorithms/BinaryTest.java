package algorithms;

public class BinaryTest {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<Math.pow(2, 13); i++) {
			String state = Integer.toBinaryString(i);
			int dist = 3 - state.length();
			for(int j=0; j<dist; j++) {
				sb.append("0");
			}
			sb.append(state);
			System.out.println(sb);
			sb.replace(0, sb.length(), "");
		}
		
		
	}

}
