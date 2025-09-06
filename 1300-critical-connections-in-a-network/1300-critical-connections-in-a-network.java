class Solution {
    private List<List<Integer>> bridges;
    private List<Integer>[] graph;
    private int[] tin , low;
    private int time;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
       bridges = new ArrayList<>();
       graph = new ArrayList[n];

       for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
       }

        // Building the Adjacency List
       for(List<Integer> conn: connections){
            int u= conn.get(0);
            int v = conn.get(1);
            graph[u].add(v);
            graph[v].add(u);
       }

       tin = new int[n];
       low = new int[n];
       Arrays.fill(tin,-1);
       time=0;
       dfs(0,-1);
       return bridges;
    }

    private void dfs(int u, int parent){
        tin[u]=low[u]=time++;

        for(int v : graph[u]){
            if(v==parent) continue;
            if(tin[v]==-1){
                // not visited
                dfs(v,u);
                low[u] = Math.min(low[u],low[v]);
                if(low[v] > tin[u]){
                    bridges.add(Arrays.asList(u,v));
                }
            }

            else{
                low[u] = Math.min(low[u],tin[v]);
            }
        }
    }
}