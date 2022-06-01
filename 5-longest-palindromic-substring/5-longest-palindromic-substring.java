class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //int len = 0;
        int subStrLen = 0;
        int maxPalSubStrLen = 0;
        int palStartInd = 0, palEndInd = 0;
        
        for(int g=0; g<n; g++) {
            for(int i=0, j=g; j<n; i++,j++) {
                if(g == 0) {
                    dp[i][j] = true;
                }
                else if(g == 1) {
                    if(s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                    else 
                        dp[i][j] = false;
                }
                else {
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
                subStrLen = g + 1;
                if(dp[i][j] && subStrLen>maxPalSubStrLen) {
                    //len = g+1;  If length of longest substring would have been asked
                    //subStrLen = g + 1;
                    maxPalSubStrLen = subStrLen;
                    palStartInd = i;
                    palEndInd = j;
                }
            }
        }
        return s.substring(palStartInd,palEndInd+1);
        }
    }

