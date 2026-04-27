class Solution {
    public int numDecodings(String s) {
        int arr[] = new int[s.length() + 1];
        return solve(s,0,arr);
    }
    public int solve(String s, int idx, int[] arr){
        if(idx == s.length()) return 1;
        if(s.charAt(idx) == '0') return 0;
        if(idx == s.length() - 1) return 1;
        if(arr[idx] > 0){
            return arr[idx];
        }
        int way1 = solve(s,idx+1,arr);
        int way2 = 0;
        if(Integer.parseInt(s.substring(idx,idx+2)) <= 26){
            way2 = solve(s,idx+2,arr);
        }
        arr[idx] = way1+way2;
        return arr[idx];
    }
}
