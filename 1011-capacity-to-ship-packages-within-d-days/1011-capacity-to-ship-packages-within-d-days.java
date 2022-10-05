class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 1, hi = 0;
        for(int weight : weights){
            lo = Math.max(lo, weight);
            hi += weight;
        }
        
        int ans = hi;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(canShip(weights, days, mid)){
                ans = Math.min(ans, mid);
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        
        return ans;
    }
    
    boolean canShip(int[] weights, int days, int mid){
        int nDays = 1;
        int sum = 0;
        for(int weight : weights){
            sum += weight;
            if(sum > mid){
                sum = weight;
                nDays++;
            }
            if(nDays > days)
                return false;
        }
        return true;
    }
}