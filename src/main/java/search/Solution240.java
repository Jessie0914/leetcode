package search;

/**
 * @ClassName Solution240
 * @Description 240.搜索二维矩阵2
 * @Author shishi
 * @Date 2019/7/13 20:18
 **/

public class Solution240 {
    // 我用的都是暴力法，没有用到这二维矩阵的具体性质
    // 从右上角开始, 比较 target 和 matrix[i][j] 的值。如果小于 target , 则该行不可能有此数, 所
    // 以 i++ ; 如果大于 target , 则该列不可能有此数, 所以 j-- 。遇到边界则表明该矩阵不含 target .
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
