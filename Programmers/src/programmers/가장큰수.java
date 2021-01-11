package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 가장큰수 {

	public static void main(String[] args) {
		가장큰수 가장큰수 = new 가장큰수();
		int[] numbers = {0,0,0,0};
		System.out.println(가장큰수.solution(numbers));
	}
	
	public String solution(int[] numbers) {
        int maxLen = 0;
        for(int i=0; i<numbers.length; i++) {
        	int num = numbers[i];
        	int len = 0;
        	while(num>0) {
        		len++;
        		num/=10;
        	}
        	
        	maxLen = len < maxLen ? maxLen : len;
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++) {
        	String num = String.valueOf(numbers[i]);
        	
        	// 해당 num maxLen길이만큼 만들기
        	int len = 0;
        	int idx = 0;
        	while(len < maxLen) {
        		sb.append(num.charAt(idx));
        		len++;
        		idx++;
        		if(idx == num.length()) { idx = 0; }
        	}
        	
        	if(sb.length() == 0) { sb.append(0); }
        	
        	list.add(new int[] {numbers[i], Integer.parseInt(sb.toString())});
        	sb.replace(0, sb.length(), "");
        }
        
        Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[1], o1[1]);
			}
		});
        
        
        for(int i=0; i<list.size(); i++) {
        	sb.append(list.get(i)[0]);
        }
        
        if(sb.toString().charAt(0) == '0') { return "0"; }
        return sb.toString();
    }

}
