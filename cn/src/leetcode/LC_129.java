package leetcode;

import java.util.ArrayList;
import java.util.List;

//求根节点到叶节点数字之和
//        已解答
//        中等
//        相关标签
//        相关企业
//        给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
//        每条从根节点到叶节点的路径都代表一个数字：
//
//        例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
//        计算从根节点到叶节点生成的 所有数字之和 。
//
//        叶节点 是指没有子节点的节点。
//
//
//
//        示例 1：
//
//
//        输入：root = [1,2,3]
//        输出：25
//        解释：
//        从根到叶子节点路径 1->2 代表数字 12
//        从根到叶子节点路径 1->3 代表数字 13
//        因此，数字总和 = 12 + 13 = 25
//        示例 2：
//
//
//        输入：root = [4,9,0,5,1]
//        输出：1026
//        解释：
//        从根到叶子节点路径 4->9->5 代表数字 495
//        从根到叶子节点路径 4->9->1 代表数字 491
//        从根到叶子节点路径 4->0 代表数字 40
//        因此，数字总和 = 495 + 491 + 40 = 1026
//
//
//        提示：
//
//        树中节点的数目在范围 [1, 1000] 内
//        0 <= Node.val <= 9
//        树的深度不超过 10
public class LC_129 {
    public int sumNumbers(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        List<Integer> allNodes = new ArrayList<>();
        dfs(root, temp, allNodes);
        return allNodes.stream().mapToInt(Integer::intValue).sum();
    }

    private void dfs(TreeNode root, List<Integer> temp, List<Integer> allNodes) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            //已经递归到叶子节点，取值处理
            StringBuffer sb = new StringBuffer();
            for (Integer tempNode : temp) {
                sb.append(tempNode);
            }
            allNodes.add(Integer.valueOf(sb.toString()));
        }
        dfs(root.left, temp, allNodes);
        dfs(root.right, temp, allNodes);
        temp.remove(temp.size() - 1);
    }
}

