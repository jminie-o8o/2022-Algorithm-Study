#include <string>
#include <vector>
#include <algorithm>
#include <deque>
#include <iostream>

using namespace std;

/**
 * 
 *  제한사항에서 구출할 수 없는 경우는 없다고 했으므로 모두 빠져 나갈때까지 반복문을 돌릴 수 있다.
 * 
 *  1. 데이터를 정렬한다.
 *  2. 가장 무거운 애부터 차례대로 가져온다.
 *  3. 현재 가장 가벼운 애와 더했을 때 limit 이하인지 확인한다.
 *  4. 이하라면 구명보트를 탈 수 있으므로 둘 다 제거한다.
 *  5. 초과한다면 구명보트에는 가장 무거운 애만 탈 수 있으므로 가장 무거운 애만 제거한다.
 *  
 */
int solution(vector<int> people, int limit) {
    int answer = 0;

    sort(people.begin(), people.end());
    deque<int> peopleDeque(people.begin(), people.end());

    while (!peopleDeque.empty()) {
        int weight = peopleDeque.back();
        if (peopleDeque.front() + weight <= limit) {
            peopleDeque.pop_front();
        }

        if (!peopleDeque.empty()) peopleDeque.pop_back();
        answer++;
    }

    return answer;
}
