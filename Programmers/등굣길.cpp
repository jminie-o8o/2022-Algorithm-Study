#include <string>
#include <vector>

using namespace std;

// D[i][j] = D[i-1][j] + D[i][j-1];
// puddles 행렬이 반대
int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    int map[101][101] = {0, };
    for (const auto &p : puddles) {
        map[p[1]][p[0]] = -1;
    }

    map[1][1] = 1;
    for (int i=1; i<=n; i++) {
        for (int j=1; j<=m; j++) {
            if (i == 1 && j == 1) continue;
            if (map[i][j] == -1) continue;

            map[i][j] += (map[i-1][j] == -1)? 0 : map[i-1][j];
            map[i][j] %= 1000000007;
            map[i][j] += (map[i][j-1] == -1)? 0 : map[i][j-1];
            map[i][j] %= 1000000007;
        }
    }

    return map[n][m];
}
