package bruteforce;

public class Carpet {

	public static void main(String[] args) {
		
		int brown = 24;
		int red = 24;
		
		CarpetSolution carpetSolution = new CarpetSolution();
		carpetSolution.solution(brown, red);

	}

}

class CarpetSolution {
    public int[] solution(int brown, int red) {
        int[] answer = {};
        int x, y;
        
        // 1. red�� ������ ã�ƶ� -> red������ (x, y)�� ��� ī�� ũ��� (x+2, y+2)�� �ȴ�
        // 2. �־��� brown������ ���� red������ ã�ƶ� -> red������ (x, y)�� ��� brown ������ 2x+2y+4�� �ȴ�
        // ����) 1 < x*y < 2,000,000
        // 3. red������ �簢���̹Ƿ� x*y������ �� ����������.
        
        for(int i=red; i>=(red/i); i--) {
        	if(red%i!=0) // �� �������� �ʴ� ���
        		continue;
        	
        	x = i;
        	y = red/x;
        	if(2*x+2*y+4 == brown) {
        		answer = new int[2];
        		answer[0] = x+2;
        		answer[1] = y+2;
        		break;
        	}
        		
        }
        
        System.out.println(answer[0] + ", " + answer[1]);
        return answer;
    }
}