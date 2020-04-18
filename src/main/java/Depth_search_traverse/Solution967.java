package Depth_search_traverse;

/**
 * @ClassName Solution967
 * @Description 967. 连续差相同的数字
 * @Author shishi
 * @Date 2019/10/10 9:43
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。
 * 输入：N = 3, K = 7
 * 输出：[181,292,707,818,929]
 * <p>
 * 输入：N = 2, K = 1
 * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 */
public class Solution967 {

    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1)
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            DFS(list, 1, i, i, N, K);
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = (int) list.get(i);
        }
        return nums;
    }

    private void DFS(List list, int nowN, int temp, int nowSum, int N, int K) {
        if (nowN == N) {
            list.add(nowSum);
            return;
        }

        if (nowN > N) return;

        // 如果不加上K！=0，那么这里会遍历一遍，下面的if也会遍历一遍，就会造成重复
        // 或者专门把K==0的情况提出来，特判返回也可以
        if (temp + K < 10 && K != 0) {
            DFS(list, nowN + 1, temp + K, nowSum * 10 + (temp + K), N, K);
        }

        if (temp - K >= 0) {
            DFS(list, nowN + 1, temp - K, nowSum * 10 + (temp - K), N, K);
        }
    }
}
