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
        ListNode sentinel = new ListNode(Integer.MIN_VALUE+1);
        sentinel.next = head;
        ListNode previous = sentinel;
        ListNode current = head;
        if (head == null || head.next == null) return head;
        int val = head.val;
        while (current != null && current.next != null) {
            if (current.next.val != val) {
                val = current.next.val;
                previous = current;
                current = current.next;
            }
            else {
                while (current.next != null && current.next.val == val)
                    current = current.next;
                previous.next = current.next;
                current = current.next;
                if (current != null) val = current.val;
            }
        }
        return sentinel.next;
    }
}
