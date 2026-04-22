class Solution {
    public int rob(int[] nums) {
        int pre1 = 0;
        int pre2 = 0;
        for(int i : nums){
            int temp = pre1;
            pre1 = Math.max(pre1,pre2+i);
            pre2 = temp;
        }
        return pre1;
    }
}
