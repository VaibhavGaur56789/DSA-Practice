class Solution {
    //O(T * N) time | O(T) space
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1; i<dp.length; i++) {
            for(int num : nums) {
                if(i-num < 0) continue;
                dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}