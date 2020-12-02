/**
 * Backjoon - 11656. 접미사 배열
 * SuffixArray_11656.java
 * @date 2020-12-02
 * @author hansolKim
 * */

package p11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SuffixArray_11656 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<str.length(); i++) {
			list.add(str.substring(i, str.length()));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
