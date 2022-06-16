class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(0, curr, graph, graph.length-1, res);
        return res;
    }
    
    public static void dfs(int source, List<Integer> curr, int[][] graph, int destination, List<List<Integer>> res) {
        if(source == destination) {
            res.add(new ArrayList(curr));
            return;
        }
        
        for(int a: graph[source]) {
            curr.add(a);
            dfs(a, curr, graph, destination, res);
            curr.remove(curr.size() - 1);
        }
    }
}