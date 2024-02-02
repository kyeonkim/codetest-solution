def solution(citations):
    answer = 0
    citations = sorted(citations, reverse=True)
    result = []
    for i in range(len(citations)):
        result.append(min(citations[i], i + 1))
    answer = max(result)
    return answer