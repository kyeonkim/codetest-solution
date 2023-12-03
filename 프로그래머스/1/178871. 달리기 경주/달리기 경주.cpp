#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string>   answer;
    map<string, int> setIdx;
    int              getIdx;
    
    answer = players;
    for (size_t i = 0; i < answer.size(); ++i)
        setIdx[answer[i]] = i;
    for (size_t i = 0; i < callings.size(); ++i)
    {
        getIdx = setIdx[callings[i]];
        swap(setIdx[answer[getIdx]] , setIdx[answer[getIdx - 1]]);
        swap(answer[getIdx] , answer[getIdx - 1]);
    }
    return answer;
}