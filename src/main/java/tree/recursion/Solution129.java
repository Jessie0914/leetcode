package tree.recursion;

/**
 * @ClassName Solution129
 * @Description 129.求根到叶子节点数字之和
 * @Author shishi
 * @Date 2019/7/11 21:01
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 */
public class Solution129 {
    // 我是借鉴113题目的思路
    // 就是根据根节点，遍历所有的路径，存放到List<List>中
    // 最后遍历List中的list，计算每一个list的总和，最后加一起就可以了
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        findPath(root,cur,result);

        int sum = 0;
        for (List list : result){
            int count = 0;
            for (Object i : list){
                count = count*10 + (int)i;
            }
            sum += count;
        }
        return sum;
    }

    private void findPath(TreeNode root, List<Integer> cur, List<List<Integer>> result) {
        if (root==null) return;
        cur.add(root.val);
        // 遍历到叶子节点了
        if (root.left==null && root.right==null){
            result.add(new ArrayList<>(cur));
        }
        else {
            findPath(root.left,cur,result);
            findPath(root.right,cur,result);
        }
        // 当前节点的左子树和右子树都已经遍历完了，就回退
        cur.remove(cur.size()-1);
    }
}
