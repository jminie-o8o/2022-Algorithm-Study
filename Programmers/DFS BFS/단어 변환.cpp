#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <map>

using namespace std;

int solution(string begin, string target, vector<string> words)
{

	bool isExist = false;
	for (int i = 0; i < words.size(); i++)
	{
		if (target == words[i])
			isExist = true;
	}
	if (!isExist)
		return 0;

	map<string, int> visited;
	queue<pair<string, int>> q;

	visited[begin] = 1;
	q.push({begin, 0});

	while (!q.empty())
	{
		string currentStr = q.front().first;
		int currentCnt = q.front().second;
		q.pop();

		if (currentStr == target)
			return currentCnt;

		for (int i = 0; i < words.size(); i++)
		{
			if (visited[words[i]] == 0)
			{
				int gap = 0;
				for (int j = 0; j < currentStr.length(); j++)
				{
					if (currentStr[j] != words[i][j])
						gap++;
				}
				if (gap == 1)
				{
					cout << words[i] << "\n";
					visited[words[i]] = 1;
					q.push({words[i], currentCnt + 1});
				}
			}
		}
	}
}