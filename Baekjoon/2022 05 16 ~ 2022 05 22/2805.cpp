#include<iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
vector<int> V;

long long int Answer = 0;

void binarySearch(long long int start, long long int end) {

	if (start > end) return;

	long long int mid = (start + end) / 2;


	long long int treeGet = 0;

	for (int i = 0; i < V.size(); i++) {
		if (V[i] - mid > 0) {
			treeGet += (V[i] - mid);
		}
	}

	if (treeGet == M) Answer = mid;
	else if (treeGet > M) {
		if (mid > Answer)
			Answer = mid;

		binarySearch(mid + 1, end);

	}
	else {
		binarySearch(start, mid - 1);
	}
}


int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int n;
		cin >> n;
		V.push_back(n);
	}

	sort(V.begin(), V.end());


	binarySearch(0, V[N - 1]);  // ���� ���� ���� ���ϱ� ���� sort

	cout << Answer;

	return 0;
}

// �ڷ����� ����

// log n �� �ɸ��� �̺� Ž������ �Ź� ��ü�� ���鼭 ���̸� ��������Ƿ� nlogn �ð����⵵