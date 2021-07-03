import helpers.ListNode;

//https://practice.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1#

class app19 {
    public static ListNode reverseDLL(ListNode head) {
        if (head == null)
            return null;
        ListNode curr = head;
        ListNode new_head = head;

        while (curr != null) {
            // swapping prev with next
            ListNode prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            // maintaining the new head
            new_head = curr;
            // this is actually the next but as we have reversed it,it has now become the
            // prev
            curr = curr.prev;
        }

        return new_head;
    }
}