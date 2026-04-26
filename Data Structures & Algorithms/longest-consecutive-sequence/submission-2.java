class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int maxLen = 0;
        for(int e : set){
            int prevEle = e - 1;
            if(!set.contains(prevEle)){
                int l = 1;
                int nextEle = e + 1;
                while(set.contains(nextEle)){
                    l++;
                    nextEle++;
                }
               maxLen = Math.max(maxLen,l);
            }
        }
        return maxLen;
    }
}
