package _tree._binary_tree._919;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: 67ng
 * @Date: 2020/5/8
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        CBTInserter obj = new CBTInserter(node);
        int param_1 = obj.insert(1);
        TreeNode param_2 = obj.get_root();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class CBTInserter {

    TreeNode root;
    Deque<TreeNode> deque;

    public CBTInserter(TreeNode root) {
        this.root = root;
        deque = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        // BFS to populate deque
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null)
                deque.offerLast(node);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left == null)
            node.left = deque.peekLast();
        else {
            node.right = deque.peekLast();
            deque.pollFirst();
        }

        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

