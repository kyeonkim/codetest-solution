#include <string>
#include <vector>
#include <sstream>
#include <ctime>
#include <cstdlib>
#include <map>

#include <iostream>

using namespace std;

vector<string> split(string& str, char delimiter)
{
    vector<string> rtv;
    stringstream   ss(str);
    string         word;
    
    while (getline(ss, word, delimiter))
        rtv.push_back(word);
    return rtv;
}

time_t stringToDate(string& today, int addMon, bool isExp)
{
    tm     tDate{};
    vector<string> ymd;
    
    ymd = split(today, '.');
    // cout << ymd[0] << " " << ymd[1] << " " << ymd[2] << endl;
    tDate.tm_year  = atoi(ymd[0].c_str());
    tDate.tm_mon = atoi(ymd[1].c_str()) + addMon - 1;
    if (isExp)
        tDate.tm_mday = atoi(ymd[2].c_str()) - 1;
    else
        tDate.tm_mday = atoi(ymd[2].c_str());
    mktime(&tDate);
    if (tDate.tm_mday > 28)
        tDate.tm_mday = 28;
    // cout << tDate.tm_year << " " << tDate.tm_mon << " " << tDate.tm_mday << endl;
    return mktime(&tDate);
}

map<string, int> vectorStringToMap(vector<string>& terms)
{
    map<string, int> mTerms;
    vector<string> typeExp;
    
    for (size_t i = 0; i < terms.size(); ++i)
    {
        typeExp = split(terms[i], ' ');
        mTerms[typeExp[0]] = atoi(typeExp[1].c_str());
    }
    return mTerms;
}

bool isExpVaild(string& privacie, map<string, int>& mTerms, time_t& dToday)
{
    vector<string> dateType;
    time_t         pDate;
    
    dateType = split(privacie, ' ');
    pDate = stringToDate(dateType[0], mTerms[dateType[1]], true);
    if (dToday <= pDate)
        return true;
    return false;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int>    answer;
    time_t         dToday;
    map<string, int> mTerms;
    
    dToday = stringToDate(today, 0, false);
    // cout << dToday << endl;
    mTerms = vectorStringToMap(terms);
    // for (map<char, int>::iterator it = mTerms.begin(); it != mTerms.end(); ++it)
    //     cout << it->first << " " << it->second << endl;
    for (size_t i = 0; i < privacies.size(); ++i)
    {
        if (!isExpVaild(privacies[i], mTerms, dToday))
            answer.push_back(i + 1);
    }
    return answer;
}