import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import helper.TreeNode;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

//METHOD 1 ==> by reverseing the inner list alternatively
class app12a {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean LtoR = false;
        while (!q.isEmpty()) {
            int count = q.size();
            List<Integer> inList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode curr = q.poll();
                inList.add(curr.val);

                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            if (LtoR)
                Collections.reverse(inList);
            LtoR = !LtoR;
            list.add(inList);
        }

        return list;
    }
}

// METHOD 2 ==> by using a stack for reversal of the alternate inner lists
class app12b {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean LtoR = false;
        while (!q.isEmpty()) {
            int count = q.size();
            List<Integer> inList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode curr = q.poll();
                if (LtoR == true)
                    stack.push(curr.val);
                else
                    inList.add(curr.val);
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            if (LtoR == true) {
                while (!stack.isEmpty())
                    inList.add(stack.pop());
            }
            LtoR = !LtoR;
            list.add(inList);
        }

        return list;
    }
}
