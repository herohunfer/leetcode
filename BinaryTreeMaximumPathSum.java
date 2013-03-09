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
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeNode turn = copyTree(root);
        sum(turn);
        return maxVal(root, turn);
    }
    public TreeNode copyTree(TreeNode root) {
        if (root == null) return null;
        TreeNode cNode = new TreeNode(root.val);
        if (root.left != null) cNode.left = copyTree(root.left);
        if (root.right != null) cNode.right = copyTree(root.right);
        return cNode;
    }
    
    public int sum(TreeNode root) {
    if (root == null) return 0;
        if (root.left == null && root.right == null) 
            return root.val;
        int lw = 0;
        int rw = 0;
        if (root.left != null) lw = sum(root.left);
        if (root.right != null) rw = sum(root.right);
        if (lw > rw && lw > 0) root.val += lw;
        else if (lw < rw && rw > 0) root.val += rw;
        
        return root.val;
    }
    
    public int maxVal(TreeNode root, TreeNode turn) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) 
            return root.val;
        if (root.left != null) 
            if (turn.left.val > 0) root.val += turn.left.val;
            
        if (root.right != null) 
            if (turn.right.val > 0) root.val += turn.right.val;
        
        int lw = Integer.MIN_VALUE;
        int rw = Integer.MIN_VALUE;
        if (root.left != null) lw = maxVal(root.left, turn.left);
        
        if (root.right != null) rw = maxVal(root.right, turn.right);
        
        if (lw > rw && lw > root.val) return lw;
        else if (lw < rw && rw > root.val) return rw;
        else return root.val;
    }
}
