package leetcode;

import java.util.ArrayList;
import java.util.List;

//98. 验证二叉搜索树
//        已解答
//        中等
//        相关标签
//        相关企业
//        给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
//        有效 二叉搜索树定义如下：
//
//        节点的左子树只包含 小于 当前节点的数。
//        节点的右子树只包含 大于 当前节点的数。
//        所有左子树和右子树自身必须也是二叉搜索树。
//
//
//        示例 1：
//
//
//        输入：root = [2,1,3]
//        输出：true
//        示例 2：
//
//
//        输入：root = [5,1,4,null,null,3,6]
//        输出：false
//        解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//        提示：
//
//        树中节点数目范围在[1, 104] 内
//        -231 <= Node.val <= 231 - 1
public class LC_98 {

    public boolean isValidBST(TreeNode root) {
        //直接终须遍历看是否是按照升序排列的即可
        List<Integer> nodeValList = new ArrayList<>();
        dfs(root,nodeValList);
        for (int i = 1; i < nodeValList.size(); i++) {
            if(nodeValList.get(i)<nodeValList.get(i-1)){
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> nodeValList) {
        if(root==null){
            return;
        }
        if(root.left!=null){
            dfs(root.left,nodeValList);
        }
        nodeValList.add(root.val);
        if(root.right!=null){
            dfs(root.right,nodeValList);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
