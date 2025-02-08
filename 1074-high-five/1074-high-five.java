class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer,PriorityQueue<Integer>> hmap = new HashMap<Integer,PriorityQueue<Integer>>();
        for(int i=0;i<items.length;i++){
            int id = items[i][0];
            int score = items[i][1];

            hmap.computeIfAbsent(id, k-> new PriorityQueue<>()).add(score);

            PriorityQueue<Integer> queue = hmap.get(id);
            if(queue.size()>5){
                queue.poll();
            }
        }
        
        int[][] result = new int[hmap.size()][2];
        int index = 0;

        for (int id : hmap.keySet()) {
            PriorityQueue<Integer> queue = hmap.get(id);
            int sum = 0;
            while (!queue.isEmpty()) {
                sum += queue.poll();
            }
            result[index++] = new int[]{id, sum / 5}; // Store student ID and average
        }

        // Step 3: Sort by student ID
        Arrays.sort(result, Comparator.comparingInt(a -> a[0]));

        return result;
    }
}