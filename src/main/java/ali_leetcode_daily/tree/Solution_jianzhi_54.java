package ali_leetcode_daily.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_jianzhi_54
 * @Description 剑指 Offer 54. 二叉搜索树的第k大节点
 * @Author shishi
 * @Date 2020/6/27 14:27
 **/
public class Solution_jianzhi_54 {
    // 是最简单粗暴的方法，但是最好还是遍历到k个节点就停止
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        helper(root, list);
        return list.get(list.size() - k);
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    // 遍历到第K个节点就结束
    // 形参不会因为dfs而改变，所以需要类变量
    int k = 0;
    int result = 0;

    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        traverse(root);
        return result;
    }

    private void traverse(TreeNode root) {
        if (root == null || k == 0)
            return;

        traverse(root.right);

        // 做一个额外的判断，说明到达了终点
        if (k == 1) {
            result = root.val;
            k = 0;
            return;
        }

        // 如果还没到终点，那么就--
        k--;

        traverse(root.left);
    }
}
