// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
        // Your Code goes here
      //makinng adjacency list
        ArrayList<Integer>[] adjacencyList = new ArrayList[N];
        for(int i=0; i<N; i++) 
            adjacencyList[i] = new ArrayList();
        
        for(int[] pre: prerequisites) 
            adjacencyList[pre[0]].add(pre[1]);
        
        
        int[] visited = new int[N];
        for(int i=0; i<N; i++) 
            if(visited[i] == 0 && !dfs(adjacencyList, visited, i))
                return false;
            //return false;
        
        return true;
    }
    
    private boolean dfs(ArrayList<Integer>[] adjacencyList, int[] visited, int v) {
        if(visited[v] == 1) //being visited
            return false; //there is a back edge(deadlock)
        if(visited[v] == 2)
            return true;
        visited[v] = 1;
        for(int adj: adjacencyList[v])  //iterate into neighbors
            if(!dfs(adjacencyList, visited, adj))
                return false;
            visited[v] = 2;
        
        return true;
        
    }
    
}