#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string number, int k) {
	string answer = "";

	// ���Ϸ��� ���� �ڸ���
	int digitCount = number.length() - k;
	// cout<< digitCount << "\n";

	int findInx = -1;
	for (int i = digitCount; i >= 1; i--) {

		char max = '0';
		int inx = -1;

		for (int j = number.length() - i; j > findInx; j--) {

			char current = number[j];
			if (current >= max) {
				max = current;
				inx = j;
			}

		}

		findInx = inx; //���� �ڸ����� ���� ���� ��ġ, ���� �ڸ����� �� ��ġ �� ���� Ž�� ����
		answer += max;

		// cout << "findInx : " << findInx << "\n";
	}


	return answer;
}


// �ڿ��� ���� ������� ���� �� �ڸ��� ���� �ִ밪�� ã�� ���