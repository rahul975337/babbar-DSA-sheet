
//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//ITERATIVE
class app08a {
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
                if (i == 0)
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
class app08b {
    int maxLevel = 0;

    ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        leftViewUtil(root, list, 1);
        return list;
    }

    void leftViewUtil(TreeNode root, ArrayList<Integer> list, int level) {
        if (root == null)
            return;
        if (maxLevel < level) {
            list.add(root.val);
            maxLevel = level;
        }
        leftViewUtil(root.left, list, level + 1);
        leftViewUtil(root.right, list, level + 1);

    }

}