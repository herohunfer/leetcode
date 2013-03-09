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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) return null;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        remove(sentinel, n);
        return sentinel.next;
    }
    public int remove(ListNode current, int n) {
        if (current.next == null) return (n-1);
        n = remove(current.next, n);
        if (n == 0) 
            if (current.next.next == null) current.next = null;
            else current.next = current.next.next;
        return (n-1);
    }
}
