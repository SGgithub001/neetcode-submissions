class Solution {
    public int longestConsecutive(int[] nums) {
      int ans = 0;
      Set<Integer> set = new HashSet<>();
      for(int n : nums){
        set.add(n);
      }
      for(int i : nums){
        int max = 0;
        int curr = i;
        while(set.contains(curr)){
            max++;
            curr++;
        }
        ans = Math.max(ans,max);
      }
      return ans;
    }
}
