
//https://leetcode.com/problems/add-two-numbers/submissions/
import helpers.ListNode;

class app09 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0); /*
                                               * thsi is currently pointing at null hence the list will start from
                                               * dummyNode's next
                                               */

        ListNode curr = dummyNode;
        int sum = 0;
        int carry = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null || temp2 != null) {
            int x = (temp1 != null) ? temp1.val : 0;
            int y = (temp2 != null) ? temp2.val : 0;
            sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}