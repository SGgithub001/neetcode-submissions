/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int ans = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }
    public int inorder(TreeNode node, int k) {
        if(node == null) return 0;
        if(node.left != null){
            inorder(node.left,k);
        }
        count++;
        if(count == k){
            ans = node.val;
        }
        if(node.right != null){
            inorder(node.right,k);
        }
        return ans;
    }
}
