class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums, 0, dp);
    }
    public int rob(int[] nums, int idx, int[] dp) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx] != -1) return dp[idx];
        int steal = nums[idx] + rob(nums, idx + 2, dp);
        int skip = rob(nums, idx + 1, dp);
        return dp[idx] = Math.max(steal, skip);
    }
}