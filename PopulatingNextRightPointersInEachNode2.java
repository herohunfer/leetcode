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
        populateNext(root, root.left);
        populateNext(root, root.right);
    }
}
