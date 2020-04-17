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
		
		list1.add("항당뇨작용");
		list1.add("항 산화작용");
		list1.add("염증억제");
		list1.add("진세노사이드");
		list1.add("혈압강화");
		list1.add("사포닌");
		list1.add("종양증식억제");
		list1.add("발효");
		list1.add("강한생명력");
		list1.add("장내미생물");
		list1.add("유효성분극대화");
		list1.add("6년근");
		list1.add("두뇌활동촉진");
		list1.add("노화억제");
		list1.add("살균");
		
		list2.add("기억력증진");
		list2.add("혈관확장");
		list2.add("간기능보호");
		list2.add("신경안정");
		list2.add("암세포증식억제");
		list2.add("간해독작용");
		list2.add("12.5mg");
		list2.add("부패");
		list2.add("37.5%");
		list2.add("환경호르몬퇴치");
		list2.add("효능의표준화");
		list2.add("감초");
		list2.add("방사선방어작용");
		list2.add("심장강화");
		list2.add("과혈당억제");
		
		list3.add("피로회복");
		list3.add("위궤양효과");
		list3.add("원기회복");
		list3.add("식욕증진");
		list3.add("세포노화억제");
		list3.add("컴파운드K");
		list3.add("사포닌대사산물");
		list3.add("진통작용");
		list3.add("혈관타고");
		list3.add("특이사포닌");
		list3.add("160%증가");
		list3.add("당귀");
		list3.add("천궁");
		list3.add("노화방지성분");
		list3.add("뇌기능강화");
		
		list4.add("면역력증진");
		list4.add("항암효과");
		list4.add("항염증");
		list4.add("알비1");
		list4.add("알지3");
		list4.add("암세포전이억제");
		list4.add("21배");
		list4.add("소염작용");
		list4.add("항치매");
		list4.add("체내흡수율90%");
		list4.add("영지버섯");
		list4.add("무기력회복");
		list4.add("면역다당체");
		list4.add("조혈기능");
		list4.add("대식세포활성화");
		
		list5.add("혈액순환개선");
		list5.add("빈혈회복");
		list5.add("조혈기능");
		list5.add("항간염");
		list5.add("치매예방");
		list5.add("발효홍삼");
		list5.add("흡수율증가");
		list5.add("100배");
		list5.add("항종양");
		list5.add("알지1");
		list5.add("심신작용");
		list5.add("지황");
		list5.add("콜레스테롤감소");
		list5.add("면역세포활성화");
		list5.add("항스트레스작용");
		
		
		
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