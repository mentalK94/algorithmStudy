/*
** UnionFind.cpp 
** 2020-04-04
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int getParent(int arr[], int x) {
	if(x == arr[x]) return x;
	return getParent(arr, arr[x]);
}

int unionParent(int arr[], int x, int y) {
	x = getParent(arr, x);
	y = getParent(arr, y);
	if(x<y) arr[y] = x;
	else arr[x] = y;
}

int findParent(int arr[], int x, int y) {
	int a = getParent(arr, x);
	int b = getParent(arr, y);
	if(a == b) return 1;
	return 0;
} 

// 간선 클래스 선언 
class Edge {
	public:
		int node[2];
		int dist;
		Edge(int a, int b, int dist) {
			this->node[0] = a;
			this->node[1] = b;
			this->dist = dist;
		}
		bool operator < (Edge &edge) {
			return this->dist < edge.dist;			
		}
};

int main(void) {
	
	int n = 7;
	int m = 11;
	
	vector<Edge> v;
	v.push_back(Edge(1, 7, 12));
	v.push_back(Edge(1, 4, 28));
	v.push_back(Edge(1, 2, 67));
	v.push_back(Edge(1, 5, 17));
	v.push_back(Edge(2, 4, 24));
	v.push_back(Edge(2, 5, 62));
	v.push_back(Edge(3, 5, 20));
	v.push_back(Edge(3, 6, 37));
	v.push_back(Edge(4, 7, 13));
	v.push_back(Edge(5, 6, 45));
	v.push_back(Edge(5, 7, 73));	
	
	sort(v.begin(), v.end());
	
	int parent[n+1];
	for(int i=1; i<n+1; i++) {
		parent[i] = i;
	}
	
	int sum = 0;
	for(int i=0; i<v.size(); i++) {
		if(!findParent(parent, v[i].node[0], v[i].node[1])) { // 그래프가 사이클을 형성하지 않는 경우 
			unionParent(parent, v[i].node[0], v[i].node[1]); // 그래프 형성 
			sum += v[i].dist;
		}
	}
	
	printf("%d\n", sum);
	return 0;
	
}
