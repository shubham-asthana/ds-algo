package com.programming.dsalgo.patterns.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javafx.util.Pair;

public class MaxDepthBinaryTee {

    // Recursive DFS
    public int maxDepth1(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }

    // BFS
    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return level;
    }

    // Iterative DFS
    public int maxDepth3(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int res = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> curr = stack.pop();
            TreeNode node = curr.getKey();
            int depth = curr.getValue();

            if (node != null) {
                res = Math.max(res, depth);
                stack.push(new Pair<>(node.left, depth + 1));
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }
        return res;
    }
}
