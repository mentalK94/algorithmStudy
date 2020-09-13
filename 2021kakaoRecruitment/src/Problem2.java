import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Problem2 {

	public static void main(String[] args) {
		Problem2 p2 = new Problem2();
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		String[] orders3 = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		p2.solution(orders3, course);
	}
	
	private static int N, R;
	private static char[] input, selected;
	private static HashMap<String, Integer> map;
	
	public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        map = new HashMap<>();
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<course.length; i++) {
        	R = course[i];
        	
        	for(int j=0; j<orders.length; j++) {
        		String tempOrder = orders[j];
        		String[] arr = tempOrder.split("");
        		Arrays.sort(arr);
        		String order = String.join("", arr);        		
        		
        		N =  order.length();
        		input = order.toCharArray();
        		selected = new char[R];
        		combination(0, 0);
        	}
        	
        	ArrayList<String> temp = new ArrayList<>();
        	
        	int max = 2;
        	
        	for(String key: map.keySet()) {
        		
        		if(map.get(key) < max) continue;
        		if(map.get(key) > max) {
        			max = map.get(key);
        			temp.clear();
        			temp.add(key);
        			continue;
        		}
        		
        		temp.add(key);
        	}
        	
        	for(int j=0; j<temp.size(); j++) {
        		list.add(temp.get(j));
        	}
        	
        	map.clear();
        }
        
        Collections.sort(list);
        answer = new String[list.size()];
        
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        	System.out.println(answer[i]);
        }
        
        return answer;
    }

	private void combination(int cnt, int start) {
		if(cnt == R) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<selected.length; i++) {
				sb.append(selected[i]);
			}
			
			if(map.containsKey(sb.toString())) {
				int count = map.get(sb.toString());
				map.put(sb.toString(), count+1);
			} else {
				map.put(sb.toString(), 1);
			}	
			return;
		}
		
		for(int i=start; i<N; i++) {
			selected[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}

}
