//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans[] = obj.replaceWithRank(a,n);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
     // code here
        int[] dupArray = new int[N];
        for(int i=0; i<N; i++) {
            dupArray[i] = arr[i];
        }
        Arrays.sort(dupArray);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: dupArray) {
            if(!map.containsKey(i))
                map.put(i, map.size() + 1);
        }
        for(int i=0; i<N; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
     