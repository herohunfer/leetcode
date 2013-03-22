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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) return head;
        //set sentinel
        ListNode sentinel = new ListNode(Integer.MIN_VALUE+1);
        sentinel.next = head;
        //set pre list
        ListNode before = sentinel;
        if (head.val < x) before = head;
        ListNode current = head;
        
        while (current.next != null) {
            if (current.next.val < x) {
                //filter out the direct follow case
                // 1->1, x=2
                if (current.next == before.next) {
                    before = before.next;
                    current = current.next;
                    continue;
                }
                ListNode next = current.next.next;
                // fix pre list
                current.next.next = before.next;
                before.next = current.next;
                before = before.next;
                // fix post list
                current.next = next;
            }
            else current = current.next;
        }
        return sentinel.next;
    }
}
