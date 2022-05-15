#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool comp(string& a, string& b) {
    if (a + b > b + a) 
        return true;
    else
        return false;
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> tmp;
    
    for (int number : numbers) {
        tmp.push_back(to_string(number));
    }
    
    sort(tmp.begin(), tmp.end(), comp);
    
    if (tmp[0] == "0")
        return "0";
    
    for (string str : tmp) {
        answer += str;
    }
    return answer;
}