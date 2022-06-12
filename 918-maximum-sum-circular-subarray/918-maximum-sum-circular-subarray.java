class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int x = Kadanes(nums);
        int y=0;
        for(int i=0; i<nums.length; i++) {
            y += nums[i];
            nums[i] *= -1;
        }
        int z = Kadanes(nums);
        if(y+z == 0)
            return x;
        return Math.max(x, y+z);
    }
    
    private int Kadanes(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum > maxSum)
                maxSum = sum;
            if(sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}