#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    
    int startIdx = 0;
    int maxIdx = 0;
    for (int i=0; i<number.size() - k; i++) {
        char max = number[startIdx];
        
        for (int j=startIdx; j<=k+i; j++) {
            if (number[j] > max) {
                max = number[j];
                maxIdx = j;
            }
        }
        
        startIdx = maxIdx + 1;
        maxIdx = startIdx;
        answer += max;
    }
    
    return answer;
}