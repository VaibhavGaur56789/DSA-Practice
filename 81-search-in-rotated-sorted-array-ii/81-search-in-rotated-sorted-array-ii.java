class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target)
                return true;
            
            if(nums[low] < nums[mid]) {
                if(target > nums[mid] || target < nums[low]) {
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
            else if(nums[low] > nums[mid]) {
                if(target < nums[mid] || target > nums[high]) {
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }
            else {
                low++;
            }
            //return false;
        }
        return false;
    }
}