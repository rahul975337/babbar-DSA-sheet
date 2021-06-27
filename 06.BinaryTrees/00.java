
//https://leetcode.com/problems/binary-tree-level-order-traversal/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import helper.TreeNode;

class app00 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (q.isEmpty() == false) {
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
            list.add(inList);
        }
        return list;
    }
}