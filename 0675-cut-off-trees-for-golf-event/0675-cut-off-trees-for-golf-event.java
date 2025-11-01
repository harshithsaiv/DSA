class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();

        List<int[]> trees = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val = forest.get(i).get(j);
                if(val>1){
                    trees.add(new int[]{i,j,val});
                }
            }
        }

        // Sort the list according to the value -> using comparator 
        trees.sort(Comparator.comparingInt(a -> a[2]));

        int min =0;
        int sr=0,sc=0;

        
        for(int []tree : trees){
            int tr = tree[0], tc=tree[1];
            int dist = bfs(forest,sr,sc,tr,tc);
            if(dist==-1) return -1;
            min+=dist;
            sr=tr;
            sc=tc;
        }

        return min;
    }

    public int bfs(List<List<Integer>> forest , int sr , int sc , int tr , int tc){
        int m = forest.size();
        int n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];

        if(sr==tr && sc==tc) return 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        int [][]dir ={{1,0},{0,1},{-1,0},{0,-1}};
        int steps=0;

        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (visited[nr][nc]) continue;
                    if (forest.get(nr).get(nc) == 0) continue;
                    if (nr == tr && nc == tc) return steps;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return -1;    
    }
}