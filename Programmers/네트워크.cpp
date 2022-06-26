#include <string>
#include <vector>

using namespace std;

void search(vector<vector<int>>& computers, int n, vector<bool>& visit, int index) {
    for (int i=0; i<n; i++) {
        if (computers[index][i] == 1 && !visit[i]) {
            visit[i] = true;
            search(computers, n, visit, i);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<bool> visit(n, false);
    for (int i=0; i<n; i++) {
        if (visit[i]) continue;
        search(computers, n, visit, i);
        answer++;
    }
    return answer;
}

int main() {
    vector<vector<int>> computers = {
        {1, 1, 0},
        {1, 1, 1},
        {0, 1, 1}
    };
    solution(3, computers);
}