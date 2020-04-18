package cyc.algorithm.dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode
 * @description: 646. 最长数对链
 * @author: shishi
 * @create: 2019-12-06 13:17
 **/

public class Number646 {
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        if (len == 0) return 0;

        // 先按照数对的第一位从小到大排序
        // 因为本题是"按照任意顺序"
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[len - 1];
    }
}
