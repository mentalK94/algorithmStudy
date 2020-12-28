/**
 * Backjoon - 4358. 생태학
 * 생태학_4358.java
 * @date 2020-12-28
 * @author hansolKim
 **/

package p4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 생태학_4358 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String wood = "";
		HashMap<String, Integer> map = new HashMap<>();
		
		int allCnt = 0;
		
		while((wood=br.readLine()) != null) {
			int cnt = 1;
			if(map.containsKey(wood)) {
				cnt = map.get(wood)+1;
			}
			
			map.put(wood, cnt);
			allCnt++;
		}
		
		ArrayList<Wood> woodList = new ArrayList<>();
		for(String key : map.keySet()) {
			woodList.add(new Wood(key, map.get(key)));
		}
		
		Collections.sort(woodList);
		
		StringBuilder sb = new StringBuilder();
		for(Wood w : woodList) {
			sb.append(w.name).append(" ").append(String.format("%.4f", (double)w.cnt*100/allCnt)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
}

class Wood implements Comparable<Wood>{
	String name;
	int cnt;
	
	public Wood(String name, int cnt) {
		this.name = name;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Wood o) {
		return this.name.compareTo(o.name);
	}
}