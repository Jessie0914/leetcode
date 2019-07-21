package tree.traversal;

/**
 * @ClassName Solution103
 * @Description 103.二叉树的锯齿形层次遍历
 * @Author shishi
 * @Date 2019/7/4 20:35
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Solution103 {
    // 增加一个变量，来控制反转或者不反转，就可以实现锯齿形
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null) return lists;
        helper(root,1);
        int index = 0;
        for (List list : lists){
            if (index%2==0){
                list = list;
            }else {
                Collections.reverse(list);
            }
            index++;
        }
        return lists;
    }

    private void helper(TreeNode root, int level) {
        if (lists.size()<level){
            lists.add(new ArrayList<>());
        }
        lists.get(level-1).add(root.val);
        if (root.left!=null) helper(root.left,level+1);
        if (root.right!=null) helper(root.right,level+1);
    }
}
