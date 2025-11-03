class Solution {
    public int minCost(String colors, int[] neededTime) {
        int total = 0;
        int maxInGroup = neededTime[0];

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                total += Math.min(neededTime[i], maxInGroup);
                maxInGroup = Math.max(maxInGroup, neededTime[i]);
            } else {
                maxInGroup = neededTime[i];
            }
        }

        return total;
    }
}
