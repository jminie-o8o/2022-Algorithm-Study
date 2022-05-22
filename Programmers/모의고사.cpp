#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;

    vector<int> first = {1, 2, 3, 4, 5};
    vector<int> two = {2, 1, 2, 3, 2, 4, 2, 5};
    vector<int> three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int count[3] = {0, };
    for (int i=0; i<answers.size(); i++) {
        if (first[i % first.size()] == answers[i]) count[0]++;
        if (two[i % two.size()] == answers[i]) count[1]++;
        if (three[i % three.size()] == answers[i]) count[2]++;
    }

    int maxValue = max(count[0], max(count[1], count[2]));
    for (int i=0; i<3; i++) {
        if (maxValue == count[i]) answer.push_back(i + 1);
    }
    return answer;
}