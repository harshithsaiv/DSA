class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int left = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);

            while (hmap.get(ch) > 1) {
                char leftChar = s.charAt(left);
                hmap.put(leftChar, hmap.get(leftChar) - 1);
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}