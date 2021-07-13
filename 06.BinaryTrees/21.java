import helper.TreeNode;

//https://practice.geeksforgeeks.org/problems/sum-tree/1#
class app21 {
    boolean isSumTree(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return (root.val == leftSum + rightSum) && isSumTree(root.left) && isSumTree(root.right);

    }

    int sum(TreeNode node) {
        if (node == null)
            return 0;
        return sum(node.left) + node.val + sum(node.right);
    }
}