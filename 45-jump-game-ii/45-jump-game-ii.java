class Solution {
    public int jump(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        dp[nums.length-1] = 0; //As No jump from last spot
        
        for(int i=nums.length-2; i>=0; i--) {
            int steps = nums[i];
            
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=steps && i+j<nums.length; j++) { //Min 1 jump to atleast number of steps, i+j should not cross the size
                if(dp[i+j] != null && dp[i+j] < min) {
                    min = dp[i+j];
                }
            }
            if(min != Integer.MAX_VALUE) {
                dp[i] = min+1;
            }
        }
        return dp[0];
    }
}