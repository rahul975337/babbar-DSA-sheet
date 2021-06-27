import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/invert-binary-tree/
import helper.TreeNode;

//RECURSIVE -POSTORDER(DFS)
class app04a {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // swap
        root.left = right;
        root.right = left;
        return root;
    }
}

// ITERATIVE -BFS
class app04b {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            // swapping left and righgt
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        return root;
    }
}