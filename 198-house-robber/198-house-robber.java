class Solution {
    /*public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return logicFunc(n, nums, dp);
    }
    
    public static int logicFunc(int n, int[] nums, int[] dp) {
        dp[0] = nums[0];
        
        for(int i=1; i<n; i++) {
            int pick = nums[i];
            if(i > 1)
                pick += dp[i-2];
            int nonPick = 0 + dp[i-1];
            
            dp[i] = Math.max(pick, nonPick);
        }
        return dp[n-1];
    }*/
    
    public int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;
        
        for(int i=1; i<nums.length; i++) {
            int pick = nums[i];
            if(i > 1)
                pick += prev2;
            int notPick = 0 + prev;
            
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}