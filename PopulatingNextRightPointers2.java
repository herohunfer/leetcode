// similar to 1, but need be sure before going to next level be sure current level is finished. Very similar strategy as iterative deepening.

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeLinkNode sentinel = new TreeLinkNode(Integer.MIN_VALUE+1);
        int depth = maxDepth(root);
        for (int i = 1; i <= depth; i++)
            populateNext(null, root, i, 1);
    }
    public int maxDepth(TreeLinkNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;
        return Math.max(left,right);
    }
    public void populateNext(TreeLinkNode parent, TreeLinkNode root, int limit, int level) {
        if (root == null) return;
        if (limit == level) {
            if (parent == null) {
                root.next = null;
            }
            else {
                if (parent.left == root && parent.right != null) {
                    root.next = parent.right;
                } else {
                    //root.next is originally equal to null
                    TreeLinkNode parent_nexts = parent.next;
                    while (parent_nexts != null) {
                        root.next = ((parent_nexts.left == null)? parent_nexts.right:parent_nexts.left);
                        if (root.next == null) parent_nexts = parent_nexts.next; 
                        else break;
                    }
                }
            }
        }
        else {
            populateNext(root, root.left, limit, level+1);
            populateNext(root, root.right, limit, level+1);
        }
    }
}
