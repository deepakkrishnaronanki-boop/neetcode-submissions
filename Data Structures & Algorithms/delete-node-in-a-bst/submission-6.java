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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return null;

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val){
            root.right = deleteNode(root.right, key);
        } else if(key == root.val){
            if(root.right != null && root.left != null) {
                root = insertNode(root.right, root.left);
            } else if(root.left == null){
                root = root.right;
            } else {
                root = root.left;
            }
            
        }

        return root;
    }

    private TreeNode insertNode(TreeNode root, TreeNode node) {
        if(root == null) return node;

        if(node.val < root.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }

        return root;
    }
}