#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    int *arr = new int[n] {0, };
    
    for (int value : lost) arr[value - 1]--;
    for (int value : reserve) arr[value - 1]++;
    for (int i=0; i<n; i++) {
        if (arr[i] >= 1) {
            if (i != 0 && arr[i-1] == -1) {
                arr[i]--;
                arr[i-1]++;
            } else if (i != n-1 && arr[i+1] == -1) {
                arr[i]--;
                arr[i+1]++;
            }
        }
    }
        
    for (int i=0; i<n; i++) {
        if (arr[i] >= 0) answer++;
    }
    
    return answer;
}