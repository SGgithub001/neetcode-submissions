class Solution {
    public int numIslands(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(arr[i][j] == '1' && visited[i][j] == false){
                    solve(arr,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void solve(char[][] arr,int i, int j, boolean[][] visited){
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == '0' || visited[i][j] == true){
            return;
        }
        visited[i][j] = true;
        solve(arr,i+1,j,visited); 
        solve(arr,i-1,j,visited); 
        solve(arr,i,j+1,visited); 
        solve(arr,i,j-1,visited); 
    }
}
