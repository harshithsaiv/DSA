class Solution {

    static class DSU {
        int[] p, r;
        DSU(int n){ p=new int[n+1]; r=new int[n+1];
            for(int i=1;i<=n;i++) p[i]=i; }
        int find(int x){ return p[x]==x? x : (p[x]=find(p[x])); }
        void union(int a,int b){
            a=find(a); b=find(b); if(a==b) return;
            if(r[a]<r[b]) {int t=a; a=b; b=t;}
            p[b]=a; if(r[a]==r[b]) r[a]++;
        }
    }



    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);
        for (int[] e: connections) dsu.union(e[0], e[1]);

        // map root -> index 0..m-1
        Map<Integer,Integer> rootIdx = new HashMap<>();
        int idx = 0;
        for (int i=1;i<=c;i++) {
            int r = dsu.find(i);
            if (!rootIdx.containsKey(r)) rootIdx.put(r, idx++);
        }

        @SuppressWarnings("unchecked")
        TreeSet<Integer>[] compSets = new TreeSet[idx];
        for (int i=0;i<idx;i++) compSets[i] = new TreeSet<>();

        int[] compOf = new int[c+1];
        for (int i=1;i<=c;i++) {
            int ci = rootIdx.get(dsu.find(i));
            compOf[i] = ci;
            compSets[ci].add(i); // initially all online
        }

        boolean[] online = new boolean[c+1];
        Arrays.fill(online, true);

        List<Integer> out = new ArrayList<>();
        for (int[] q: queries) {
            int type = q[0], x = q[1];
            if (type == 1) {
                if (online[x]) {
                    out.add(x);
                } else {
                    TreeSet<Integer> set = compSets[compOf[x]];
                    out.add(set.isEmpty() ? -1 : set.first());
                }
            } else { // type == 2
                if (online[x]) {
                    online[x] = false;
                    compSets[compOf[x]].remove(x);
                }
            }
        }
        return out.stream().mapToInt(Integer::intValue).toArray();
}
    }
