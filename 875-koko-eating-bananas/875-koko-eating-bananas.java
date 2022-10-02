class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }
        
        int low = 0, high = max;
        int speed = Integer.MAX_VALUE;
        while(low <= high) {
            int sp = low + (high-low)/2;
            if(eatingIsPossible(piles, h, sp)) {
                speed = sp;
                high = sp-1;
            }
            else {
                low = sp+1;
            }
            
        }
        return speed;
    }
    
    public boolean eatingIsPossible(int[] piles, int h, int sp) {
        int time = 0;
        for(int i=0; i<piles.length; i++) {
            time = time + (int)Math.ceil(piles[i] * 1.0/sp);
        }
        return time <= h;
    }
}