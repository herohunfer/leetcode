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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (isBalancedWithN(root) > -1) return true;
        else return false;
    }
    public int isBalancedWithN(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int lw, rw;
        if (root.left == null) {
            rw = isBalancedWithN(root.right);
            if (rw > 1 || rw == -1) return -1;
            else return rw+1;
        }
        if (root.right == null) {
            lw = isBalancedWithN(root.left);
            if (lw > 1 || lw == -1) return -1;
            else return lw+1;
        }
        lw = isBalancedWithN(root.left);
        rw = isBalancedWithN(root.right);
        if (Math.abs(lw-rw) > 1 || lw == -1 || rw == -1) return -1;
        if (lw > rw) return lw+1;
        else return rw+1;
    }
}
