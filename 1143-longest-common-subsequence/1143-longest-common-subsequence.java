class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}

/*
class Solution {
   public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // 定义：s1[0..i-1] 和 s2[0..j-1] 的 lcs 长度为 dp[i][j]
        // 目标：s1[0..m-1] 和 s2[0..n-1] 的 lcs 长度，即 dp[m][n]
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int j = 1; j <= m; j++) {
            dp[j][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

*/