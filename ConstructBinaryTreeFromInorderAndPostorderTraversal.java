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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (inorder == null || inorder.length == 0) return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int position = 0;
        while (inorder[position] != postorder[postorder.length-1]) {
            position++;
        }
        //left side
        if (position > 0) {
            int [] lInorder = Arrays.copyOfRange(inorder, 0, position);
            int [] lPostorder = Arrays.copyOfRange(postorder, 0, position);
            root.left = buildTree(lInorder, lPostorder);
        }
        //right side
        if (position < inorder.length-1) {
            int [] rInorder = Arrays.copyOfRange(inorder, position+1, inorder.length);
            int [] rPostorder = Arrays.copyOfRange(postorder, position, postorder.length-1);
            root.right = buildTree(rInorder, rPostorder);
        }
        return root;
    }
}
