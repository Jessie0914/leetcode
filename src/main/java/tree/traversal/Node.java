package tree.traversal;

/**
 * @ClassName Node
 * @Description 116、117需要的节点定义类
 * @Author shishi
 * @Date 2019/7/9 17:53
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
