
//https://leetcode.com/problems/binary-tree-preorder-traversal/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import helper.TreeNode;

//PREORDER===> root=>left_subtree=>right_subtree
//RECURSIVE
class app06a {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return list;
    }

    void preOrder(TreeNode root) {
        if (root == null)
            return;
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}

// PREORDER===> root=>left_subtree=>right_subtree
// ITERATIVE
class app06b {
    public List<Integer> preTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                list.add(curr.val);// Add parent before going to children
                curr = curr.left;
            } else {
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return list;
    }
}