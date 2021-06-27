//https://leetcode.com/problems/diameter-of-binary-tree/

import helper.TreeNode;
import helper.helperFunctions;

class app03 {
    int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int d1 = helperFunctions.height(root.left) + helperFunctions.height(root.right);
        int d2 = diameterOfBinaryTree(root.left);
        int d3 = diameterOfBinaryTree(root.right);

        return Math.max(d1, Math.max(d2, d3));

    }
}