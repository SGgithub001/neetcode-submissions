class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        trackMe(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    private void trackMe(List<List<Integer>> res,List<Integer> temp,int[] nums,int target,int start){
        if(target < 0) return;
        else if(target == 0) res.add(new ArrayList<>(temp));
        else {
            for(int i = start; i < nums.length; i++){
                temp.add(nums[i]);
                trackMe(res,temp,nums,target-nums[i],i);
                temp.remove(temp.size()-1);
            }
        }
    } 
}