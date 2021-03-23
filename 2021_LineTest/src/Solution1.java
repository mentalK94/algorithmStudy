import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution1 {

	public static void main(String[] args) {
		Solution1 s1 = new Solution1();
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"PYTHON", "C++", "SQL"};
		int[] preference = {7,5,5};
		
		s1.solution(table, languages, preference);
	}
	
	public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> positionList = new ArrayList<>();
        for(int i=0; i<table.length; ++i) {
        	StringTokenizer st = new StringTokenizer(table[i]);
        	
        	String position = st.nextToken();
        	positionList.add(position);
        	for(int j=5; j>0; --j) {
        		String lang = st.nextToken();
        		map.put(position+lang, j);
        	}        	
        }
        
        int totalPoint = 0;
        ArrayList<String> answerList = new ArrayList<String>();
        for(String p : positionList) {
        	int point = 0;
        	for(int i=0; i<languages.length; ++i) {
        		if(map.containsKey(p+languages[i])) {
        			point += (map.get(p+languages[i])*preference[i]);
        		}
        	}
        	
        	if(totalPoint == point) { answerList.add(p); }
        	        	
        	if(totalPoint < point) {
        		answerList.clear();
        		totalPoint = point;
        		answerList.add(p);
        	}
        }
        
        Collections.sort(answerList);
        answer = answerList.get(0);
        System.out.println(answer);
        return answer;
    }
}
