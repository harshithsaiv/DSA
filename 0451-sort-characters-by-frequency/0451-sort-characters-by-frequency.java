import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        LinkedHashMap<Character, Integer> alphabets = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            alphabets.put(ch, 0);
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            alphabets.put(ch, 0);
        }
        for(char ch = '0'; ch<='9';ch++)
        {
            alphabets.put(ch,0);
        }

        int max = 0;
        for (char c : s.toCharArray()) {
            if (alphabets.containsKey(c)) {
                int count = alphabets.get(c);
                alphabets.put(c, count + 1);
                max = Math.max(max, count + 1);
            }
        }

        for (int j = max; j >= 1; j--) {
            for (Map.Entry<Character, Integer> entry : alphabets.entrySet()) {
                if (entry.getValue() == j) {
                    for (int i = 0; i < j; i++) {
                        result.append(entry.getKey());
                    }
                }
            }
        }

        return result.toString();
    }
}
