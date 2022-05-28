class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[101][101];
        int n = matrix.length;
        int m = matrix.length;
        
        for(int i=0; i<m; i++) 
            dp[0][i] = matrix[0][i];
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                int mini = 10005;
                int up = matrix[i][j] + dp[i-1][j];
                
                int leftD = matrix[i][j];
                if(j-1 >= 0)
                    leftD += dp[i-1][j-1];
                else leftD += mini;
                
                int rightD = matrix[i][j];
                if(j+1 < m)
                    rightD += dp[i-1][j+1];
                else rightD += mini;
                
                dp[i][j] = Math.min(up, Math.min(leftD, rightD));
            }
        }
        
        int ans = dp[n-1][0];
        for(int i=0; i<m; i++)
            ans = Math.min(ans, dp[n-1][i]);
        return ans;
    }
}