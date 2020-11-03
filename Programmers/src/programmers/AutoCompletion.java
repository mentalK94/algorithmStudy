/**
 * programmers - 2018 카카오 블라인드 채용. 자동완성
 * AutoCompletion.java
 * @date 2020-08-25
 * @author hansolKim
 **/

package programmers;

import java.util.ArrayList;
import java.util.HashMap;

class Trie {
	TrieNode node;
	
	public Trie() {
		node = new TrieNode(' ');
	}
	
	public void insert(String word) {
		for(int i=0; i<word.length(); i++) {
			if(node.child.get(word.charAt(i)) != null) {
				node = node.child.get(word.charAt(i));
			} else {
				node = node.insertChild(word.charAt(i));
			}
		}
		node.isLastNode = true;
	}
	
	public ArrayList<TrieNode> findLastNode(String word) {
        ArrayList<TrieNode> retList = new ArrayList<TrieNode>();
        
        TrieNode current = node;
        
        //입력된 word에 해당하는 마지막 TrieNode를 탐색
        for(char c : word.toCharArray()) {
            if(current.child.get(c)!=null) {
                current = current.child.get(c);
            }
            else {
                retList.clear();
                return retList;
            }
        }
        
        // 마지막 TrieNode가 leaf이면 추가
        if(current.isLastNode) {
            retList.add(current);
        }
        
        // 현재 TrieNode에 연결된 자식노드들의 모든 leaf를 추가
        retList.addAll(current.getAllLastNode());
        return retList;
    }

}

class TrieNode {
	char character;
	boolean isLastNode; // 마지막노드인지 확인
	HashMap<Character, TrieNode> child; // 자식노드
	
	public TrieNode(char c) { // 생성자
		this.character = c;
		child = new HashMap<>();
		isLastNode = false;
	}
	
	public TrieNode insertChild(char c) { // child node 추가
		TrieNode newTrieNode = new TrieNode(c);
		child.put(c, newTrieNode);
		return newTrieNode;
	}
	
	public ArrayList<TrieNode> getAllLastNode() {
        ArrayList<TrieNode> retList = new ArrayList<TrieNode>();
        for(TrieNode child : child.values()) {
            if(child.isLastNode) {
                retList.add(child);
            }
            retList.addAll(child.getAllLastNode());
        }
        return retList;
    }
}

public class AutoCompletion {
	
	public static void main(String[] args) {
		AutoCompletion ac = new AutoCompletion();
		String[] words = {"go", "gone", "guild"};
		String[] words2 = {"abc", "def", "ghi", "jklm"};
		String[] words3 = {"word", "war", "warrior", "world"};
		ac.solution(words );
	}
	
	public int solution(String[] words) {
		Trie trie=  new Trie();
	    for(String word : words) {
	        trie.insert(word);
	    }
	    
	    // 입력 데이터 별 카운트
	    int answer = 0;
	    for(String str : words) {
	        for(int i = 1 ; i <= str.length() ; i++) {
	        	answer++;
	            String word = str.substring(0, i);
	            System.out.println(word);
	            
	            // 한글자씩 늘려서 나오는 노드가 1개인 경우 더이상 진행하지 않음
	            System.out.println(trie.findLastNode(word).size());
	            if(trie.findLastNode(word).size() == 1) {
	                break;
	            }
	           
	        }
	    }
	 
	    System.out.println(answer);
	    return answer;
	}

}
