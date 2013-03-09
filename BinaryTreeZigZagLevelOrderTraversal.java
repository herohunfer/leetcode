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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        ArrayList<TreeNode> a = new ArrayList<TreeNode>();
        ArrayList<TreeNode> b = new ArrayList<TreeNode>();
        a.add(root);
        int level = 0;
        
        while (!a.isEmpty()) {
            ArrayList<Integer> r = new ArrayList<Integer>();
            for (TreeNode current: a) {
                r.add(current.val);
                if (level % 2 == 1) {
                    if (current.right != null)
                        b.add(0, current.right);
                    if (current.left != null)
                        b.add(0, current.left);
                }
                else {
                    if (current.left != null)
                        b.add(0, current.left);
                    if (current.right != null)
                        b.add(0, current.right);
                }
                    
            }
            level++;
            result.add(r);
            a = b;
            b = new ArrayList<TreeNode>();
        }
        return result;
    }
}
