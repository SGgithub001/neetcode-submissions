class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // Agar sirf ek house hai
        if (n == 1)
            return nums[0];
        // DP arrays for memoization
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        // Case 1:
        // First house include kar sakte hain
        // Last house exclude hoga
        int case1 = solve(nums, 0, n - 2, dp1);
        // Case 2:
        // First house exclude
        // Last house include ho sakta hai
        int case2 = solve(nums, 1, n - 1, dp2);
        // Dono cases me maximum answer
        return Math.max(case1, case2);
    }
    public int solve(int[] nums, int idx, int end, int[] dp) {
        // Boundary cross ho gayi
        if (idx > end)
            return 0;
        // Agar already calculate ho chuka hai
        if (dp[idx] != -1)
            return dp[idx];
        // Current house loot karo
        // Next adjacent house skip hoga
        int steal = nums[idx] + solve(nums, idx + 2, end, dp);
        // Current house skip karo
        int skip = solve(nums, idx + 1, end, dp);
        // Maximum profit store karo
        dp[idx] = Math.max(steal, skip);
        return dp[idx];
    }
}