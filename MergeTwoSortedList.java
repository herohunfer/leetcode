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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode sentinel = new ListNode(-1);
        ListNode current = sentinel;
        while(l1 != null || l2 != null) {
            while (l1 == null && l2 != null) {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
            while (l1 != null && l2 == null) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            }
            if (l1 == null || l2 == null) break;
            if (l1.val < l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }
        return sentinel.next;
    }
}
