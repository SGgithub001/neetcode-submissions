class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> list = new ArrayList<>();
        int rs = 0, re = mat.length - 1;
        int cs = 0, ce = mat[0].length - 1;
        while(rs <= re && cs <= ce){
            for(int col = cs; col <= ce; col++){
                list.add(mat[rs][col]);
            }
            rs++;
            for(int row = rs; row <= re; row++){
                list.add(mat[row][ce]);
            }
            ce--;
            if(rs <= re){
                for(int col = ce; col >= cs; col--){
                    list.add(mat[re][col]);
                }
                re--;
            }
            if (cs <= ce) {
                for (int row = re; row >= rs; row--) {
                    list.add(mat[row][cs]);
                }
                cs++;
            }
        }
        return list;
    }
}
