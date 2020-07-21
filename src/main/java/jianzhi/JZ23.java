package jianzhi;

/**
 * @ClassName JZ23
 * @Description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * @Author shishi
 * @Date 2020/7/15 0:03
 **/
public class JZ23 {
    // BST树的性质决定了后序遍历的最后一位树是中位数
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;

        return judge(sequence, 0, sequence.length - 1);
    }

    private boolean judge(int[] sequence, int i, int j) {
        if (i >= j)
            return true;

        // 中位数
        int middleNum = sequence[j];

        // 从后往前找第一个小于中位数的下标
        int index = findFirstLessThanMiddleName(middleNum, sequence, i, j);

        // 要保证i~index之间的数都小于middleNum
        for (int k = i; k < index; k++) {
            if (sequence[k] > middleNum)
                return false;
        }

        if (index != -1) {
            // 递归判断左子树和右子树
            return judge(sequence, i, index - 1) && judge(sequence, index + 1, j);
        } else
            return true;
    }

    private int findFirstLessThanMiddleName(int middleNum, int[] sequence, int i, int j) {
        for (int p = j; p >= i; p--) {
            if (middleNum > sequence[p])
                return p;
        }
        return -1;
    }
}
