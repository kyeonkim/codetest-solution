#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int answer = 0;
    int durationSuccess = 0;
    int targetTime = 1;
    
    answer = health;
    for (int i = 0; i < attacks.size(); ++i)
    {
        while (targetTime < attacks[i][0])
        {
            if (answer < health)
            {
                if (health < answer + bandage[1])
                    answer = health;
                else
                    answer += bandage[1];
                durationSuccess++;
                if (durationSuccess == bandage[0])
                {
                    if (health <= answer + bandage[2])
                        answer = health;
                    else
                        answer += bandage[2];
                    durationSuccess = 0;
                }
            }
            targetTime++;
        }
        answer -= attacks[i][1];
        if (answer <= 0)
                return -1;
        durationSuccess = 0;
        targetTime++;
    }
    return answer;
}