package breadth_search_traverse;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution559
 * @Description 559.N叉树的最大深度
 * @Author shishi
 * @Date 2019/7/24 9:17
 **/
public class Solution559 {
    // 递归
    public int maxDepth(Node root) {
        if (root==null) return 0;
        int maxDepth = 0;
        for (Node node : root.children){
            int depth = maxDepth(node);
            maxDepth = Math.max(depth,maxDepth);
        }
        return maxDepth+1;
    }

    // 层序遍历，边遍历边记录层数就是最大深度
    public int maxDepth2(Node root) {
        if (root==null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;
        while (!queue.isEmpty()){
            // 当前层有几个结点
            int size = queue.size();
            while (size>0){
                size--;
                Node poll = queue.poll();
                // 把推出去的当前节点的所有子节点入队
                for (Node cur : poll.children){
                    if (cur!=null){
                        queue.offer(cur);
                    }
                }
            }
            // 遍历完一层深度就+1
            maxDepth++;
        }
        return maxDepth;
    }
}
