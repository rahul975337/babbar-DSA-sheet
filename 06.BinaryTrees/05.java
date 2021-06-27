
//https://leetcode.com/problems/binary-tree-inorder-traversal/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import helper.TreeNode;

//INORDER ===>  left_subtree => root => right_subtree
//RECURSIVE
class app05a {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return list;
    }

    void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}

// INORDER ===> left_subtree => root => right_subtree
// ITERATIVE
class app05b {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                list.add(curr.val);// Add after all left children
                curr = curr.right; // do the above loop for right subtree of the current
            }
        }
        return list;
    }
}