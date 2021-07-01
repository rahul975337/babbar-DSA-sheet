
//https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1
import helpers.ListNode;

class app10 {
    public static ListNode findIntersection(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.val == temp2.val) {
                curr.next = temp1;
                curr = curr.next;
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else if (temp1.val < temp2.val)
                temp1 = temp1.next;
            else if (temp1.val > temp2.val)
                temp2 = temp2.next;

        }
        return dummyHead.next;
    }
}