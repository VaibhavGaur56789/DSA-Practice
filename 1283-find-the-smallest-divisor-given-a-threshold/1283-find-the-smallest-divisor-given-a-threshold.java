class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 1;
        for(int i: nums) {
            //low = Math.min(low, i);
            high = Math.max(high, i);
        }
        
        int minMid = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if((divideSum(mid, nums, threshold))) {
                minMid = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return minMid;
    }
    
    public static boolean divideSum(int mid, int[] nums, int threshold) {
        int sum = 0;
        for(int i: nums) {
            sum += (int)Math.ceil(i * 1.0/mid);
        }
        return sum <= threshold;
    }
}