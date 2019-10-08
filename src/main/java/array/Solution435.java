package array;

/**
 * @ClassName Solution435
 * @Description 435. 无重叠区间
 * @Author shishi
 * @Date 2019/9/26 14:08
 **/

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 先将这数组按照end从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count = 0;
        // 一直取end最小的一个
        int i=0;
        while (i<intervals.length){
            int j=i+1;
            // 只要start比i的end小就会冲突
            while (j<intervals.length&&intervals[j][0]<intervals[i][1]){
                count++;
                j++;
            }
            i = j;
        }
        return count;
    }
}
