#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> money) {
    int answer = 0;
    
    int n = money.size();
    vector<int> d1(n);
    vector<int> d2(n);

    // d[i] = d[i-2] + money[i]

    // 첫번째 집을 털었을 때
    // i-2 => 인접한 곳은 털 수 없으므로 i-2까지의 값을 더하기 위해
    d1[0] = money[0];
    d1[1] = d1[0]; // 인접한 i+1은 i값으로 대체

    // 첫번째 집을 털지 않았을 때
    d2[0] = 0;
    d2[1] = money[1];

    for (int i=2; i<n; i++) {
        d1[i] = max(d1[i-2] + money[i], d1[i-1]);
    }

    for (int i=2; i<n; i++) {
        d2[i] = max(d2[i-2] + money[i], d2[i-1]);
    }

    return max(d1[n-2], d2[n-1]);
}
