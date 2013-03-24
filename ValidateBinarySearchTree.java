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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean check(TreeNode root, int minimum, int maximum) {
        if (root == null) return true;
        if (root.val < minimum || root.val > maximum) return false;
        return (check(root.left, minimum, root.val-1)
            && check(root.right, root.val+1, maximum));
    }
}
