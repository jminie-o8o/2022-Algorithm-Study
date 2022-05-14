#include<iostream>
#include <vector>
#include <algorithm>  // min �Լ� ����ϱ� ����

using namespace std;

int dp[1000005] = { 0, };

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;

	dp[1] = 0;

	for (int i = 2; i <= N; i++) {
		dp[i] = dp[i - 1] + 1;
		if (i % 3 == 0) dp[i] = min(dp[i / 3] + 1, dp[i]);
		if (i % 2 == 0) dp[i] = min(dp[i / 2] + 1, dp[i]);
	}

	cout << dp[N];

	return 0;
}
