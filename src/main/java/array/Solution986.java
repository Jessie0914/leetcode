package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 986. 区间列表的交集
 * @author: shishi
 * @create: 2019-10-29 16:53
 **/

/**
 * 输入：A = [[0,2],[5,10],[13,23],[24,25]]
 *      B = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 */
public class Solution986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> lists = new ArrayList<>();

        int i=0,j=0;
        while (i<A.length&&j<B.length){
            // 起点以两者之间后开始的那个为起点
            int start = Math.max(A[i][0],B[j][0]);
            // 终点以两者之间先结束的那个为终点
            int end = Math.min(A[i][1],B[j][1]);

            // 比较两者大小
            if (start<=end){
                int[] nums = new int[2];
                nums[0] = start;
                nums[1] = end;
                lists.add(nums);
            }

            // 比较A的end和B的end，哪个先结束，就往后移一个（相当于删除）
            if (A[i][1]<B[j][1]){
                i++;
            }
            else {
                j++;
            }

        }

        return lists.toArray(new int[lists.size()][2]);
    }
}
