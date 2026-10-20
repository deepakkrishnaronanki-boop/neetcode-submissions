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
    private int size;
    public int kthSmallest(TreeNode root, int k) {
        size = k;
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(list.size()-1);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null) return;

        dfs(root.left, list);
        if(list.size() == size ) return;
        list.add(root.val);
        dfs(root.right, list);
    }
}
