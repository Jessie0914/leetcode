package ali_leetcode_daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution454
 * @Description 454. 四数相加 II
 * @Author shishi
 * @Date 2020/6/26 12:28
 **/
public class Solution454 {
    int n;
    // 专门用来存AB任意两个数之间的和(key)，value为count
    Map<Integer, Integer> map_AB_sum = new HashMap<>();

    int result = 0;

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map_AB_sum.containsKey(A[i] + B[j])) {
                    map_AB_sum.put(A[i] + B[j], map_AB_sum.get(A[i] + B[j]) + 1);
                } else {
                    map_AB_sum.put(A[i] + B[j], 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map_AB_sum.containsKey(-(C[i] + D[j]))) {
                    result += map_AB_sum.get(-(C[i] + D[j]));
                }
            }
        }

        return result;
    }
}
