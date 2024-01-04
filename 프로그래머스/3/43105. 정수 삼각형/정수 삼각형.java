import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];

        for (int i = 0; i < triangle.length; i++) {
            dp[i] = Arrays.copyOf(triangle[i], triangle[i].length);
        }
        for (int i = 0; i < triangle.length - 1; i++){
            for (int j = 0; j < triangle[i].length; j++){
                if (dp[i + 1][j] < dp[i][j] + triangle[i + 1][j])
                    dp[i + 1][j] = dp[i][j] + triangle[i + 1][j];
                if (dp[i + 1][j + 1] < dp[i][j] + triangle[i + 1][j + 1])
                    dp[i + 1][j + 1] = dp[i][j] + triangle[i + 1][j + 1];
            }
        }
        answer = Arrays.stream(dp[dp.length - 1]).max().orElseThrow();
        return answer;
    }
}