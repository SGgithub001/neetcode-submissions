class Solution {
    public int climbStairs(int n) {
       int arr[] = new int[n+1];
       return solve(n,arr);
    }
    public int solve(int n, int[] arr){
        if(n <= 1) return 1;
        if(arr[n] > 0) return arr[n];
        int op1 = solve(n-1,arr);
        int op2 = solve(n-2,arr);
        arr[n] = op1 + op2;
        return op1+op2;
    }
}
