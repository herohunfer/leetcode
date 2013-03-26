/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Recursively
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return checkSymmetric(root, root);
    }
    public boolean checkSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return checkSymmetric(root1.left, root2.right)&&checkSymmetric(root1.right, root2.left);
    }
}

//Iteratively
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> al1 = new ArrayList<TreeNode>(), al2 = new ArrayList<TreeNode>();
        al1.add(root);
        al2.add(root);
        while(!al1.isEmpty() || !al2.isEmpty()) {
            if (al1.isEmpty() || al2.isEmpty()) return false;
            TreeNode root1 = al1.remove(0);
            TreeNode root2 = al2.remove(0);
            if (root1 == null && root2 == null) continue;
            if (root1 == null || root2 == null) return false;
            if (root1.val != root2.val) return false;
            al1.add(root1.left); al2.add(root2.right);
            al1.add(root1.right); al2.add(root2.left);
        }
        return true;
    }
} 
