//https://leetcode.com/problems/maximum-depth-of-binary-tree/

import helper.TreeNode;

class app02 {
    int height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }
}