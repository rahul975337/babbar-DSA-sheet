//https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1#

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import helper.TreeNode;

class app10 {

    static ArrayList<Integer> topView(TreeNode root) {
        class Pair {
            TreeNode node;
            int hd;

            Pair(TreeNode node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        Map<Integer, TreeNode> map = new TreeMap<Integer, TreeNode>();

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            if (!map.containsKey(temp.hd))
                map.put(temp.hd, temp.node);

            if (temp.node.left != null)
                q.add(new Pair(temp.node.left, temp.hd - 1));

            if (temp.node.right != null)
                q.add(new Pair(temp.node.right, temp.hd + 1));

        }
        for (Map.Entry<Integer, TreeNode> entry : map.entrySet())
            list.add(entry.getValue().val);

        return list;
    }
}