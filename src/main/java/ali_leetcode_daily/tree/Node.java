package ali_leetcode_daily.tree;

import java.util.List;

/**
 * @ClassName Node
 * @Description TODO
 * @Author shishi
 * @Date 2020/6/27 11:16
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
