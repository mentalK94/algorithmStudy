package greedyAlgorithm;

import java.util.ArrayList;

public class Joystick {

	public static void main(String[] args) {
		JoystickSolution joystickSolution = new JoystickSolution();
		String name = "JEROEN";
		System.out.println(joystickSolution.solution(name));

	}

}


class JoystickSolution {
    public int solution(String name) {
        int answer = 0;
        int nameSize = name.length();
        int pointer = 0; // ������ġ
        int remainNumber = nameSize; // �ٲ�ߵǴ� ������ ����
        final int ALPHABET_SIZE = 26;
        ArrayList<Character> nameList = new ArrayList<>();
        boolean[] block = new boolean[nameSize]; // false�̸� ���� �ʾƵ� �Ǵ� ��, true���� �ϴ� ��
        
        for(int i=0; i<nameSize; i++) {
        	nameList.add('A');
        	if(name.charAt(i) == 'A') {
        		block[i] = false; // 'A'�̸� ���� �ʾƵ� �ǹǷ� falseó��
        		remainNumber--; // 'A'�̸� �ٲ��ʿ䰡 �����Ƿ� [�ٲ�ߵǴ� ������ ����] ����
        	}
        	else block[i] = true;
        }
        
        while(true) {
        	
        	// 1. ���� pointer��ġ���� ��ȭ�� �ʿ����� �ƴ��� �Ǵ�
        	if(block[pointer]) { // ���� ��ȭ�� �ʿ��� ���
        		answer+=upOrDown(nameList.get(pointer), name.charAt(pointer), answer, ALPHABET_SIZE);
            	block[pointer] = false; // ��ȭ�� �������� false
            	remainNumber--;
        	}
        	
        	// 2. �ٲ���ϴ� ������ ���� Ȯ��
        	if(remainNumber == 0) // �ٲܰ� ���� ��� while�� Ż��
        		break;
        	
        	// 3. �¿� �Ǵ�
        	if(leftOrRight(pointer, block, nameSize)) {pointer++;}
        	else {pointer--;}
        	
        	// 3. pointer ��ȿ�� ���� Ȯ��
        	if(pointer<0)
        		pointer=nameSize-1;
        	
        	if(pointer==nameSize)
        		pointer=0;        	        	        	
        	
        	answer++;        		        	
        }
        
        return answer;
    }
    
    public int upOrDown(char start, char destination, int answer, int alphabetSize) {  	
    	return destination-start<=13 ? destination-start : alphabetSize-(destination-start);   	
    }
    
    public boolean leftOrRight(int pointer, boolean[] block, int nameSize) { // �¿� ��� ���� Ȯ�� �� �� ���� ������ �����̵�
    	int left=0, right=0;
    	int leftRemain=0, rightRemain=0;
    	
    	// ���� Ȯ��
    	for(int i=pointer; ; i++) {
    		if(block[i]) // true�� ���� ������ break;
    			break;
    		right++;    		
    			
    		if(i==nameSize-1)
    			i=-1;
    	}
    	
    	// ���� Ȯ��
    	for(int j=pointer; ; j--) {
    		if(block[j]) // true�� ���� ������ break;
    			break;
    		left++;
    		if(j==0)
    			j=nameSize;
    	}
    	if(left != right)
    		return right<left ? true : false;
    	
    	// �������� �ٲ���� ���� ���� Ȯ��
    	for(int i=pointer+1; ; i++) {    		
    		if(i==nameSize)
    			i=0;
    		rightRemain++;    		
    			    		
    		if(!block[i]) 
    			break;
    	}
    	
    	// ���� Ȯ��
    	for(int j=pointer-1; ; j--) {    		
    		if(j==-1)
    			j=nameSize-1;
    		
    		leftRemain++;
    		if(!block[j]) 
    			break;    	
    	}
    	
    	return rightRemain<leftRemain ? true : false;
    }       
}