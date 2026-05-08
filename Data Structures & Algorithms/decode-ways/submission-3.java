class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        // DP array for memoization
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(s, 0, dp);
    }

    public int solve(String s, int idx, int[] dp) {
        // String successfully decode ho gayi
        if (idx == s.length())
            return 1;
        // Agar current character '0' hai
        // toh valid decoding possible nahi
        if (s.charAt(idx) == '0')
            return 0;
        // Agar already calculate ho chuka hai
        if (dp[idx] != -1)
            return dp[idx];
        // Ek digit choose karo
        int oneDigit = solve(s, idx + 1, dp);
        int twoDigit = 0;
        // Do digits possible hain ya nahi check karo
        if (idx + 1 < s.length()) {
            int num = (s.charAt(idx) - '0') * 10
                    + (s.charAt(idx + 1) - '0');
            // Valid range: 10 to 26
            if (num >= 10 && num <= 26) {
                twoDigit = solve(s, idx + 2, dp);
            }
        }
        // Total ways store karo
        dp[idx] = oneDigit + twoDigit;
        return dp[idx];
    }
}