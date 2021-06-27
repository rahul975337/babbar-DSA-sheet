import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import helper.TreeNode;

//https://leetcode.com/problems/binary-tree-postorder-traversal/

// POSTORDER===> left_subtree=>right_subtree=>root
//RECURSIVE
class app07a {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return list;
    }

    void postOrder(TreeNode root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }
}

// POSTORDER===> left_subtree=>right_subtree=>root
//postorder is done by just reversing the order 
// ITERATIVE
class app07b {
    public List<Integer> postTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                list.add(curr.val);
                curr = curr.right; // Reverse the process of preorder
            } else {
                curr = stack.pop();
                curr = curr.left; // Reverse the process of preorder
            }
        }
        Collections.reverse(list);// Reverse the process of preorder
        return list;
    }
}