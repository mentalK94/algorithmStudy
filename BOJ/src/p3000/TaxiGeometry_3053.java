/**
 * Backjoon - 3053. 택시 기하학
 * TaxiGeometry_3053.java
 * @date 2020-08-23
 * @author hansolKim
 **/

package p3000;

import java.util.Scanner;

public class TaxiGeometry_3053 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();

		System.out.println(String.format("%.6f", (double)r*r*Math.PI));
		System.out.println(String.format("%.6f", (double)((r*2)*(r*2))/2));
	}

}
