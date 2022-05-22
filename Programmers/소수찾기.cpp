#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <set>
#include <cmath>

using namespace std;

bool isPrime(int number) {
    if (number == 0 || number == 1) return false;
    else if (number == 2) return true;
    else if (number % 2 == 0) return false;

    int count = 0;
    for (int i=1; i<=sqrt(number) + 1; i++) {
        if (count >= 2) return false;
        if (number % i == 0) count++;
    }
    return true;
}

int solution(string numbers) {
    vector<int> numberList;
    set<int> numberSet;
    for(int i=0; i<numbers.length(); i++) {
        numberList.push_back(numbers[i] - '0');
    }

    sort(numberList.begin(), numberList.end());
    do {
        int decimal = 1;
        int result = 0;
        for (int i=0; i<numberList.size(); i++) {
            result += numberList[i] * decimal;
            decimal *= 10;
            if (isPrime(result)) {
                numberSet.insert(result);
            }
        }

    }while(next_permutation(numberList.begin(), numberList.end()));

    return numberSet.size();
}
