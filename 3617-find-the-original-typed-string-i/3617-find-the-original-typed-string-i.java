class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        if (n == 0) return 0;       // (if empty is allowed; otherwise n>=1)
        
        int result = 1;             // noâerror case
        int runLen = 1;
        
        // scan runs
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                runLen++;
            } else {
                // for each run of length >1, add (runLen-1) possibilities
                if (runLen > 1) result += (runLen - 1);
                runLen = 1;
            }
        }
        // last run
        if (runLen > 1) result += (runLen - 1);
        
        return result;
    }
}