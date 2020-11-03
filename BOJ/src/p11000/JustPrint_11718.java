package p11000;

import java.io.IOException;
import java.util.Scanner;

public class JustPrint_11718 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			String a = sc.nextLine();
			System.out.println(a);
		}
		sc.close();

	}

}
