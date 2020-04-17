/*
** programmers-가사 검색.cpp
** 2020-04-17
*/

#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>

using namespace std;

vector<string> wordsMemory[10001];
map<string, int> queryMap;

bool compare(string a, string b) {
	if(a.length() != b.length()) { // 글자 길이별로 저장 
		return a.length() < b.length();
	} else { // 사전 순으로 저장 
		return a<b;
	}
}

vector<int> solution(vector<string> words, vector<string> queries) {
    vector<int> answer;
    int idx = -1;
    int length, querySize, questionMarkCnt, count;
    string query;
    char start, end;
    
    sort(words.begin(), words.end(), compare);
    
    for(int i=0; i<words.size(); i++) {
    	wordsMemory[words[i].length()].push_back(words[i]);
	}
	
	querySize = queries.size()-1;
	while(idx < querySize) {

		query = queries[++idx];		
		
		length = query.length();
		
		start = query.at(0); // 첫 글자 
		end = query.at(query.length()-1); // 마지막 글자 
		
		if(start == '?' && end == '?') { // query모두 ?인경우 
			answer.push_back(wordsMemory[length].size());
			continue; 
		}
		
		if(start == '?') { // 앞부분이 ?인경우 
			
			if(!(queryMap.find(query) == queryMap.end())) {
				answer.push_back(queryMap[query]);
				continue;			
			}
								
			questionMarkCnt = 0; // 물음표 개수 
			for(int i=0; i<query.length(); i++) {
				if(query[i] != '?') 
					break;
				questionMarkCnt++;
			}
			count = 0;
			for(int i=0; i<wordsMemory[length].size(); i++) {				
				if(query.substr(questionMarkCnt, query.length()) == wordsMemory[length][i].substr(questionMarkCnt, query.length()))
					count++;
			}
			
			queryMap.insert(make_pair(query, count));
			answer.push_back(count);
			continue; 
		}
		
		if(end == '?') { // 뒷부분이 ?인경우
		
			if(!(queryMap.find(query) == queryMap.end())) {
				answer.push_back(queryMap[query]);
				continue;			
			}
			 
			questionMarkCnt = 0; // 물음표 개수 
			for(int i=query.length()-1; i>0; i--) {
				if(query[i] != '?') 
					break;
				questionMarkCnt++;
			}
			
			count = 0;
			for(int i=0; i<wordsMemory[length].size(); i++) {
				if(query[0] < wordsMemory[length][i][0])
					break;
				if(query.substr(0, query.length()-questionMarkCnt) == wordsMemory[length][i].substr(0, query.length()-questionMarkCnt))
					count++;
			}
			
			queryMap.insert(make_pair(query, count));
			answer.push_back(count);
			continue; 	
		}		
		
	}

    return answer;
}

int main(void) {
	
	vector<string> words;
	vector<string> queries;
	vector<int> answer;
	
	words.push_back("frodo");
	words.push_back("front");
	words.push_back("frost");
	words.push_back("frozen");
	words.push_back("frame");
	words.push_back("kakao");
	
	queries.push_back("fro??");
	queries.push_back("????o");
	queries.push_back("fr???");
	queries.push_back("fro???");
	queries.push_back("pro?");
	
	answer = solution(words, queries);
	
	for(int i=0; i<answer.size(); i++) {
		cout << answer[i] << endl;
	}
	
	return 0; 
}
