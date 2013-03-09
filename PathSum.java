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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return false;
        
        return path(root, sum);
        
    }
    public boolean path(TreeNode root, int sum) {
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        if (root.left != null) {
            if (path(root.left, sum-root.val)) return true;
        }
        if (root.right != null) {
            if (path(root.right, sum-root.val)) return true;
        }
        return false;
    }
}
