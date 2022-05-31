class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        
        return minPathSumMemoize(n-1, m-1, grid, dp);
    }
    
    public int minPathSumMemoize(int i, int j, int[][] grid, int[][] dp) {
        if(i == 0 && j == 0) {
            return grid[0][0];
        }
        if(i < 0 || j < 0) {
            return (int)Math.pow(10,9); // Integer.MAX_VALUE;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int up = grid[i][j] + minPathSumMemoize(i-1, j, grid, dp);
        int left = grid[i][j] + minPathSumMemoize(i, j-1, grid, dp);
        
        return dp[i][j] = Math.min(up, left);
    }
}