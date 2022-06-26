#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> Computer[205];
int visit[200] = { 0, };

void dfs(int node) {
	visit[node] = 1;

	for (int i = 0; i < Computer[node].size(); i++) {
		int next = Computer[node][i];
		if (visit[next] == 0) {
			dfs(next);
		}
	}
}

int solution(int n, vector<vector<int>> computers) {
	int answer = 0;

	for (int i = 1; i < computers.size(); i++) {
		for (int j = 0; j < i; j++) {
			if (computers[i][j] == 1) {
				Computer[i + 1].push_back(j + 1);
				Computer[j + 1].push_back(i + 1);
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		if (visit[i] == 0) {
			dfs(i);
			answer++;
		}
	}

	return answer;
}