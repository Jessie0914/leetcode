package ali_leetcode_daily.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution590
 * @Description 590. N叉树的后序遍历
 * @Author shishi
 * @Date 2020/6/27 13:56
 **/
public class Solution590 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null)
            return list;
        for (Node child : root.children) {
            postorder(child);
        }
        list.add(root.val);

        return list;
    }
}
