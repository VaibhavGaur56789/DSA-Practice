class Solution {
    //int dp[101][101];
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[101][101];
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i=0; i<m; i++) {
            dp[0][i] = matrix[0][i]; //Fill first row 
        }
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                int mini = 10005;
                if(i-1 >= 0)
                    mini = Math.min(mini, dp[i-1][j]);
                if(i-1 >= 0 && j-1 >= 0)
                    mini = Math.min(mini, dp[i-1][j-1]);
                if(i-1 >= 0 && j+1 < m)
                    mini = Math.min(mini, dp[i-1][j+1]);
                
                dp[i][j] = mini + matrix[i][j];
            }
        }
        int ans = dp[n-1][0];
        for(int i=1; i<m; i++)
            ans = Math.min(ans, dp[n-1][i]);
        return ans;
    }
}