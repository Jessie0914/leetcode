package breadth_search_traverse;

/**
 * @ClassName Solution429
 * @Description 429.N叉树的层序遍历
 * @Author shishi
 * @Date 2019/7/23 19:50
 **/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 可以参考102题（二叉树的层序遍历），都是类似的
 */
public class Solution429 {
    // 定义一个全局变量
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        // 递归的终止条件
        if (root==null) return result;
        // 层序遍历，带上当前的层数参数
        bfs(root,1);
        return result;
    }

    private void bfs(Node node, int level) {
        // 当result的size，小于当前的层数时，需要添加一个新的List
        if (result.size()<level){
            result.add(new ArrayList<>());
        }

        // 把当前节点放到result中对应的list中
        result.get(level-1).add(node.val);

        // 找到当前节点的所有子节点（唯一和二叉树不同的地方）
        List<Node> children = node.children;
        Iterator<Node> iterator = children.iterator();
        // 迭代子节点
        while (iterator.hasNext()){
            Node curNode = iterator.next();
            // 递归，并将子节点的level+1
            bfs(curNode,level+1);
        }
    }
}
