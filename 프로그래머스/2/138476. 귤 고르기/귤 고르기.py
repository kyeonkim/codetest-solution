from collections import defaultdict

def solution(k, tangerine):
    answer = 0
    tangerineDict = defaultdict(int)
    for t in tangerine:
        tangerineDict[t] += 1 
    sortedTangerine = sorted(tangerineDict.items(), key=lambda item: item[1], reverse=True)
    for _, value in sortedTangerine:
        k -= value
        answer += 1
        if k <= 0:
            break
    return answer
