package programmers;

import java.util.*;

public class TravelRoute2 {

	public static void main(String[] args) {
		// String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" }};
		String[][] tickets = { { "ICN", "COO" }, { "ICN", "BOO" }, { "COO", "ICN" }, { "BOO", "DOO" }};
		
		TravelRouteSolution2 tSolution = new TravelRouteSolution2();
		tSolution.solution(tickets);

	}
}

class TravelRouteSolution2 {
        static class Ticket implements Comparable<Ticket> {
            public String from;
            public String to;
            public boolean used;

            @Override
            public int compareTo(Ticket ticket) {
                return this.to.compareTo(ticket.to);
            }
        }

        public String[] solution(String[][] tickets) {

            Ticket[] ticketList = new Ticket[tickets.length];

            for (int i = 0; i < tickets.length; i++) {
                Ticket ticket = new Ticket();
                ticket.from = tickets[i][0];
                ticket.to = tickets[i][1];
                ticket.used = false;
                ticketList[i] = ticket;
            }

            String from = "ICN";
            int cnt = 0;
            
            List<Ticket> queue;
            List<String> answers = new ArrayList<>();
            answers.add(from);

            while (true) {
//            	System.out.println(cnt);
            	if(cnt == tickets.length)
            		break;
            	
                queue = new ArrayList<>();
                for (int i = 0; i < ticketList.length; i++) {
                    if (!ticketList[i].used && ticketList[i].from.equals(from)) {
                        queue.add(ticketList[i]);
                    }
                }

                Collections.sort(queue);
//                for (int i = 0; i < queue.size(); i++) {
//                    System.out.println(queue.get(i).from + ", " + queue.get(i).to);
//                }
                if (queue.size() > 1) {
                    for (int i = 0; i < queue.size(); i++) {
                        Ticket ticket = queue.get(i);
                        if(dfs(ticketList, ticket.to, ticket.from)){
                            answers.add(ticket.to);
                            from = ticket.to;
                            ticket.used = true;
                            cnt++;
                            break;
                        }
                    }

                } else if (queue.size() == 1 && !queue.get(0).used) {
                    queue.get(0).used = true;
                    answers.add(queue.get(0).to);
                    from = queue.get(0).to;
                    cnt++;
                }
            }
            String[] answer = new String[answers.size()];
            for (int i = 0; i < answers.size(); i++) {
                answer[i] = answers.get(i);
                System.out.println(answer[i]);
            }
            return answer;
        }

        public boolean dfs(Ticket[] ticketList, String start, String target){
            if(start.equals(target)){
                return true;
            }

            for(int i=0; i<ticketList.length; i++){
                if(!ticketList[i].used && start.equals(ticketList[i].from)){
                    if(dfs(ticketList, ticketList[i].to, target))
                        return true;
                }
            }
            return false;
        }
    }
