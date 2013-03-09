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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null && l2 == null) return null;
        ListNode head = new ListNode(0);
        int carry = 0;
        ListNode current = head;
        while (l1 != null || l2 != null)
        {
            if (l1 != null && l2 != null) {
                current.next = new ListNode((l1.val + l2.val + carry) % 10);
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1 != null) {
                current.next = new ListNode((l1.val + carry) % 10);
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
            }
            else {
                current.next = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (carry > 0) current.next = new ListNode(carry);
        head = head.next;
        return head;
    }
}
