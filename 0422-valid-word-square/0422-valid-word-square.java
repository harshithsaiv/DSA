class Solution {
    public boolean validWordSquare(List<String> words) {
        int cols = 0;
        int rows = words.size();
        List<String> newWords = new ArrayList<String>();
        
        for (String word : words) {
            cols = Math.max(cols, word.length());
        }


        if (cols != words.get(0).length() ||rows != cols) {
            return false;
        }

        for (int col = 0; col < cols; ++col) {
            StringBuilder newWord = new StringBuilder();

            for (int row = 0; row < rows; ++row) {
                
                if (col < words.get(row).length()) {
                    newWord.append(words.get(row).charAt(col));
                }
            }

            newWords.add(newWord.toString());
        }

        for (int index = 0; index < rows; ++index) {
            if (words.get(index).compareTo(newWords.get(index)) != 0) {
                return false;
            }
        }
        return true;
    }
}