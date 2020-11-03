/**
 * Backjoon - 1308. D-Day
 * DDay_1308.java
 * @date 2020-10-29
 * @author hansolKim
 **/

package p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DDay_1308 {
	
	static int[] d = {0, 31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sYear = Integer.parseInt(st.nextToken());
		int sMonth = Integer.parseInt(st.nextToken());
		int sDay = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int dYear = Integer.parseInt(st.nextToken());
		int dMonth = Integer.parseInt(st.nextToken());
		int dDay = Integer.parseInt(st.nextToken());
		
		int r1 = days(sYear, sMonth, sDay);
		int r2 = days(dYear, dMonth, dDay);
		
		boolean isThousand = false;
		if(dYear-sYear>1000) {
			isThousand = true;
		} else if(dYear-sYear == 1000) {
			if(days(0, sMonth, sDay)<=days(0, dMonth, dDay)) {
				isThousand = true;	
			}
		}
		
		if(isThousand) {
			System.out.println("gg");	
		} else {
			System.out.println("D-"+(r2-r1));	
		}
	}

	private static boolean isLeapYear(int year) {
		if(year%4 != 0) return false;
		if(year%100 != 0) return true;
		if(year%400 == 0) return true;
		return false;
	}
	
	private static int days(int y, int m, int dd) {
		int day = 0;
		for(int i=0; i<y; i++) {
			if(isLeapYear(i)) { day += 366;}
			else {day += 365;}	
		}
		for(int i=1; i<m; i++) {
			if(i==2 && isLeapYear(y)) {day+=29; continue;}
			day += d[i];
		}
		return day+dd;
	}

}
