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
        populateNext(sentinel, root);
    }
    public void populateNext(TreeLinkNode parent, TreeLinkNode root) {
        if (root == null) return;
        
        if (parent.left != root && parent.right != root) {
            root.next = null;
        }
        else {
            if (parent.left == root) {
                root.next = parent.right;
            } else {
                TreeLinkNode parent_next = parent.next;
                if (parent_next == null) root.next = null;
                else root.next = (parent_next.left == null)?parent_next.right:parent_next.left;
            }
        }
        populateNext(root, root.left);
        populateNext(root, root.right);
    }
}
