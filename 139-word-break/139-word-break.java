class Solution {
    
    //Recursive
    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> hs = new HashSet<>(wordDict);
        return wordBreakRecursion(0, n, s, hs);
    }
    
    public boolean wordBreakRecursion(int pos, int n, String s, HashSet<String> hs) {
        if(pos == n)
            return true;
        for(int i=pos+1; i<=n; i++) {
            if(hs.contains(s.substring(pos, i)) && wordBreakRecursion(i, n, s, hs))
                return true;
        }
        return false;
      */  
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] tp = new int[n];
        Arrays.fill(tp, -1);
        HashSet<String> hs = new HashSet<String>(wordDict);
        return helper(0, n, s, hs, tp);
    }
    
    public boolean helper(int pos, int n, String s, HashSet<String> hs, int[] tp){
        if(pos>=n) return true;
        if(tp[pos]!=-1) return tp[pos]==1 ? true : false;
        for(int i=pos+1;i<=n;i++){
            if(hs.contains(s.substring(pos, i)) && helper(i, n, s, hs, tp)){
                tp[pos] = 1;
                return true;
            }
        }
        tp[pos] = 0;
        return false;
        
        /*
        int[] dp = new int[s.length()];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<=i; j++) {
                String w2check = s.substring(j, i+1);
                if(wordDict.contains(w2check)) {
                    if(j > 0) {
                        dp[i] = dp[i] + dp[j-1];
                    }
                    else {
                        dp[i] = dp[i] + 1;
                    }
                }
            }
        }
        return dp[s.length() - 1] > 0;
        */
    }
}