class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length) {
            return -1;
        }
        
        int left = 1, right = 1, mid;
        for(int i: bloomDay) {
            left = Math.min(left, i);
            right = Math.max(right, i);
        }
        while(left < right) {
            mid = left + (right - left)/2;
            if(canMake(mid, m, k, bloomDay)) {
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return left;
    }
    
    private boolean canMake(int val, int bouqet, int flowers, int[] bloom) {
        int count = 0;
        for(int i: bloom) {
            if(i <= val) {
                count++;
                if(count == flowers) {
                    bouqet--;
                    count = 0;
                    if(bouqet == 0)
                        return true;
                }
            }
            else 
                count = 0;
        }
        return false;
    }
}