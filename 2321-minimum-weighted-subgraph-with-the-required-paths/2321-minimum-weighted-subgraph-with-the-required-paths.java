import java.util.*;

class Solution {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    long[] dijkstra(int n, List<List<Edge>> graph, int start) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{start, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];

            if (d > dist[u]) continue;

            for (Edge e : graph.get(u)) {
                if (dist[e.to] > d + e.weight) {
                    dist[e.to] = d + e.weight;
                    pq.offer(new long[]{e.to, dist[e.to]});
                }
            }
        }

        return dist;
    }

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<Edge>> graph = new ArrayList<>();
        List<List<Edge>> revGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new Edge(v, w));
            revGraph.get(v).add(new Edge(u, w)); // reverse edge for destâm traversal
        }

        long[] fromSrc1 = dijkstra(n, graph, src1);
        long[] fromSrc2 = dijkstra(n, graph, src2);
        long[] toDest = dijkstra(n, revGraph, dest); // reverse Dijkstra

        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (fromSrc1[i] == Long.MAX_VALUE || fromSrc2[i] == Long.MAX_VALUE || toDest[i] == Long.MAX_VALUE)
                continue;

            min = Math.min(min, fromSrc1[i] + fromSrc2[i] + toDest[i]);
        }

        return (min == Long.MAX_VALUE) ? -1 : min;
    }
}
