import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem6 {

	public static void main(String[] args) {
		Problem6 p6 = new Problem6();
		String[] companies = {"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
		String[] applicants = {"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"};
		String[] companies2 = {"A abc 2", "B abc 1"};
		String[] applicants2 = {"a AB 1", "b AB 1", "c AB 1"};
		p6.solution(companies, applicants);
	}

	public String[] solution(String[] companies, String[] applicants) {
        String[] answer = new String[companies.length];
        List<Applicant> applicantList = new ArrayList<>();
        List<Company> companyList = new ArrayList<>();
        PriorityQueue<QApplicant>[] q = new PriorityQueue[companies.length];
        
        for(int i=0; i<companies.length; i++) {
        	q[i] = new PriorityQueue<QApplicant>();
        }
        
        // 1. 지원자 정보저장
        for(int i=0; i<applicants.length; i++) {
        	StringTokenizer st = new StringTokenizer(applicants[i]);
        	applicantList.add(new Applicant(st.nextToken().charAt(0), st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        
        // 2. 회사 정보저장
        for(int i=0; i<companies.length; i++) {
        	StringTokenizer st = new StringTokenizer(companies[i]);
        	companyList.add(new Company(st.nextToken().charAt(0), st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        
        // 2. 지원자 잠정 지원
        for(int i=0; i<applicantList.size(); i++) {
        	// 지원자 순위 알아내기
        	int rank = 0;
        	for(int j=0; j<companyList.size(); j++) {
        		if(companyList.get(j).name == applicantList.get(i).company.charAt(0)) {
        			for(int k=0; k<companyList.get(j).prior.length(); k++) {
        				if(companyList.get(j).prior.charAt(k) == applicantList.get(i).name) {
        					rank = k;
        				}
        			}
        		}
        	}
        	
        	applicantList.get(i).n++; // 지원 횟수 추가
        	q[applicantList.get(i).company.charAt(0)-65].add(new QApplicant(applicantList.get(i).name, rank));
        }
        
        // 3. 각 회사별로 지원자 수 검사해서 넘친 경우 탈락자 배출 -> 해당 탈락자 재지원
        for(int i=0; i<q.length; i++) {
        	
        	int temp = i;
        	
        	while(companyList.get(i).num < q[i].size()) { // 해당 회사에 지원자 수가 넘칠 때
        		QApplicant qApplicant = q[i].poll(); // 해당 지원자 탈락
        		int idx = qApplicant.name-97; // 탈락한 지원자의 index
        		
        		// 탈락된 지원자가 희망하는 기업수와 지원횟수가 같은경우 continue
        		if(applicantList.get(idx).cnt == applicantList.get(idx).n) {
        			continue;
        		} else { // 다음 곳을 지원
        			int cIdx = applicantList.get(idx).company.charAt(applicantList.get(idx).n)-65; // 다음 지원할 회사 idx
        			int rank = 0;
        			
        			for(int k=0; k<companyList.get(cIdx).prior.length(); k++) {
        				if(companyList.get(cIdx).prior.charAt(k) == applicantList.get(idx).name) {
        					rank = k;
        				}
        			}
        			
        			q[cIdx].add(new QApplicant(applicantList.get(idx).name, rank));
        			applicantList.get(idx).n++; // 지원 횟수 추가
        			temp = Math.min(temp, cIdx-1);
        		}
        	}
        	
        	i = Math.min(temp, i);
        	
        }
        
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> temp = new ArrayList<>();
        for(int i=0; i<answer.length; i++) {
        	sb.append(companyList.get(i).name).append("_");
        	while(!q[i].isEmpty()) {
        		temp.add(q[i].poll().name);
        	}
        	
        	Collections.sort(temp);
        	
        	for(int j=0; j<temp.size(); j++) {
        		sb.append(temp.get(j));
        	}
        	
        	answer[i] = sb.toString();
        	temp.clear();
        	sb.replace(0, sb.length(), "");
        }
        
        return answer;
    }
}

class Company {
	char name;
	String prior; // 채용 순위
	int num; // 채용 인원
	
	public Company(char name, String prior, int num) {
		this.name = name;
		this.prior = prior;
		this.num = num;
	}
}

class Applicant {
	char name;
	String company;
	int cnt;
	int n = 0; // 지원 횟수
	
	public Applicant(char name, String company, int cnt) {
		this.name = name;
		this.company = company;
		this.cnt = cnt;
	}
}

class QApplicant implements Comparable<QApplicant>{
	char name;
	int rank;
	
	public QApplicant(char name, int rank) {
		this.name = name;
		this.rank = rank;
	}

	@Override
	public int compareTo(QApplicant o) {
		return Integer.compare(o.rank, this.rank);
	}
	
}