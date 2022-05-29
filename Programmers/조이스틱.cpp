#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string name) {
    int answer = 0;
    int length = name.size();
    int aCount = 0;
    int moveCount = length - 1;

    for (int currentIndex = 0; currentIndex < name.size(); currentIndex++) {
        answer += min(name[currentIndex] - 'A', 'Z' - name[currentIndex] + 1);

        aCount = currentIndex + 1;
        while (aCount < length && name[aCount] == 'A') {
            aCount++;
        }

        moveCount = min(moveCount, currentIndex * 2 + length - aCount);
        moveCount = min(moveCount, (length - aCount) * 2 + currentIndex);
    }
    
    return answer + moveCount;
}
