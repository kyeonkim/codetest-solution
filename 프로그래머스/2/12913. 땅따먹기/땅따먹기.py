def solution(land):
    answer = 0
    arrLen = len(land[0])
    dp = [[0] * arrLen for _ in range(len(land) - 1)]
    for i in range(len(land) - 1):
        for j in range(arrLen):
            for k in range(arrLen):
                if not j == k:
                    dp[i][k] = max(dp[i][k], land[i][j] + land[i + 1][k])
        land[i + 1] = dp[i]
    answer = max(land[-1])
    return answer