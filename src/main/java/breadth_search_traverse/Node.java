package breadth_search_traverse;

import java.util.List;

/**
 * @ClassName Node
 * @Description TODO
 * @Author shishi
 * @Date 2019/7/23 19:52
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
