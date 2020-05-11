package kakao;

/**
 * ���� ����
[�� ������ ��Ȯ���� ȿ���� �׽�Ʈ ���� ������ �ִ� �����Դϴ�.]

������ ������� ���� �ְ��� ���ΰ� �� ����ġ�� ��Ʈ������ ���� ���� �̸� Ǯ�� ���� �������� ���忡 ������ �Ϸ� ���� �մϴ�.
����ġ�� ������ �� ���� ���� �������� Ư�� ������ ���ǵ��� ��� �Ͼ��� �����ϴ� ������ �ֽ��ϴ�.
��� �� ��Ʈ������ Ǯ�� ���� ���� ���忡 ������ �Ϸ� �� ����ġ�� ����ó�� �������� Ư�� ������ ������ ��� �����ϵ� Ư���� �Ʒ� ������ �޼��ϰ� �;����ϴ�.
������ ��� ������ ������ ��� 1�� �̻� �����ϴ� ���� ª�� ������ ã�Ƽ� ����

���� ��� �Ʒ� ������� 4������ ����(RUBY, DIA, EMERALD, SAPPHIRE) 8���� ������ �����Դϴ�.

������ ��ȣ	1	2	3	4	5	6	7	8
���� �̸�	DIA	RUBY	RUBY	DIA	DIA	EMERALD	SAPPHIRE	DIA
�������� 3������ 7������ 5���� ������ �����ϸ� ��� ������ ������ ��� �ϳ� �̻� �����ϰ� �˴ϴ�.

�������� 3, 4, 6, 7���� ������ �����ϴ� ���� �߰��� Ư�� ����(5��)�� ������ �ǹǷ� ����ġ�� ���� ������ ���� �ʽ��ϴ�.

������ ��ȣ ������� �������� �̸��� ����� �迭 gems�� �Ű������� �־����ϴ�. �̶� ��� ������ �ϳ� �̻� �����ϴ� ���� ª�� ������ ã�Ƽ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
���� ª�� ������ ���� ������ ��ȣ�� �� ������ ��ȣ�� ���ʴ�� �迭�� ��Ƽ� return �ϵ��� �ϸ�, ���� ���� ª�� ������ ���� ����� ���� ������ ��ȣ�� ���� ���� ������ return �մϴ�.

[���ѻ���]
gems �迭�� ũ��� 1 �̻� 100,000 �����Դϴ�.
gems �迭�� �� ���Ҵ� �����뿡 ������ ������ ��Ÿ���ϴ�.
gems �迭���� 1�� ��������� ������ ��ȣ ������� �����̸��� ���ʴ�� ����Ǿ� �ֽ��ϴ�.
gems �迭�� �� ���Ҵ� ���̰� 1 �̻� 10 ������ ���ĺ� �빮�ڷθ� ������ ���ڿ��Դϴ�.

����� ��
gems	result
["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]	[3, 7]
["AA", "AB", "AC", "AA", "AC"]	[1, 3]
["XYZ", "XYZ", "XYZ"]	[1, 1]
["ZZZ", "YYY", "NNNN", "YYY", "BBB"]	[1, 5]
����� ���� ���� ����
����� �� #1
���� ���ÿ� �����ϴ�.

����� �� #2
3������ ����(AA, AB, AC)�� ��� �����ϴ� ���� ª�� ������ [1, 3], [2, 4]�� �ֽ��ϴ�.
���� ������ ��ȣ�� �� ���� [1, 3]�� return ���־�� �մϴ�.

����� �� #3
1������ ����(XYZ)�� �����ϴ� ���� ª�� ������ [1, 1], [2, 2], [3, 3]�� �ֽ��ϴ�.
���� ������ ��ȣ�� ���� ���� [1, 1]�� return ���־�� �մϴ�.

����� �� #4
4������ ����(ZZZ, YYY, NNNN, BBB)�� ��� �����ϴ� ������ [1, 5]�� �����մϴ�.
�׷��Ƿ� [1, 5]�� return ���־�� �մϴ�.
 * */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Problem3 {

	public static void main(String[] args) {
		Problem3Solution problem3Solution = new Problem3Solution();
		String[] gems = {"zzz", "yyy", "nnnn", "yyy", "bbb"};		
		problem3Solution.solution(gems);

	}

}

class Problem3Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        int answerCnt = 0; // ���� �ߺ����� �����ؾ��ϴ� ����
        int cnt = 0;
        int minCnt = 100000;
        int startIdx = 0;
        int endIdx = 0;
        boolean flag = false;
        
        Map<String, Integer> buyMap = new HashMap<>();
        ArrayList<String> gemList = new ArrayList<>(); 
        answer = new int[2];
        
        for(int i=0; i<gems.length; i++) {
        	gemList.add(gems[i]);
        }
        
        TreeSet<String> gemList2 = new TreeSet<String>(gemList);
        
        answerCnt = gemList2.size();

        for(int i=0; i<gems.length; i++) {
        	cnt = 0;      	
        	
        	if(buyMap.containsKey(gems[i])) {
        		if(buyMap.get(gems[i]) >= 2) {
        			buyMap.put(gems[i], buyMap.get(gems[i])-1);
        			continue;
        		}
        	}
        	
        	if(gems.length-i >= answerCnt) {
        		buyMap.clear();
	        	for(int j=i; j<gems.length; j++) {
	        		System.out.println(j);
	        		
	        		if(cnt >= minCnt) {
	        			flag = false;
	        			break;
	        		}
	        		
	        		if(!buyMap.containsKey(gems[j])) { // ó�� ����
	        			buyMap.put(gems[j], 1);
	        		} else { 
	        			int v = buyMap.get(gems[j]);
	        			buyMap.put(gems[j], v+1);
	        		}
	            	cnt++; 	            	
	            	if(buyMap.size() == answerCnt) {
	            		startIdx = i;
	            		endIdx = j;
	            		flag = true;
	            		break;
	            	}        		
	            }
        	}
        	if(!flag) {
        		continue;
        	}
        	
        	if(cnt != 0 && minCnt > cnt && flag) {
        		minCnt = cnt;
        		answer[0] = startIdx+1;
        		answer[1] = endIdx+1;
        	}
        }
        
        // System.out.println(answer[0] + " " + answer[1]);

        return answer;
    }
}