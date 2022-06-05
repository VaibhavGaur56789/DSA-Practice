class Solution {
    
    //Memoization
    
   /* public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        
        return changeUtil(coins, n-1, amount, dp);
    }
    
    public int changeUtil(int[] coins, int ind, int amount, int[][] dp) {
        if(ind == 0) {
            if(amount % coins[0] == 0)
                return 1;
            else 
                return 0;
        }
        
        if(dp[ind][amount] != -1)
            return dp[ind][amount];
        
        int notTaken = changeUtil(coins, ind-1, amount, dp);
        int taken = 0;
        if(coins[ind] <= amount) {
            taken = changeUtil(coins, ind, amount - coins[ind], dp);
        }
        
        return dp[ind][amount] = taken + notTaken; 
    }
}*/

    //Tabulation
    
    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int i=0; i<=amount; i++) {
            if(i % coins[0] == 0)
                dp[0][i] = 1;
        }
        
        for(int ind = 1; ind < n; ind++) {
            for(int target = 0; target <= amount; target++) {
                int notTaken = dp[ind-1][target];
                int taken = 0;
                if(coins[ind] <= target) {
                    taken = dp[ind][target - coins[ind]];
                }
                dp[ind][target] = taken + notTaken;
            }
        }
        return dp[n-1][amount];
    }
}
