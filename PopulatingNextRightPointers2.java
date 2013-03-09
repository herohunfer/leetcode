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
        if (root == null) return;
        if (root.left == null && root.right == null) {
            root.next = null;
            return;
        }
        ArrayList<TreeLinkNode> a = new ArrayList<TreeLinkNode>();
        a.add(root);
        while (a.size() != 0) {
            ArrayList<TreeLinkNode> b = new ArrayList<TreeLinkNode>();
            for (int i = 0; i < a.size(); i++) {
                TreeLinkNode current = a.get(i);
                if (i != a.size()-1) current.next = a.get(i+1);
                else current.next = null;
                if (current.left != null) b.add(current.left);
                if (current.right != null) b.add(current.right);
            }
            a = new ArrayList<TreeLinkNode>(b);
        }
    }
}
