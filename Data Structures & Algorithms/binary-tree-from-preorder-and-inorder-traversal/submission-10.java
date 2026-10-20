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
    int pre_idx;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre_idx = 0;
        inorderMap = new HashMap<>();

        for(int i = 0;i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int l, int r) {
        if(l > r) return null;

        TreeNode root = new TreeNode(preorder[pre_idx++]);
        int mid = inorderMap.get(root.val);
        root.left = buildTree(preorder, l, mid - 1);
        root.right = buildTree(preorder, mid + 1, r);
        return root;
    }
}
