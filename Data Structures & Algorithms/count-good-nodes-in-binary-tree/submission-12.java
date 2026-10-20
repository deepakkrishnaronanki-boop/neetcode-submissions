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
    private int noOfGoodNodes;
    public int goodNodes(TreeNode root) {
        noOfGoodNodes = 0;
        dfs(root, -101);
        return noOfGoodNodes;
    }

    private void dfs(TreeNode root, int val) {
        if(root == null) return;

        if(root.val >= val) {
            noOfGoodNodes++;
            val = root.val;
        }
        
        dfs(root.left, val);
        dfs(root.right, val);
    }
}
