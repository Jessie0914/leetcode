package Depth_search_traverse;

/**
 * @ClassName Solution897
 * @Description 897.递增顺序查找树
 * @Author shishi
 * @Date 2019/7/27 10:55
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个树，按中序遍历重新排列树，
 * 使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 */
public class Solution897 {

    // 根据中序遍历list，构造一个只有右子树的树
    public TreeNode increasingBST(TreeNode root) {
        if (root==null) return null;

        List<Integer> inoderList = inorderTraverse(root);
        // 树根
        TreeNode node = new TreeNode(inoderList.get(0));
        TreeNode pre = node;
        for (int i=1;i<inoderList.size();i++){
            // 创建一个新节点
            TreeNode cur = new TreeNode(inoderList.get(i));
            // 和前面的连接起来
            pre.right = cur;
            // 再把cur赋给pre，方便后续节点的连接
            pre = cur;
        }
        return node;
    }

    // 中序遍历树根，返回一个中序遍历序列
    private List<Integer> inorderTraverse(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root==null) return list;
        list.addAll(inorderTraverse(root.left));
        list.add(root.val);
        list.addAll(inorderTraverse(root.right));
        return list;
    }
}
