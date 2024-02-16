import heapq


def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while scoville[0] < K:
        min1 = heapq.heappop(scoville)
        if not scoville:
            return -1
        min2 = heapq.heappop(scoville)
        mixScoville = min1 + min2 * 2
        heapq.heappush(scoville, mixScoville)
        answer += 1
    return answer
