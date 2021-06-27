
//https://leetcode.com/problems/binary-tree-right-side-view/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import helper.TreeNode;

//ITERATIVE
class app09a {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.isEmpty() == false) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode curr = q.poll();
                if (i == count - 1)
                    list.add(curr.val);
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
        }
        return list;
    }
}

// RECURSIVE
// NOTE: In left view we called for left first and in right view we call for
// right first
class app09b {
    int maxLevel = 0;

    ArrayList<Integer> rightView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        rightViewUtil(root, list, 1);
        return list;
    }

    void rightViewUtil(TreeNode root, ArrayList<Integer> list, int level) {
        if (root == null)
            return;
        if (maxLevel < level) {
            list.add(root.val);
            maxLevel = level;
        }
        rightViewUtil(root.right, list, level + 1);
        rightViewUtil(root.left, list, level + 1);
    }
}