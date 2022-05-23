class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        
        for(int i=0; i<len; i++) { //More than one graph component maybe
            if(colors[i] == 1 || colors[i] == -1) { //1 --> Blue, -1 --> Red
                continue;
            }
            Queue<Integer> q = new LinkedList<>(); //FirstInFirstOut
            q.add(i);
            colors[i] = 1; //Fill i with blue;
            
            while(!q.isEmpty()) {
                int firstEle = q.poll(); //Take out first element
                for(int next: graph[firstEle]) { //Iterate over adjacent node/ele of firstEle
                    if(colors[next] == 0) {
                        colors[next] = -colors[firstEle]; //Fill opposite color to that of firstEle
                        q.add(next); //Add that ele/node in Queue
                    }
                    if(colors[next] == colors[firstEle]) {
                        return false; //means graph is Non-Bipartite 
                    }
                }
            }
        }
        return true;  //means graph is Bipartite
    }
}