def solution(k, tangerine):
    answer = 0
    tangerineDict = {}
    for t in tangerine:
        if t in tangerineDict:
            tangerineDict[t] += 1 
        else:
            tangerineDict[t] = 1
    sortedTangerine = sorted(tangerineDict.items(), key=lambda item: item[1], reverse=True)
    for value in sortedTangerine:
        k -= value[1]
        answer += 1
        if k <= 0:
            return answer
    return answer