#include <string>
#include <vector>
#include <map>
#include <set>
#include <sstream>
#include <iostream>

using namespace std;

vector<string> split(const string& str)
{
    vector<string> rep;
    stringstream ss(str);
    string word;
    
    while (getline(ss, word, ' '))
        rep.push_back(word);
    return rep;
}

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    map<string, int> idCnt;
    map<string, set<string> > blockedId;
    vector<string> rep;
    
    for (size_t i = 0; i < id_list.size(); ++i)
        idCnt[id_list[i]] = 0;
    for (size_t i = 0; i < report.size(); ++i)
    {
        rep = split(report[i]);
        blockedId[rep[1]].insert(rep[0]);
    }
    for (map<string, set<string> >::iterator it = blockedId.begin(); it != blockedId.end(); ++it)
    {
        if ((it->second).size() >= k)
        {
            for (set<string>::iterator sIt = (it->second).begin(); sIt != (it->second).end(); ++sIt)
                idCnt[*sIt]++;
        }
    }
    for (size_t i = 0; i < id_list.size(); ++i)
        answer.push_back(idCnt[id_list[i]]);
    return answer;
}