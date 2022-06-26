#include <string>
#include <vector>
#include <iostream>

using namespace std;

int Count = 0;
vector<int> Numbers;
int Target = 0;

void getResult(int sum, int inx) {
	if (inx == Numbers.size()) {
		if (sum == Target) Count++;
		//cout << "hihi\n";
	}
	else {
		getResult(sum - Numbers[inx], inx + 1);
		getResult(sum + Numbers[inx], inx + 1);
	}
}

int solution(vector<int> numbers, int target) {
	int answer = 0;

	for (int i = 0; i < numbers.size(); i++) Numbers.push_back(numbers[i]);
	Target = target;

	//cout << Numbers.size() << "\n";

	getResult(0, 0);

	answer = Count;

	return answer;
}