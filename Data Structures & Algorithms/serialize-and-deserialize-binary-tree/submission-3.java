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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return String.join(",", res);
    }

    private void dfs(TreeNode root, List<String> res) {
        if(root == null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(root.val));
        dfs(root.left, res);
        dfs(root.right, res);
    }
    
    int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");

        return dfs(split);
    }

    private TreeNode dfs(String[] splits) {
        if(splits[index].equals("N")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(splits[index++]));

        root.left = dfs(splits);
        root.right = dfs(splits);
        return root;
    }
}
