/**
 * Backjoon - 1296. 데이트
 * Date_1296.java
 * @date 2020-10-13
 * @author hansolKim
 **/

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Date_1296 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String minsik = br.readLine();
		int n = Integer.parseInt(br.readLine());
		
		int[] love = new int[4];
		for(int i=0; i<minsik.length(); i++) {
			if(minsik.charAt(i) == 'L') {
				love[0]++;
				continue;
			}
			if(minsik.charAt(i) == 'O') {
				love[1]++;
				continue;
			} 
			if(minsik.charAt(i) == 'V') {
				love[2]++;
				continue;
			} 
			if(minsik.charAt(i) == 'E') {
				love[3]++;
			} 
		}
		
		String answerName = "a";
		int answerValue = 0;
		
		for(int i=0; i<n; i++) {
			
			int[] temp = love.clone();
			String girl = br.readLine();
			for(int j=0; j<girl.length(); j++) {
				if(girl.charAt(j) == 'L') {
					temp[0]++;
					continue;
				}
				if(girl.charAt(j) == 'O') {
					temp[1]++;
					continue;
				} 
				if(girl.charAt(j) == 'V') {
					temp[2]++;
					continue;
				} 
				if(girl.charAt(j) == 'E') {
					temp[3]++;
				} 
			}
			
			int result = calc(temp);
			
			if(answerValue < result) {
				answerValue = result;
				answerName = girl;
			} else if(answerValue == result && girl.compareTo(answerName) < 0) {
				answerName = girl;
			}
		}
		
		System.out.println(answerName);
	}

	private static int calc(int[] love) {
		int L = love[0];
		int O = love[1];
		int V = love[2];
		int E = love[3];
		return ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E))%100;
	}
}
