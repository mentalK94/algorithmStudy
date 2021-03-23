/**
 * import java.util.StringTokenizer;
 * 
 * */

package scofe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int sTime = 0;
		int eTime = Integer.MAX_VALUE;
		
		for(int i=0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), "~");
			String startTimeStr = st.nextToken();
			String endTimeStr = st.nextToken();
			
			int startTime = timeToInt(startTimeStr);
			int endTime = timeToInt(endTimeStr);
						
			sTime = sTime > startTime ? sTime : startTime;
			eTime = eTime < endTime ? eTime : endTime;
			
			if(sTime > eTime) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(intToTime(sTime) + " ~ " +intToTime(eTime));
	}

	private static int timeToInt(String time) {
		StringTokenizer st = new StringTokenizer(time, ":");
		int HH = Integer.parseInt(st.nextToken().trim());
		int MM = Integer.parseInt(st.nextToken().trim());
		
		return HH*60 + MM;
	}
	
	private static String intToTime(int time) {
		return String.format("%02d:%02d", (time/60), (time%60));
	}

}
