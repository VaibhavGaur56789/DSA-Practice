//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[][] dp = new int[n][n+1];
        // for(int[] row: dp) {
        //     Arrays.fill(dp, -1);
        // }
        
        for(int i=0; i<=n; i++) {
            dp[0][i] = i*price[0];
        }
        
        for(int ind=1; ind<n; ind++) {
            for(int length=0; length <= n; length++) {
                int notTake = 0 + dp[ind-1][length];
                int take = Integer.MIN_VALUE;
                int rodLength = ind+1;
                if(rodLength <= length) {
                    take = price[ind] + dp[ind][length-rodLength];
                }
                dp[ind][length] = Math.max(take, notTake);
            }
        }
        return dp[n-1][n];
    }
}