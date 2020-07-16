package jianzhi;

import java.util.ArrayList;

/**
 * @ClassName JZ24
 * @Description 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * @Author shishi
 * @Date 2020/7/15 23:42
 **/
// JZ_MARK
public class JZ24 {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return lists;

        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list, lists, 0, target);

        return lists;
    }

    private void dfs(TreeNode root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> lists, int curNum, int target) {
        if (root == null)
            return;

        // 先加root结点
        list.add(root.val);
        curNum += root.val;

        if (curNum == target && root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
            // 不能加return;语句
        }

        // 递归遍历左子树和右子树
        dfs(root.left, list, lists, curNum, target);

        dfs(root.right, list, lists, curNum, target);

        list.remove(list.size() - 1);
        curNum -= root.val;
    }
}
