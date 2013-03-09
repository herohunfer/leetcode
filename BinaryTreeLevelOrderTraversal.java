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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        ArrayList<TreeNode> a = new ArrayList<TreeNode>();
        ArrayList<TreeNode> b = new ArrayList<TreeNode>();
        a.add(root);
        
        while (!a.isEmpty()) {
            ArrayList<Integer> r = new ArrayList<Integer>();
            for (TreeNode current: a) {
                r.add(current.val);
                if (current.left != null)
                    b.add(current.left);
                if (current.right != null)
                    b.add(current.right);
                    
            }
            result.add(r);
            a = b;
            b = new ArrayList<TreeNode>();
        }
        return result;
    }
}
