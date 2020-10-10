import java.util.ArrayList;
import java.util.Collections;

class XY implements Comparable<XY>{
	int start;
	int end;
	
	public XY(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(XY o) {
		//start기준으로 오름차순 정렬
		if(this.start == o.start) {
			return Integer.compare(o.end, this.end);	
		} 
		return Integer.compare(this.start, o.start);
	}
}

public class Solution3 {
	public static void main(String[] args) {
		Solution3 s3 = new Solution3();
		int n = 10;
		int n2 = 7;
		int n3 = 100;
		int[][] groups = {{1, 5},{2, 7},{4, 8},{3, 6}};
		int[][] groups2 = {{6, 7},{1, 4},{2, 4}};
		int[][] groups3 = {{1, 50},{1, 100},{51, 100}};
		s3.solution(n3, groups3);
	}

	public int solution(int n, int[][] groups) {
		int answer = 0;
		
		boolean[] bulbs = new boolean[n+1]; // 1부터 시작
		ArrayList<XY> list = new ArrayList<>();
		
		for(int i=0; i<groups.length; i++) {
			list.add(new XY(groups[i][0], groups[i][1]));
		}
		
		Collections.sort(list);
		
		int end = list.get(0).end;
		// 1. 첫번째 그룹 작업 선택
		for(int i=list.get(0).start; i<=list.get(0).end; i++) {
			bulbs[i] = true;
		}
		answer++;
		
		for(int i=1; i<list.size(); i++) {
			// 그룹작업 선택
			// 끝 번호의 전구를 기준으로 가장 긴 것 선택
			int selectIdx = 0;
			int tempEnd = 0;
			boolean flag1 = false;
			boolean flag2 = false;
			if(list.get(i).end <= end) {
				continue;
			}
			while(i < list.size() && list.get(i).start <= end+1) {
				if(tempEnd < list.get(i).end) {
					selectIdx = i;
					tempEnd = list.get(i).end;
					flag2 = true;
				}
				flag1 = true;
				i++;
			}

			if(flag1) {	i--;}
			if(!flag2) {
				selectIdx = i;
			}
			
			for(int j=list.get(selectIdx).start; j<=list.get(selectIdx).end; j++) {
				bulbs[j] = true;
			}
			answer++;
			end = list.get(selectIdx).end;
		}
		
		for(int i=1; i<=n; i++) {
			if(!bulbs[i]) answer++;
		}
		
		return answer;
	}
}
