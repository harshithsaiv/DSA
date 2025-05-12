class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int maxDuration = events[0][1];
        int resKey = events[0][0];

        for (int i = 1; i < events.length; i++) {
            int duration = events[i][1] - events[i - 1][1];
            int key = events[i][0];

            if (duration > maxDuration || (duration == maxDuration && key < resKey)) {
                maxDuration = duration;
                resKey = key;
            }
        }

        return resKey;
    }
}