package stackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

public class IronBar {

	public static void main(String[] args) {
		
		IronBarSolution ironBarSolution = new IronBarSolution();
		String arrangement = "()(((()())(())()))(())";
		
		System.out.println(ironBarSolution.solution(arrangement));

	}

}

class IronBarSolution {
    public int solution(String arrangement) {
        int answer = 0, raiser = 0, raiserTemp = 0, cnt = 0;
        // ArrayList<Integer> raiserList = new ArrayList<>();
        Stack<Character> arrStack = new Stack<>();
        
        for(int i=0; i<arrangement.length(); i++) {
        	
        	// 1. '(' �� ���� ��� ���ÿ� ����
        	if(arrangement.charAt(i) == '(') {
        		arrStack.add(arrangement.charAt(i));
        		continue;
        	}
        	
        	// 2. ')' �� ���� ���
        	// 2-1. �ٷ� ���� ���ڰ� '('�� ��� -> ������
        	if(arrStack.size() > 0 
        			&& arrangement.charAt(i-1) == '(' 
        			&& arrangement.charAt(i) == ')') {
        		arrStack.pop(); // �� ���� �� ����
        		answer += arrStack.size(); // ���� ���� ��ŭ �߰�
        		continue;
        	} 

        	// 2-2. 2-1�� �����ϰ� ')'�� ���� ��� -> ����
        	if(arrStack.size() > 0 && arrangement.charAt(i) == ')') {
        		arrStack.pop(); // �� ���� �� ����
        		answer += 1;
        	}               
        }
        
        return answer;
    }
}