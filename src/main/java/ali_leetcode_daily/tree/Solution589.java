package ali_leetcode_daily.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution589
 * @Description 589. N叉树的前序遍历
 * @Author shishi
 * @Date 2020/6/27 14:00
 **/
public class Solution589 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null)
            return list;

        list.add(root.val);

        for (Node child : root.children) {
            preorder(child);
        }

        return list;
    }
}
