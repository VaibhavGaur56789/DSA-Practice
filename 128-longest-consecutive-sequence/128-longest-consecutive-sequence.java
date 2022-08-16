class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums) {
            hs.add(num);
        }
        
        int longestStreak = 0;
        for(int num: nums) {
            if(!hs.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                while(hs.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}