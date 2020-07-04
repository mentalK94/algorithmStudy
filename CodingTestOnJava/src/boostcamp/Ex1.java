package boostcamp;

import java.util.*;

public class Ex1 {
	
	public static void main(String[] args) {
		String[] name_list1 = {"����", "����", "�ʱ�"};
		String[] name_list2 = {"��","����","����"};
		String[] name_list3 = {"�ʱ�", "�ʿ�", "����", "����"};
		System.out.println(solution(name_list3));
	}
	
	public static boolean solution(String[] name_list) {
		boolean answer = true;
		
		ArrayList<String> nameList = new ArrayList<>();
		
		for(int i=0; i<name_list.length; i++) {
			nameList.add(name_list[i]);
		}
		
		for(int i=0; i<nameList.size(); i++) {
			String str = nameList.get(i); 
			
			for(int j=0; j<name_list.length; j++) {
				if(name_list[j].contains(str) && i!=j) {
					return false;
				}
			}
		}

		return answer;		
	}
}
