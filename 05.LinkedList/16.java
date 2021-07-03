
//https://practice.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1#
import helpers.ListNode;

class app16 {
    void splitList(circular_LinkedList list) {
        ListNode head = list.head;
        ListNode slow = list.head;
        ListNode fast = list.head;
        if (slow == null)
            return;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        if (fast.next != head)
            fast = fast.next;
        list.head1 = head;
        list.head2 = mid.next;
        mid.next = head;
        fast.next = list.head2;
    }
}

class circular_LinkedList {
    // correct implementation for circular lists is on gfg
    ListNode head, head1, head2;

}