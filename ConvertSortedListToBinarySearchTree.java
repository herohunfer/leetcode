/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) return null;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        return createBST(head, last);
    }
    public TreeNode createBST(ListNode left, ListNode right) {
        if (left == right) return new TreeNode(left.val);
        int count = 0;
        ListNode current = left;
        while (current != null && current != right) {
            count++;
            current = current.next;
        }
        if (current == null) return null;
        
        int medium = count/2;
        ListNode middle = left;
        for (int i = 0; i < medium-1; i++) {
            middle = middle.next;
        }
        TreeNode now = new TreeNode(middle.next.val);
        now.left = createBST(left, middle);
        now.right = createBST(middle.next.next, right);
        return now;
    }
}
