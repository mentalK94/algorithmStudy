import java.util.StringTokenizer;

public class Solution2 {

	public static void main(String[] args) {
		Solution2 s2 = new Solution2();
		int n = 3;
		int n2 = 2;
		String[] customers = {"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"};
		String[] customers2 = {"02/28 23:59:00 03","03/01 00:00:00 02", "03/01 00:05:00 01"};
		s2.solution(2, customers2);
	}
	
	public int solution(int n, String[] customers) {		
		int answer=0;
		
		int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
		
		int[][] kiosk = new int[n][3]; // 횟수, kiosk 운영여부(0, 종료시각), 가장 최근에 종료된 시각
		int[][] customer = new int[customers.length][2];
		
		for(int i=0; i<customers.length; i++) {
			StringTokenizer st = new StringTokenizer(customers[i]);
			String date = st.nextToken();
			String time = st.nextToken();
			int requiredTime = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(date, "/");
			int M = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(time, ":");
			int h = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			int startTime = s+m*60+h*3600+day*(24*3600);
			int dd = 0;
			for(int j=1; j<M; j++) {
				dd += month[j];
			}
			
			startTime+=(24*3600*dd);
			
			customer[i][0] = startTime;
			customer[i][1] = startTime+(requiredTime*60);
		}
		
		for(int i=0; i<customer.length; i++) {
			
			int curTime = customer[i][0]; // 현재 고객이 도착한 시각
			int kioskIdx = 0;
			int remainTime = 0;
			boolean isEmptyKiosk = false; // 빈 키오스크가 있는 경우
			
			
			// 0. 현재 시각을 기준으로 키오스크 종료시각  확인해서 시간이 지난 경우 종료표기
			for(int j=0; j<kiosk.length; j++) {
				if(kiosk[j][1] == 0) continue; // 키오스크가 운영되지 않은 경우
				// 키오스크가 운영 중인 경우
				if(kiosk[j][1] <= curTime) { // 키오스크 종료시각이 현재시각보다 같거나 이전인 경우 종료
					kiosk[j][1] = 0;
				}
			}
			
			// 1. 운영되지 않은 키오스크 확인
			// 1-1. 운영되지 않은 시간이 가장 긴 키오스크 확인
			for(int j=0; j<kiosk.length; j++) {
				// 키오스크가 현재 운영되지 않고 운영되지 않은 시간이 지금까지 비교한 시간보다 긴 경우
				if(kiosk[j][1] == 0 && remainTime < curTime-kiosk[j][2]) {
					remainTime = curTime-kiosk[j][2];
					kioskIdx = j;
					isEmptyKiosk = true;
				}
			}
			
			// 빈 키오스크가 없는 경우 ---> 가장 일찍 종료될 예정인 키오스크와 매칭(여러 대인 경우 고유번호가 낮은 키오스크와 매칭)
			if(!isEmptyKiosk) {
				remainTime = Integer.MAX_VALUE;
				kioskIdx = 0;
				
				for(int j=0; j<kiosk.length; j++) {
					if(kiosk[j][1]-curTime < remainTime) {
						remainTime = kiosk[j][1]-curTime;
						kioskIdx = j;
					}
				}
			} 
			
			//System.out.println(" " + (kioskIdx+1));
			kiosk[kioskIdx][0]++;
			kiosk[kioskIdx][1] = customer[i][1]; // 종료시각 입력
			kiosk[kioskIdx][2] = customer[i][1]; // 가장 최근에 종료된 시각 갱신
		}
				
		for(int i=0; i<kiosk.length; i++) {
			if(answer < kiosk[i][0]) {
				answer = kiosk[i][0];
			}
		}
		
		System.out.println(answer);
		return answer;
	}

}