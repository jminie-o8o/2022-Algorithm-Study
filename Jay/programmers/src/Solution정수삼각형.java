import java.util.*;

import static java.lang.Math.*;

class Solution정수삼각형 {
    public int solution(int[][] triangle) {

        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < i+1; j++) {

                if (j == 0) dp[i][j] = triangle[i][j] + dp[i - 1][j];
                else if(j == triangle[i].length-1) dp[i][j] = triangle[i][j] + dp[i - 1][j-1];
                else {
                    dp[i][j] = triangle[i][j] + max(dp[i - 1][j - 1], dp[i - 1][j]);}
            }
        }
        int maxValue = 0;
        for (int i = 0; i < dp.length; i++) {
            maxValue = max(maxValue, dp[dp.length - 1][i]);
        }

        return maxValue;
    }
}
