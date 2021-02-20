package algorithms;

public class BinaryTest2 {

	public static void main(String[] args) {
		String input = "00000000";
		
		int db = Integer.parseInt(input, 2);
		System.out.println(db);
		
		String dbToBinary = Integer.toBinaryString(db);
		System.out.println(dbToBinary);
		
//		int category = 8;
//		
//		int categoryToSquareOfTwo = (int) Math.pow(2, 8-category);
//		
//		System.out.println(categoryToSquareOfTwo);
	}

}
