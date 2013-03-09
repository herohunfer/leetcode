/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return;
        ArrayList<TreeNode> a = new ArrayList<TreeNode>();
        a.add(root);
        while (!a.isEmpty()) {
            TreeNode current = a.get(0);
            if (current.right != null) a.add(1, current.right);
            if (current.left != null) a.add(1, current.left);
            current.left = null;
            if (a.size() > 1) {
                current.right = a.get(1);
            }
            else current.right = null;
            a.remove(0);
        }
    }
}
