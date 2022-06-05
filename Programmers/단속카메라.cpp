#include <string>
#include <vector>
#include <algorithm>
#include <list>
#include <iostream>

using namespace std;

bool compare(vector<int> &a, vector<int> &b) {

    if (a[1] < b[1]) {
        return true;
    } else {
        return false;
    }
}

int solution(vector<vector<int>> routes) {
    int answer = 0;

    sort(routes.begin(), routes.end(), compare);
    list<vector<int>> carList(routes.begin(), routes.end());

    int curCarEndPosition;
    while (!carList.empty()) {
        curCarEndPosition = carList.front()[1];
        carList.pop_front();

        int checkCount = carList.size();
        list<vector<int>>::iterator iter = carList.begin();
        int count = 0;
        for (iter=carList.begin(); iter!=carList.end();) {
            auto value = *iter;
            if (value[0] <= curCarEndPosition) {
                iter = carList.erase(iter);
            } else {
                iter++;
            }
        }
        answer++;
    }

    return answer;
}
