/**
 * programmers - 후보키
 * 후보키.java
 * @date 2021-03-10
 * @author hansolKim
 **/

package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.lang.StringBuilder;

class 후보키 {
    
    static int R, answer;
    static ArrayList<String> keyList;
    static boolean[] checked;
    static String[][] sRelation;
    
    public int solution(String[][] relation) {
        answer = 0;
        
        sRelation = new String[relation.length][relation[0].length];
        for(int i=0; i<relation.length; i++) {
            sRelation[i] = relation[i].clone();
        }
        
        R = relation[0].length;
        checked = new boolean[relation[0].length];
        keyList = new ArrayList<>();
        subset(0);
        
        return answer;
    }
    
    private static void subset(int cnt) {
        if(cnt == R) {

            // 1. 전부 다 false인 경우 제외
            // 2. true로 선택된 컬럼 값이 전부 존재하는 경우 제외            
            ArrayList<Integer> selectList = new ArrayList<>();
            int column = 0;
            for(int i=0; i<checked.length; ++i) {
                if(checked[i] == true) {                    
                    column++;
                    selectList.add(i);
                }
            }
            
            for(String key : keyList) {
                int len = key.length();
                for(int i=0; i<selectList.size(); ++i) {
                    if(key.contains(String.valueOf(selectList.get(i)))) {                        
                        if(--len == 0) { 
                            return;
                        }
                    }
                }
            }
            
            if(column == 0) {             
                return; 
            } // 1 or 2번에 해당되는 경우
                        
            // 3. 키 인덱스에 해당하는 모든 값을 해시에 넣고 개수 확인
            StringBuilder sb = new StringBuilder();
            Set<String> set = new HashSet<>();
            for(int i=0; i<sRelation.length; ++i) {
                for(int j=0; j<selectList.size(); ++j) {
                    // System.out.println(sRelation[i][selectList.get(j)]);
                    sb.append(sRelation[i][selectList.get(j)]);
                }
                set.add(sb.toString());
                sb.replace(0, sb.length(), "");
            }                    
            
            if(set.size() == sRelation.length) {
                for(int j=0; j<selectList.size(); ++j) {
                    sb.append(selectList.get(j));
                }
                keyList.add(sb.toString());
                answer++; 
            }
            return;
        }
        
        checked[cnt] = false;
        subset(cnt+1);
        checked[cnt] = true;
        subset(cnt+1);
    }
}