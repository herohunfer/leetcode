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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (inorder == null || inorder.length == 0) return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        int position = 0;
        while (inorder[position] != preorder[0]) {
            position++;
        }
        //left side
        if (position > 0) {
            int [] lPreorder = Arrays.copyOfRange(preorder, 1, 1+position);
            int [] lInorder = Arrays.copyOfRange(inorder, 0, position);
            root.left = buildTree(lPreorder, lInorder);
        }
        //right side
        if (position < inorder.length-1) {
            int [] rPreorder = Arrays.copyOfRange(preorder, 1+position, preorder.length);
            int [] rInorder = Arrays.copyOfRange(inorder, position+1, inorder.length);
            root.right = buildTree(rPreorder, rInorder);
        }
        return root;
    }
}
