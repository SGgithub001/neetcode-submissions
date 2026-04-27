class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(0, nums, target, new ArrayList<>(), res);
        return res;
    }
    private void solve(int idx, int[] nums, int target, List<Integer> curr, List<List<Integer>> res) {
        // base case
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (idx == nums.length || target < 0) return;
        // pick (same index → reuse allowed)
        if (nums[idx] <= target) {
            curr.add(nums[idx]);
            solve(idx, nums, target - nums[idx], curr, res);
            curr.remove(curr.size() - 1);
        }
        // not pick (move forward)
        solve(idx + 1, nums, target, curr, res);
    }
}