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
    public int[] helper(TreeNode root){
        if(root == null) return new int[2];   
        int[] left = helper(root.left);   // arr[0] = sum, arr[1] = count
        int[] right = helper(root.right);
        if((left[0]+right[0]+root.val)/(1+left[1]+right[1]) == root.val) ans++;
        return new int[]{left[0]+right[0]+root.val, 1+left[1]+right[1]};
    }
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }
}