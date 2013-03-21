/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int val = 0;
        if (head == null || head.next == null) return head;
        ListNode current = head;
        val = head.val;
        while (current.next != null) {
            if (val != current.next.val) {
                val = current.next.val;
                current = current.next;
            }
            else {
                current.next = current.next.next;
            }
        }
        return head;
    }
}
