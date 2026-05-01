class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        int ans = solve(coins, amount);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    private int solve(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (dp[amount] != -2) return dp[amount];
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = solve(coins, amount - coin);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }
        return dp[amount] = minCoins;
    }
}