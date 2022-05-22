#include<iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
vector<int> V;

int binarySearch(int start, int end, int value) {
	if (start > end) return -1;
	else if (start == end) {
		if (V[start] == value) return start;
		else return -1;
	}
	else {
		int mid = (start + end) / 2;
		if (V[mid] == value) return mid;
		else if (V[mid] > value) return binarySearch(start, mid - 1, value);
		else return binarySearch(mid + 1, end, value);
	}
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) {
		int n;
		cin >> n;
		V.push_back(n);
	}

	sort(V.begin, V.end()); // 이분탐색 위해서 정렬 필요

	cin >> M;
	for (int i = 0; i < M; i++) {
		int n;
		cin >> n;

		int check = binarySearch(0, N - 1, n);

		if (check >= 0) cout << "1\n";
		else cout << "0\n";
	}


	return 0;
}

