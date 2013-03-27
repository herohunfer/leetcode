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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sum(root, 0);
    }
    public int sum(TreeNode root, int pSum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return (pSum+root.val);
        int left = sum(root.left, (pSum+root.val)*10);
        int right = sum(root.right, (pSum+root.val)*10);
        return (left+right);
        
    }
}
