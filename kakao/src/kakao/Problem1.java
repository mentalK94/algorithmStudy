package kakao;

/*
 * 
 * ���� ����
����Ʈ�� ��ȭ Ű�е��� �� ĭ�� ������ ���� ���ڵ��� ���� �ֽ��ϴ�.

kakao_phone1.png

�� ��ȭ Ű�е忡�� �޼հ� �������� �����հ������� �̿��ؼ� ���ڸ��� �Է��Ϸ��� �մϴ�.
�� ó�� �޼� �����հ����� * Ű�е忡 ������ �����հ����� # Ű�е� ��ġ���� �����ϸ�, �����հ����� ����ϴ� ��Ģ�� ������ �����ϴ�.

�����հ����� �����¿� 4���� �������θ� �̵��� �� ������ Ű�е� �̵� �� ĭ�� �Ÿ��� 1�� �ش��մϴ�.
���� ���� 3���� ���� 1, 4, 7�� �Է��� ���� �޼� �����հ����� ����մϴ�.
������ ���� 3���� ���� 3, 6, 9�� �Է��� ���� ������ �����հ����� ����մϴ�.
��� ���� 4���� ���� 2, 5, 8, 0�� �Է��� ���� �� �����հ����� ���� Ű�е��� ��ġ���� �� ����� �����հ����� ����մϴ�.
4-1. ���� �� �����հ����� �Ÿ��� ���ٸ�, ���������̴� ������ �����հ���, �޼����̴� �޼� �����հ����� ����մϴ�.
������� ���� ��ȣ�� ��� �迭 numbers, �޼��������� ������������ ���� ��Ÿ���� ���ڿ� hand�� �Ű������� �־��� ��, �� ��ȣ�� ���� �����հ����� �޼��� �� �������� ���� ��Ÿ���� ���ӵ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ����ּ���.

[���ѻ���]
numbers �迭�� ũ��� 1 �̻� 1,000 �����Դϴ�.
numbers �迭 ������ ���� 0 �̻� 9 ������ �����Դϴ�.
hand�� "left" �Ǵ� "right" �Դϴ�.
"left"�� �޼�����, "right"�� ���������̸� �ǹ��մϴ�.
�޼� �����հ����� ����� ���� L, ������ �����հ����� ����� ���� R�� ������� �̾�ٿ� ���ڿ� ���·� return ���ּ���.
 * 
 * 
 * 
 * 
 * 
 * */


public class Problem1 {

	public static void main(String[] args) {
		
		Problem1Solution problem1Solution = new Problem1Solution();
		int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
		String hand = "right";
		problem1Solution.solution(numbers, hand);
	}

}

class Problem1Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder builder = new StringBuilder();
        int lHand = 10;
        int rHand = 11;
        
        int dist[][] = {
        		{0, 4, 3, 4, 3, 2, 3, 2, 1, 2},
        		{4, 0, 1, 2, 1, 2, 4, 2, 3, 4},
        		{3, 1, 0, 1, 2, 1, 2, 3, 2, 3},
        		{4, 2, 1, 0, 3, 2, 1, 4, 3, 2},
        		{3, 1, 2, 3, 0, 1, 2, 1, 2, 3},
        		{2, 2, 1, 2, 1, 0, 1, 2, 1, 2},
        		{3, 3, 2, 1, 2, 1, 0, 3, 2, 1},
        		{2, 2, 3, 4, 1, 2, 3, 0, 1, 2},
        		{1, 3, 2, 3, 2, 1, 2, 1, 0, 1},
        		{2, 4, 3, 2, 3, 2, 1, 2, 1, 0},
        		{1, 3, 4, 5, 2, 3, 4, 1, 2, 3},
        		{1, 5, 4, 3, 4, 3, 2, 3, 2, 1}
        };
        
        for(int i=0; i<numbers.length; i++) {
        	
        	// 1. 1, 4, 7�� ��� -> �޼�
        	if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
        		lHand = numbers[i];
        		builder.append("L");
        		continue;
        	}
        	
        	// 2. 3, 6, 9�� ��� -> ������
        	if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
        		rHand = numbers[i];
        		builder.append("R");
        		continue;
        	}
        	// 3. �Ÿ��� ���� ��� -> �����̿� ������.
        	if(dist[lHand][numbers[i]] < dist[rHand][numbers[i]]) { // �޼��� ����� ���
        		lHand = numbers[i];
        		builder.append("L");        		
        		continue;
        	} else if(dist[lHand][numbers[i]] > dist[rHand][numbers[i]]){ // �������� ����� ���
        		rHand = numbers[i];
        		builder.append("R");        		
        		continue;
        	} else {
        		if(hand.equals("left")) { // �޼�����
        			lHand = numbers[i];
        			builder.append("L");             		
            		continue;
        		} else { // ����������
            		rHand = numbers[i];
            		builder.append("R"); 
            		continue;
        		}
        	}
        	
        }
        
        answer = builder.toString();
        return answer;
    }
}
