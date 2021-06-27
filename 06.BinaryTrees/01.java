
//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import helper.TreeNode;

class app01 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null)
            return res;
        q.offer(root);

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
            res.add(inList);

        }

        Collections.reverse(res);
        return res;

    }
}