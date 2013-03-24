//very elegant. result.add(null) is the key in this game.
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
         return generate(1, n);
    }
    public ArrayList<TreeNode> generate(int left, int right) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (left > right) {result.add(null); return result;}
        for (int i = left; i <= right; i++) {
            ArrayList<TreeNode> left_solution = generate(left, i-1);
            ArrayList<TreeNode> right_solution = generate(i+1, right);
            for (TreeNode left_node : left_solution)
                for(TreeNode right_node: right_solution) {
                    TreeNode root = new TreeNode(i);
                    root.left = left_node;
                    root.right = right_node;
                    result.add(root);
                }
            
        }
        return result;
        
    }
}
