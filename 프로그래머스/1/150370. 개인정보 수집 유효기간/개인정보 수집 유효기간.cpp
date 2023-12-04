#include <string>
#include <vector>
#include <sstream>
#include <ctime>
#include <cstdlib>
#include <map>

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
    tDate.tm_year  = atoi(ymd[0].c_str());
    tDate.tm_mon = atoi(ymd[1].c_str()) + addMon - 1;
    if (isExp)
        tDate.tm_mday = atoi(ymd[2].c_str()) - 1;
    else
        tDate.tm_mday = atoi(ymd[2].c_str());
    mktime(&tDate);
    if (tDate.tm_mday > 28)
        tDate.tm_mday = 28;
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
    mTerms = vectorStringToMap(terms);
    for (size_t i = 0; i < privacies.size(); ++i)
    {
        if (!isExpVaild(privacies[i], mTerms, dToday))
            answer.push_back(i + 1);
    }
    return answer;
}