#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    vector<int> tmpArray;
    for (int i=0; i<commands.size(); i++) {
        tmpArray.assign(
            array.begin() + commands[i][0] - 1, 
            array.begin() + commands[i][1]
        );

        sort(tmpArray.begin(), tmpArray.end());
        answer.push_back(tmpArray[commands[i][2] - 1]);
    }

    return answer;
}
