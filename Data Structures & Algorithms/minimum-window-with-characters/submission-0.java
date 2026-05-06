class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        // Frequency map of t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }
        int uniqueCharCount = fmap.size();
        int sI = -1;
        int ws = 0;
        int we = 0;

        int N = s.length();
        int minLen = Integer.MAX_VALUE;
        while (we < N) {
            // acquire
            char ch = s.charAt(we);

            if (fmap.containsKey(ch)) {

                fmap.put(ch, fmap.get(ch) - 1);

                if (fmap.get(ch) == 0) {
                    uniqueCharCount--;
                }
            }
            // release
            while (uniqueCharCount == 0) {
                int len = we - ws + 1;

                if (len < minLen) {
                    minLen = len;
                    sI = ws;
                }
                ch = s.charAt(ws);
                if (fmap.containsKey(ch)) {
                    fmap.put(ch, fmap.get(ch) + 1);
                    if (fmap.get(ch) > 0) {
                        uniqueCharCount++;
                    }
                }
                ws++;
            }
            we++;
        }
        if (sI == -1) {
            return "";
        }
        return s.substring(sI, sI + minLen);
    }
}