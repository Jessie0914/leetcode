package search;

/**
 * @ClassName Solution74
 * @Description 74.搜索二维矩阵
 * @Author shishi
 * @Date 2019/7/13 20:14
 **/

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数
 *
 * 示例：
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 */
public class Solution74 {
    // 这里用的是暴力法，利用矩阵的性质的话，可以利用二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
