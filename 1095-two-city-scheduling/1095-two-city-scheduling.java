class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int totalCost = 0;
        int[] diff = new int[costs.length];

        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            totalCost += a;          
            diff[i] = b - a;    
        }
        Arrays.sort(diff);

        for (int i = 0; i < n; i++) {
            totalCost += diff[i];
        }

        return totalCost;
    }
}
