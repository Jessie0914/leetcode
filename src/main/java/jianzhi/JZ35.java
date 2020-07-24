package jianzhi;

/**
 * @Classname JZ35
 * @Description 输入一个数组, 求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @Date 2020/7/24 1:38 下午
 * @Created by chiyue
 */
public class JZ35 {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        return helper(array, 0, array.length - 1) % 1000000007;
    }

    private int helper(int[] array, int i, int j) {
        if (i >= j)
            return 0;

        int mid = (i + j) / 2;
        int left = helper(array, i, mid) % 1000000007;
        int right = helper(array, mid + 1, j) % 1000000007;
        return left + right + merge(array, i, mid, mid + 1, j);
    }

    // 归并
    private int merge(int[] array, int s1, int e1, int s2, int e2) {
        if (s1 > e1 || s2 > e2)
            return 0;

        int count = 0;
        int p = s1;

        int i = 0;
        int[] tmp = new int[e2 - s1 + 1];

        // 归并两个已经有序的数组
        while (s1 <= e1 && s2 <= e2) {
            // 就代表不是逆序
            if (array[s1] <= array[s2]) {
                tmp[i++] = array[s1++];
            }
            // 有逆序对
            else {
                count += e1 - s1 + 1;
                count = count % 1000000007;
                tmp[i++] = array[s2++];
            }
        }

        while (s1 <= e1) {
            tmp[i++] = array[s1++];
        }
        while (s2 <= e2) {
            tmp[i++] = array[s2++];
        }

        // 归并过的数组重新复制回原来的数据
        for (int k = 0; k < tmp.length; k++) {
            array[p++] = tmp[k];
        }

        return count%1000000007;
    }
}
