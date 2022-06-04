#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool compare(vector<int> &a, const vector<int> &b) {

    if (a[2] > b[2]) {
        return false;
    } else {
        return true;
    }
}

int find(vector<int> &p, int x) {
    if (p[x] < 0) return x;
    return p[x] = find(p, p[x]);
}

bool is_diff_group(vector<int> &p, int x, int y) {
    x = find(p, x); y = find(p, y);
    if (x == y) return false;
    if (p[x] > p[y]) swap(x, y);
    p[x] += p[y];
    p[y] = x;
    return true;
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    int count = 0;

    sort(costs.begin(), costs.end(), compare);
    vector<int> p(n, -1);
    for (int i=0; i<costs.size(); i++) {
        if (!is_diff_group(p, costs[i][0], costs[i][1])) continue;
        answer += costs[i][2];
        count++;

        if (count == n-1) break;
    }
    
    return answer;
}
