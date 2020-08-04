package jianzhi;

/**
 * @Classname JZ61
 * @Description 请实现两个函数，分别用来序列化和反序列化二叉树
 * @Date 2020/7/24 4:52 下午
 * @Created by chiyue
 */
public class JZ61 {
    int i = -1;

    String Serialize(TreeNode root) {
        if (root == null)
            return "#!";

        return root.val + "!" + Serialize(root.left) + Serialize(root.right);

    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0)
            return null;

        if (i >= str.length())
            return null;

        // 需要先++
        i++;

        String[] split = str.split("!");
        TreeNode root = null;

        if (!split[i].equals("#")) {
            root = new TreeNode(Integer.parseInt(split[i]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        } else
            return null;


        return root;
    }
}
