import java.util.*;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int p : piles) max = Math.max(max, p);

        int low = 1, high = max, ans = max;
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            if (canFinish(piles, h, mid)) {
                ans = mid;           
                high = mid - 1;
            } else {
                low = mid + 1;       
            }
        }
        return ans;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k; 
            if (hours > h) return false; 
        }
        return hours <= h;
    }
}
