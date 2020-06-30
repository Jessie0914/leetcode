package ali_leetcode_daily.tree;

/**
 * @ClassName Solution559
 * @Description 559. N叉树的最大深度
 * @Author shishi
 * @Date 2020/6/27 11:16
 **/
public class Solution559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }

        // 遍历所有的子节点，返回最大的深度+1
        int maxHeight = 0;
        for (Node child : root.children) {
            int depth = maxDepth(child);
            maxHeight = Math.max(maxHeight, depth);
        }
        return maxHeight + 1;
    }
}
