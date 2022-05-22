#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;

    if (yellow == 1) {
        answer.push_back(3);
        answer.push_back(3);
        return answer;
    }

    for (int i=1; i<=sqrt(yellow); i++) {
        int height = i;
        int width = yellow / i;
        if (height * width != yellow) continue;

        int result = (width + 2) * 2 + height * 2;
        if (result == brown) {
            answer.push_back(width + 2);
            answer.push_back(height + 2);
            break;
        }
    }

    return answer;
}
