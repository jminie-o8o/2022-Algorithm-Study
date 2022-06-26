#include <string>
#include <vector>

using namespace std;

int countOfTarget = 0;
void search(vector<int>& numbers, int target, int index, int result) {
    if (result == target && index == numbers.size()) {
        countOfTarget++;
        return;
    }
    if (index > numbers.size()) return;

    search(numbers, target, index+1, result + numbers[index]);
    search(numbers, target, index+1, result - numbers[index]);
}

int solution(vector<int> numbers, int target) {
    search(numbers, target, 0, 0);
    return countOfTarget;
}