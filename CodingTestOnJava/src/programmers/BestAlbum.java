package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class BestAlbum {
	public static void main(String[] args) {
		BestAlbumSolution albumSolution = new BestAlbumSolution();
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		albumSolution.solution(genres, plays);

	}
}

class BestAlbumSolution {
	public int[] solution(String[] genres, int[] plays) {

		int[] answer = {};
		HashMap<String, Integer> albums = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			if (albums.containsKey(genres[i])) { // 장르가 해시에 존재하는 경우
				albums.put(genres[i], albums.get(genres[i]) + plays[i]);
			} else {
				albums.put(genres[i], plays[i]);
			}
		}

		ArrayList<String> sortedGenres = new ArrayList<>();

		sortedGenres = sortByValue(albums);

		ArrayList<Integer> bestAlbum = new ArrayList<>();
		for (int i = 0; i < sortedGenres.size(); i++) {

			HashMap<Integer, Integer> temp = new HashMap<>();
			String genre = sortedGenres.get(i);
			for (int j = 0; j < plays.length; j++) {
				if (genres[j].equals(genre))
					temp.put(j, plays[j]);
			}

			ArrayList<Integer> sortedIndex = sortByValue2(temp);
			if(sortedIndex.size() >= 2)
				bestAlbum.addAll(sortedIndex.subList(0, 2));
			else
				bestAlbum.addAll(sortedIndex);
		}

		answer = new int[bestAlbum.size()];
		
		for(int i=0; i<bestAlbum.size(); i++) 
			answer[i] = bestAlbum.get(i);
		
		return answer;
	}

	public ArrayList<String> sortByValue(HashMap<String, Integer> albums) {

		List<String> list = new ArrayList<>();
		list.addAll(albums.keySet());

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				Object v1 = albums.get(o1);
				Object v2 = albums.get(o2);

				return ((Comparable) v2).compareTo(v1);
			}
		});

		// Collections.reverse(list);
		return (ArrayList<String>) list;
	}

	public ArrayList<Integer> sortByValue2(HashMap<Integer, Integer> albumIndexs) {

		List<Integer> list = new ArrayList<>();
		list.addAll(albumIndexs.keySet());

		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				Object v1 = albumIndexs.get(o1);
				Object v2 = albumIndexs.get(o2);

				return ((Comparable) v2).compareTo(v1);
			}
		});

		// Collections.reverse(list);
		return (ArrayList<Integer>) list;
	}
}
