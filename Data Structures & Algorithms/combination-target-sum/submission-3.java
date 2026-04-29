class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, target, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int start, int[] nums, int target,List<Integer> curr, List<List<Integer>> res) {
        // base case
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // skip if number is too big
            if (nums[i] > target) continue;
            // choose
            curr.add(nums[i]);
            // explore (reuse allowed → i, not i+1)
            backtrack(i, nums, target - nums[i], curr, res);
            // undo (backtrack)
            curr.remove(curr.size() - 1);
        }
    }
}