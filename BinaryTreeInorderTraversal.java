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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> a = new ArrayList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        a.add(root);
        while (!a.isEmpty()) {
            TreeNode current = a.get(0);
            if (current.right != null)
                a.add(0, current.right);
            
            if (current.left != null)
                a.add(0, new TreeNode(current.val));
            else result.add(current.val);
            
            if (current.left != null)
                a.add(0, current.left);
            
            a.remove(current);
        }
        return result;
    }
}
