class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //makinng adjacency list
        ArrayList<Integer>[] adjacencyList = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) 
            adjacencyList[i] = new ArrayList();
        
        for(int[] pre: prerequisites) 
            adjacencyList[pre[0]].add(pre[1]);
        
        
        int[] visited = new int[numCourses];
        for(int i=0; i<numCourses; i++) 
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