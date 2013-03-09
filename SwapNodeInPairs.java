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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode current  = sentinel;
        while (current.next != null && current.next.next != null) {
            ListNode temp = current.next.next;
            current.next.next = current.next.next.next;
            temp.next = current.next;
            current.next = temp;
            //done
            current = current.next.next;
        
        }
        return sentinel.next;
    }
}
