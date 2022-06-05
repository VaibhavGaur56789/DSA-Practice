class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len=nums.length;
        int[][] dp = new int[len][2];
        if(len == 1) return 1;
        dp[0][0] = 1;  
        dp[0][1] = 1; 
        for(int i = 1; i < len; i++) {
            dp[i][0] = dp[i-1][0];
            dp[i][1] = dp[i-1][1];
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }else if(nums[i] < nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }
        
        return Math.max(dp[len-1][0], dp[len-1][1]);
    }
            
}