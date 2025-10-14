class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int friend : friends[i]) {
                graph.get(i).add(friend);
            }
        }

        // BFS to find friends at given level
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(id);
        seen.add(id);

        int currLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currLevel == level) break;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (seen.add(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
            currLevel++;
        }

        // Count frequency of videos watched by friends at the required level
        Map<String, Integer> freq = new HashMap<>();
        while (!queue.isEmpty()) {
            int friendId = queue.poll();
            for (String video : watchedVideos.get(friendId)) {
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        }

        List<String> result = new ArrayList<>(freq.keySet());
        result.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(a) - freq.get(b);  
            }
            return a.compareTo(b);  
        });

        return result;
    }
}
