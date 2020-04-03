package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class ConnectingIslands {

	public static void main(String[] args) {
		ConnectingIslandsSolution connectingIslandsSolution = new ConnectingIslandsSolution();
		int[][] costs = { { 0, 1, 1 }, { 0, 4, 5 }, { 2, 4, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int n = 5;
		System.out.println(connectingIslandsSolution.solution(n, costs));

	}

}

class Island implements Comparable<Island> {
	private int x;
	private int y;
	private int cost;
	
	public Island(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getCost() {
		return cost;
	}

	@Override
	public int compareTo(Island o) {
		if(this.cost > o.cost) {
			return 1;
		}
		else if(this.cost == o.cost) {
			if(this.x > o.x) {return 1;}
			else if(this.x == o.x) {
				if(this.y > o.y) {return 1;}
			}
		}
		return -1;
	}
}

class ConnectingIslandsSolution {
	public int solution(int n, int[][] costs) {
		int answer = 0;
		int idx;
		ArrayList<Island> isLands = new ArrayList<>();
		ArrayList<Island> tempList = new ArrayList<>();
		ArrayList<Integer> landList = new ArrayList<>();
		
		
		for(int i=0; i<costs.length; i++) {
			isLands.add(new Island(costs[i][0], costs[i][1], costs[i][2]));
		}
		
		Collections.sort(isLands);
		
		for(int i=0; i<isLands.size(); i++) {
			 if(!isContain(isLands.get(i).getX(), isLands.get(i).getY(), landList)) { // 연결되지 않은 경우
				 
				 if(landList.contains(isLands.get(i).getX()) || landList.contains(isLands.get(i).getY())) {
					 if(!landList.contains(isLands.get(i).getX()))
						 landList.add(isLands.get(i).getX());
					 if(!landList.contains(isLands.get(i).getY()))
						 landList.add(isLands.get(i).getY());
				 } else {
					 System.out.println(isLands.get(i).getX() + " " + isLands.get(i).getY());
					 idx = isContainTemp(isLands.get(i).getX(), isLands.get(i).getY(), tempList);
	 				 
					 if(idx == -1) {	 
						 tempList.add(isLands.get(i));						 
					 } else {
						 if(!landList.contains(tempList.get(idx).getX()))
							 landList.add(tempList.get(idx).getX());
						 if(!landList.contains(tempList.get(idx).getY()))
							 landList.add(tempList.get(idx).getY());
						 tempList.remove(idx);
					 }
				 }
				 
				 answer += isLands.get(i).getCost();
				 // System.out.println(isLands.get(i).getX() + ", " +isLands.get(i).getY() + ", " +isLands.get(i).getCost());
			 }
			 			 
			 if(isConnect(n, landList))
				 break;
		}
		
		return answer;
	}
	
	public boolean isContain(int x, int y, ArrayList<Integer> landList) {
		if(landList.contains(x) && landList.contains(y)) { return true;}
		return false;
	}
	
	public int isContainTemp(int x, int y, ArrayList<Island> tempList) {
		
		for(int i=0; i<tempList.size(); i++) {
			if(tempList.contains(x) || tempList.contains(y)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean isConnect(int n,  ArrayList<Integer> landList) {
		if(landList.size() == n) {return true;}
		return false;
	}
	
//	public void connect(ArrayList<Island> tempList) {
//		
//	}
	
}