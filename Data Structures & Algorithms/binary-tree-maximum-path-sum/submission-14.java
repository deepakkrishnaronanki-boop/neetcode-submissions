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
    int max_sum;
    public int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        dfs(root);
        return max_sum;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = dfs(root.left);

        int right = dfs(root.right);

        if(left < 0) left = 0;
        if(right < 0) right = 0;

        max_sum = Math.max(max_sum, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
