
//https://leetcode.com/problems/balanced-binary-tree/
import helper.TreeNode;
import helper.helperFunctions;

//using the height function  O(n^2)
class app13a {
    boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int lh = helperFunctions.height(root.left);
        int rh = helperFunctions.height(root.right);
        return (Math.abs(lh - rh) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
}

// METHOD 2 ==> by modfying the height(balancedCheckAndHeight) function only,if
// the height returned is not -1 then we return true else false
class app13b {
    boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return balancedCheckAndHeight(root) != -1;
    }

    int balancedCheckAndHeight(TreeNode root) {

        if (root == null)
            return 0;
        int lh = balancedCheckAndHeight(root.left);
        if (lh == -1)
            return -1;
        int rh = balancedCheckAndHeight(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return Math.max(lh, rh) + 1;
    }
}