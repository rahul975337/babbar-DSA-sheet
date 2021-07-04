import helpers.HelperFunctions;
import helpers.ListNode;

//https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1#

class app32 {
    ListNode compute(ListNode head) {
        ListNode revHead = HelperFunctions.reverseList(head);
        int maxTillNow = Integer.MIN_VALUE;
        ListNode temp = revHead;

        while (temp.next != null) {
            maxTillNow = Math.max(temp.val, maxTillNow);
            if (temp.next.val < maxTillNow) {
                // remove temp.next
                temp.next = temp.next.next;

            } else
                temp = temp.next;
        }

        head = HelperFunctions.reverseList(revHead);

        return head;
    }
}