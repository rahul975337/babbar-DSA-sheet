import helpers.HelperFunctions;
import helpers.ListNode;

//https://leetcode.com/problems/intersection-of-two-linked-lists/

class app11 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = HelperFunctions.length(headA);
        int lenB = HelperFunctions.length(headB);
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (diff-- > 0 && tempA != null)
                tempA = tempA.next;
        } else {
            while (diff-- > 0 && tempB != null)
                tempB = tempB.next;
        }
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}