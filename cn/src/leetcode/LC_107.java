package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的层序遍历 II
//        已解答
//        中等
//        相关标签
//        相关企业
//        给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
//
//
//        示例 1：
//
//
//        输入：root = [3,9,20,null,null,15,7]
//        输出：[[15,7],[9,20],[3]]
//        示例 2：
//
//        输入：root = [1]
//        输出：[[1]]
//        示例 3：
//
//        输入：root = []
//        输出：[]
//
//
//        提示：
//
//        树中节点数目在范围 [0, 2000] 内
//        -1000 <= Node.val <= 1000

public class LC_107 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(15, null, null);
        TreeNode node4 = new TreeNode(7, null, null);
        TreeNode node1 = new TreeNode(9, null, null);
        TreeNode node2 = new TreeNode(20, node3, node4);
        TreeNode root = new TreeNode(3, node1, node2);

        List<List<String>> res = bfsV1(root);
        System.out.println(res.toString());
        res = bfsV2(root);
        System.out.println(res.toString());


    }

    //解法一：使用递归
    public static List<List<String>> bfsV1(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        bfsV1Handle(root, res, 0);//0代表根节点的层级
        return res;
    }

    private static void bfsV1Handle(TreeNode root, List<List<String>> res, int level) {
        if (root == null) {
            return;
        }
        List<String> temp = new ArrayList<>();
        if (res.size() <= level) {//控制层级
            res.add(temp);
        }
        res.get(level).add(root.val + "");
        bfsV1Handle(root.left, res, level + 1);
        bfsV1Handle(root.right, res, level + 1);
    }

    //解法二：使用队列
    public static List<List<String>> bfsV2(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            List<String> temp = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                temp.add(node.val + "");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            res.add(temp);


        }
        return res;
    }
}

