class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans = bfs(0, isConnected);
        return ans;
    }
    
    public static int bfs(int ans, int[][] adjacencyMatrix) {
        int v = adjacencyMatrix.length;
        boolean[] vis = new boolean[v];
        
        for(int i=0; i<v; i++) {
            if(vis[i] == false) {
                ans++;
                bfsHelper(adjacencyMatrix, i, vis);
            } 
        }
        return ans;
    }
    
    public static void bfsHelper(int[][] adjacencyMatrix, int node, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        int v = adjacencyMatrix.length;
        
        while(!q.isEmpty()) {
            int front = q.poll();
            for(int i=0; i<v; i++) {
                if(adjacencyMatrix[front][i] == 1 && vis[i] == false) {
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
    }
}