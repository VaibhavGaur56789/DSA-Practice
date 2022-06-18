class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        //Using BFS
        
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++) {
            int src = edges[i][0];
            int des = edges[i][1];
            adj.get(src).add(des);
            adj.get(des).add(src);
        }
        
        visited[source] = true;
        q.add(source);
        
        while(!q.isEmpty()) {
            int node = q.poll();
            if(node == destination)
                return true;
            
            for(int nei: adj.get(node)) {
                if(!visited[nei]) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
        return false;
    }
}