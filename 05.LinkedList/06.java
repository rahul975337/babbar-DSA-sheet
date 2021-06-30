import java.util.HashSet;
import java.util.LinkedHashSet;

import helpers.ListNode;

//https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1#
class app06 {

    public ListNode removeDuplicates(ListNode head) {
        HashSet<Integer> set = new LinkedHashSet<>();
        if (head == null)
            return null;
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            if (set.contains(temp.val))
                prev.next = temp.next;
            else {
                set.add(temp.val);
                prev = temp;
            }
            temp = temp.next;
        }
        return head;

    }
}