package bingo;

import java.util.ArrayList;
import java.util.Random;

public class BingGame {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		ArrayList<String> list3 = new ArrayList<>();
		ArrayList<String> list4 = new ArrayList<>();
		ArrayList<String> list5 = new ArrayList<>();
		
		list1.add("�״索�ۿ�");
		list1.add("�� ��ȭ�ۿ�");
		list1.add("��������");
		list1.add("��������̵�");
		list1.add("���а�ȭ");
		list1.add("������");
		list1.add("�������ľ���");
		list1.add("��ȿ");
		list1.add("���ѻ����");
		list1.add("�峻�̻���");
		list1.add("��ȿ���бش�ȭ");
		list1.add("6���");
		list1.add("�γ�Ȱ������");
		list1.add("��ȭ����");
		list1.add("���");
		
		list2.add("��������");
		list2.add("����Ȯ��");
		list2.add("����ɺ�ȣ");
		list2.add("�Ű����");
		list2.add("�ϼ������ľ���");
		list2.add("���ص��ۿ�");
		list2.add("12.5mg");
		list2.add("����");
		list2.add("37.5%");
		list2.add("ȯ��ȣ������ġ");
		list2.add("ȿ����ǥ��ȭ");
		list2.add("����");
		list2.add("��缱����ۿ�");
		list2.add("���尭ȭ");
		list2.add("���������");
		
		list3.add("�Ƿ�ȸ��");
		list3.add("���˾�ȿ��");
		list3.add("����ȸ��");
		list3.add("�Ŀ�����");
		list3.add("������ȭ����");
		list3.add("���Ŀ��K");
		list3.add("�����Ѵ��깰");
		list3.add("�����ۿ�");
		list3.add("����Ÿ��");
		list3.add("Ư�̻�����");
		list3.add("160%����");
		list3.add("���");
		list3.add("õ��");
		list3.add("��ȭ��������");
		list3.add("����ɰ�ȭ");
		
		list4.add("�鿪������");
		list4.add("�׾�ȿ��");
		list4.add("�׿���");
		list4.add("�˺�1");
		list4.add("����3");
		list4.add("�ϼ������̾���");
		list4.add("21��");
		list4.add("�ҿ��ۿ�");
		list4.add("��ġ��");
		list4.add("ü�������90%");
		list4.add("��������");
		list4.add("�����ȸ��");
		list4.add("�鿪�ٴ�ü");
		list4.add("�������");
		list4.add("��ļ���Ȱ��ȭ");
		
		list5.add("���׼�ȯ����");
		list5.add("����ȸ��");
		list5.add("�������");
		list5.add("�װ���");
		list5.add("ġ�ſ���");
		list5.add("��ȿȫ��");
		list5.add("���������");
		list5.add("100��");
		list5.add("������");
		list5.add("����1");
		list5.add("�ɽ��ۿ�");
		list5.add("��Ȳ");
		list5.add("�ݷ����׷Ѱ���");
		list5.add("�鿪����Ȱ��ȭ");
		list5.add("�׽�Ʈ�����ۿ�");
		
		
		
		getBingo(list1);
		getBingo(list2);
		getBingo(list3);
		getBingo(list4);
		getBingo(list5);
	}
	
	public static void getBingo(ArrayList<String> list) {
		int pick[] = new int[5];
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		
		for(int i=0; i<5; i++) {
			pick[i] = rand.nextInt(list.size());
			for(int j=0; j<i; j++) {
				if(pick[i] == pick[j]) {i--;}
			}
		}
		
		for(int i=0; i<5; i++) {			
			System.out.print(list.get(pick[i]) + "\t");
		}
		System.out.println();
		System.out.println();
	}

}