import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // Build red and blue adjacency lists
        List<Integer>[] redGraph = new ArrayList[n];
        List<Integer>[] blueGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }
        for (int[] e : redEdges) redGraph[e[0]].add(e[1]);
        for (int[] e : blueEdges) blueGraph[e[0]].add(e[1]);

        // dist[i][0] = shortest dist to node i ending with RED
        // dist[i][1] = shortest dist to node i ending with BLUE
        int[][] dist = new int[n][2];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[0][0] = dist[0][1] = 0; // Starting point

        // BFS Queue: [node, color]
        // color: 0 = red, 1 = blue
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // Start with red
        queue.offer(new int[]{0, 1}); // Start with blue

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int color = curr[1]; // 0 = red last, 1 = blue last

            // Next color to take must alternate
            List<Integer>[] nextGraph = (color == 0) ? blueGraph : redGraph;
            int nextColor = 1 - color;

            for (int neighbor : nextGraph[node]) {
                if (dist[neighbor][nextColor] == Integer.MAX_VALUE) {
                    dist[neighbor][nextColor] = dist[node][color] + 1;
                    queue.offer(new int[]{neighbor, nextColor});
                }
            }
        }

        // Build answer array
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int min = Math.min(dist[i][0], dist[i][1]);
            answer[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }

        return answer;
    }
}
