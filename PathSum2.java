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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        
        ArrayList<Integer> c = new ArrayList<Integer>();
        c.add(root.val);
        path(root, sum, result, c);
        return result;
    }    
    public void path(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> c) {
        ArrayList<Integer> current = new ArrayList<Integer>(c);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        if (root.left != null) {
            current.add(root.left.val);
            path(root.left, sum-root.val, result, current);
            current.remove(current.size()-1);
        }
        if (root.right != null) {
            current.add(root.right.val);
            path(root.right, sum-root.val, result, current);
            current.remove(current.size()-1);
        }
    }
}
