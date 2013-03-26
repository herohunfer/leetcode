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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return createBST(num, 0, num.length-1);
    }
    public TreeNode createBST(int[] num, int left, int right) {
        if (left > right) return null;
        int medium = (left+right)/2;
        TreeNode current = new TreeNode(num[medium]);
        current.left = createBST(num, left, medium-1);
        current.right = createBST(num, medium+1, right);
        return current;
        
    }
}
