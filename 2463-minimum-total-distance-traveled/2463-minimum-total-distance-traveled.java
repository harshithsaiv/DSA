class Solution {

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
       
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        
        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                factoryPositions.add(f[0]);
            }
        }

        int robotCount = robot.size();
        int factoryCount = factoryPositions.size();

        
        long[][] dp = new long[robotCount + 1][factoryCount + 1];

        
        for (int i = 0; i < robotCount; i++) {
            dp[i][factoryCount] = (long) 1e12; 
        }

        
        for (int i = robotCount - 1; i >= 0; i--) {
            for (int j = factoryCount - 1; j >= 0; j--) {
                // Option 1: Assign current robot to current factory
                long assign =
                    Math.abs(robot.get(i) - factoryPositions.get(j)) +
                    dp[i + 1][j + 1];

                // Option 2: Skip current factory for the current robot
                long skip = dp[i][j + 1];

                // Take the minimum option
                dp[i][j] = Math.min(assign, skip);
            }
        }

        // Minimum distance starting from first robot and factory
        return dp[0][0];
    }
}