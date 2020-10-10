import java.util.StringTokenizer;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 s2 = new Solution2();
		String p = "PM 11:59:59";
		int n = 15; 
		s2.solution(p, n);
	}

	public String solution(String p, int n) {
		
		StringTokenizer st = new StringTokenizer(p);
		String div = st.nextToken();
		String time = st.nextToken();
		
		st = new StringTokenizer(time, ":");
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		if(h == 12) {
			h = div.equals("AM") ? 0 : 12;
		} else {
			h = div.equals("PM") ? h+12 : h;
		}
		
		int t = h*3600+m*60+s;
		t += n;
		t %= 86400; // 하루
		
		int newHH = t/3600;
		t -= (newHH*3600);
		int newMM = t/60;
		t -= (newMM*60);
		int newSS = t;
		
		StringBuilder sb = new StringBuilder();
		if(newHH < 10) {
			sb.append(0);
		}
		sb.append(newHH);
		sb.append(":");
		if(newMM < 10) {
			sb.append(0);
		}
		sb.append(newMM);
		sb.append(":");
		if(newSS < 10) {
			sb.append(0);
		}
		sb.append(newSS);
		
		String answer = sb.toString();
		System.out.println(answer);
		return answer;
	}
}
